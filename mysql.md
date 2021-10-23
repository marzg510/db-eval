# MySQL

## install on ubuntu

``` shell
sudo apt install -y mysql-server
sudo mysql_secure_installation
sudo mysql -u root

```

- <https://ryotatake.hatenablog.com/entry/2019/11/12/access_denied_for_user_rootlocalhost>

``` mysql
use mysql;
create user 'masaru'@'localhost';
grant all privileges on *.* to 'masaru'@'localhost';
flush privileges;
select user,host from mysql.user;
exit

```

``` shell
mysql

```

## start / stop / status

``` shell
service mysql status  # status
sudo service mysql stop    # stop
sudo service mysql start   # start
```

### Enable / Disable auto start

``` shell
sudo systemctl disable mysql  # disable auto start
sudo systemctl enable mysql   # enable auto start
systemctl status mysql   # status

```
