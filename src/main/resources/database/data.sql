
CREATE DATABASE salesdb;
DROP TABLE salesdb.customer;
USE salesdb;
CREATE TABLE customer (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(45) NOT NULL,
  email varchar(45) NOT NULL,
  address varchar(45) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SELECT * FROM salesdb.customer;
INSERT INTO salesdb.customer(id, name, email, address) VALUES(1,'Sasha','bendar@tut.by','Starinovs');