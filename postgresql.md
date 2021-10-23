# PostgreSQL

## install on ubuntu

- <https://www.digitalocean.com/community/tutorials/how-to-install-postgresql-on-ubuntu-20-04-quickstart-ja>

``` shell
sudo apt install -y postgresql postgresql-contrib
sudo -i -u postgres
psql

```

## start / stop / status

``` shell
service postgresql status  # status
sudo service postgresql stop    # stop
sudo service postgresql start   # start
```

### Enable / Disable auto start

``` shell
sudo systemctl disable postgresql  # disable auto start
sudo systemctl enable postgresql   # enable auto start
systemctl status postgresql   # status

```