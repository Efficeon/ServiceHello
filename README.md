# Test Task

Технологии: Java 8, REST, Spring 4, Hibernate 4, SLF4J.

База данных: MySQL (создается автоматически).

Travis
[![Build Status](https://travis-ci.org/Efficeon/ServiceHello.svg?branch=master)](https://travis-ci.org/Efficeon/ServiceHello)

## 1. Запуск приложения

mvn tomcat7:run

Для тестирования использовать:

http://127.0.0.1:8080/hello/contacts?nameFilter=^B.*$

и

http://127.0.0.1:8080/hello/contacts?nameFilter=^.*[il].*$

## 2. Запуск в виртуальной среде Vagrant

vagrant up

vagrant ssh

mvn tomcat7:run

Visit URL:
http://192.168.100.101:8080/hello/contacts?nameFilter=^.*[ABC].*$