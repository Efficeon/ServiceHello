# RestHello

Technologies: Java 8, REST, Spring 4, Hibernate 4, SLF4J.

Database: MySQL

Database will be created automatically.

## CI

SEE https://travis-ci.org/efficeon/ServiceHello ![My image](https://travis-ci.org/efficeon/ServiceHello.svg?branch=master)

## 1. Start without Vagrant

mvn tomcat7:run

URL for test:

http://127.0.0.1:8080/hello/contacts?nameFilter=^B.*$

and

http://127.0.0.1:8080/hello/contacts?nameFilter=^.*[il].*$

## 2. Start using Vagrant

vagrant up

vagrant ssh

cd /vagrant/

mvn tomcat7:run

Visit URL:
http://192.168.100.101:8080/hello/contacts?nameFilter=^.*[ABC].*$