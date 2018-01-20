# MySQL 5.7

## setup server

### Vagrant
```
vagrant up
vagrant ssh
hogehoge
```

### Docker
```
docker build -t m510.net/mysql-eval:5.7 .
#docker pull mysql:5.7
#docker run -d --rm --name mysql -e MYSQL_ROOT_PASSWORD=mysql -p 3306:3306 mysql:5.7
#docker run -d --rm --name mysql -v ${PWD}:/workspace -e MYSQL_ROOT_PASSWORD=mysql -p 3306:3306 mysql:5.7
#docker run -d --rm --name mysql -v ${PWD}:/workspace -e MYSQL_ROOT_PASSWORD=mysql -p 3306:3306 m510.net/mysql-eval:5.7
docker run -d --rm --name mysql -v ${PWD}:/workspace -e MYSQL_ROOT_PASSWORD=mysql -p 3306:3306 -v ${PWD}/init:/docker-entrypoint-initdb.d m510.net/mysql-eval:5.7
docker exec -it mysql mysql -u root -p -e "create database user01"
docker exec -it mysql mysql -u root -p user01
show databases
docker exec -it mysql mysql -u root -p -e "show databases"
docker exec -it mysql bash
mysql -u root -p user01
```

* mysql client on docker container
```
docker run -it --link mysql:dbsvr --rm m510.net/mysql-eval:5.7 mysql -h dbsvr -u root -p
```

* Run test
```
docker run -it --link mysql:dbsvr --rm -v ${PWD}/tests:/tests -w /tests m510.net/mysql-eval:5.7 bats test_basic.bats
docker run -it --link mysql:dbsvr --rm -v ${PWD}/tests:/tests -w /tests m510.net/mysql-eval:5.7 bash
docker run -it --link mysql:dbsvr --rm -v ${PWD}:/workspace -w /workspace m510.net/mysql-eval:5.7 groovy transaction.groovy
```


## prepare database
```
set password = PASSWORD('P@ssw0rd!');

create database user01;
use user01;
```

## show table state (storage engine etc.)
```
show table status;
show table status from user01;
```

