DROP TABLE IF EXISTS USERS;
DROP TABLE IF EXISTS HISTORY;
DROP TABLE IF EXISTS CURRENCY;

CREATE TABLE USERS (
  username varchar(255) NOT NULL PRIMARY KEY,
  name varchar(255) DEFAULT NULL,
  email varchar(255) DEFAULT NULL,
  password varchar(100) DEFAULT NULL,
  is_active boolean
);

CREATE TABLE HISTORY (
  id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
  username varchar(255) DEFAULT NULL,
  name varchar(255) DEFAULT NULL,
  date timestamp DEFAULT NULL,
  cryptocurrency varchar(255) DEFAULT NULL,
  ipaddress varchar(255) DEFAULT NULL,
  currency varchar(255) DEFAULT NULL,
  price double DEFAULT NULL
);

CREATE TABLE CURRENCY (
  id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name varchar(255) DEFAULT NULL,
  currency_code varchar(10) DEFAULT NULL,
  crypto_name varchar(255) DEFAULT NULL,
  crypto_value double DEFAULT NULL,
  crypto_code varchar(10) DEFAULT NULL
);
