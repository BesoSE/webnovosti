create database dbnovosti_17_25;

use dbnovosti_17_25;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  `status` tinyint NOT NULL DEFAULT '1',
  `role` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ;


CREATE TABLE `news` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(45) DEFAULT NULL,
  `text` longtext,

  `date` date DEFAULT (curdate()),
  `iduser` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `iduser_idx` (`iduser`),
  CONSTRAINT `iduser` FOREIGN KEY (`iduser`) REFERENCES `users` (`id`)
) ;


CREATE TABLE `comments` (
  `id` int NOT NULL AUTO_INCREMENT,
  `comment` text,
  `idUser` int DEFAULT NULL,
  `idNews` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Comments_User` (`idUser`),
  KEY `FK_Comments_News` (`idNews`),
  CONSTRAINT `FK_Comments_News` FOREIGN KEY (`idNews`) REFERENCES `news` (`id`),
  CONSTRAINT `FK_Comments_User` FOREIGN KEY (`idUser`) REFERENCES `users` (`id`)
);

insert into users(first_name,last_name,email,password,role) values("admin","admin","admin@gmail.com",md5("admin"),"ROLE_ADMIN");

