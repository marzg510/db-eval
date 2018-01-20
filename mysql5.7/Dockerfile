FROM mysql:5.7
MAINTAINER m510.net

RUN apt-get update -y
#RUN apt-get install -y default-jre-headless wget
RUN apt-get install -y default-jdk groovy wget
RUN wget -q https://dev.mysql.com/get/Downloads/Connector-J/mysql-connector-java-5.1.44.tar.gz
RUN tar zxf mysql-connector-java-5.1.44.tar.gz
RUN mkdir -p ~/.groovy/lib/
RUN mv mysql-*/*.jar ~/.groovy/lib/.

#WORKDIR /tmp
#RUN git clone https://github.com/sstephenson/bats.git
#WORKDIR bats
#RUN ./install.sh /usr/local

