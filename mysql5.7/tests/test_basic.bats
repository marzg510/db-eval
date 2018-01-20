#!/usr/bin/env bats

DB_PASSWD=mysql
DB_CMD="mysql -h dbsvr -u root -p${DB_PASSWD} user01"

#setup() {
#;
#}

#teardown() {
#  run ${DB_CMD} -e "drop table if exists t1,t2"
#}

@test "show databases" {
  run mysql -h dbsvr -u root -p${DB_PASSWD} -e "show databases"
  [ "$status" -eq 0 ]
  [[ "$output" =~ "user01" ]]
}

@test "create table t1" {
  run ${DB_CMD} -e "drop table if exists t1,t2"
  run ${DB_CMD} <create_table_t1.sql
  [ "$status" -eq 0 ]
}

@test "insert and select" {
  run ${DB_CMD} <insert_into_t1.sql
  [ "$status" -eq 0 ]
  run ${DB_CMD} -e "select count(*) from t1"
  [ "$status" -eq 0 ]
#  [[ "$output" =~ "3 |" ]]
}

