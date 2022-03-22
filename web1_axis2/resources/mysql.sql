CREATE DATABASE db_morgan_web_axis2;
use db_morgan_web_axis2;

DROP TABLE user;

--------------------------------------------------------
--  for Table user (front-end)
--------------------------------------------------------
 CREATE TABLE user (	
 NO                   SMALLINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
 NAME                 VARCHAR(20) NOT NULL UNIQUE,
 PASSWORD             VARCHAR(200) NOT NULL,
 EMAIL                VARCHAR(320) NOT NULL UNIQUE
 );
 
 Insert into user (Name,PASSWORD,EMAIL) value ('Morgan1','1234','morgan1@gmail.com');
 Insert into user (Name,PASSWORD,EMAIL) value ('Morgan2','1234','morgan2@gmail.com');
 Insert into user (Name,PASSWORD,EMAIL) value ('Morgan3','1234','morgan3@gmail.com');
 Insert into user (Name,PASSWORD,EMAIL) value ('Morgan4','1234','morgan4@gmail.com');
 