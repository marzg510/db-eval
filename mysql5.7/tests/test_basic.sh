#!/bin/bash

DB_PASSWD=mysql
DB_CMD="mysql -h dbsvr -u root -p${DB_PASSWD} user01"

TESTS=0
FAILED=0
TESTNAME=""
function failed() {
  echo "failed"
  let FAILED++
}
function describe() {
  let TESTS++
  TESTNAME=$(echo $1 | sed -e 's/ /-/g')
  echo "case:${TESTS} $1"
}
function evidence() {
  [ "$1" == "" ] && ADDNAME="" || ADDNAME="_$1"
  cat >"evi_${TESTS}_${TESTNAME}${ADDNAME}.log"
}

describe "show databases"
$DB_CMD -e "show databases" | evidence
[ $? -ne 0 ] && failed
[[ "$output" =~ "user01" ]] && failed

describe "create table t1"
${DB_CMD} -e "drop table if exists t1" | evidence "drop"
${DB_CMD} <create_table_t1.sql | evidence
[ $? -ne 0 ] && failed


describe "insert and select"
#${DB_CMD} <insert_into_t1.sql | evidence "ins"
#[ $? -ne 0 ] && failed
#${DB_CMD} -e "select count(*) from t1" | evidence "count"
#[ $? -ne 0 ] && failed
#[[ "$output" =~ "3 |" ]] && failed
#${DB_CMD} -e "select * from t1" | evidence "select"
#[ $? -ne 0 ] && failed

echo "Total: $TESTS tests, $FAILED failures"
exit

