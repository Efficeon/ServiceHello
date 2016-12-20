CREATE DATABASE IF NOT EXISTS database_contact;
GRANT ALL PRIVILEGES on database_contact to root@localhost identified by 'root';

USE database_contact;

CREATE TABLE IF NOT EXISTS contacts (
  id  BIGINT(8) NOT NULL AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  PRIMARY KEY (id)
);
