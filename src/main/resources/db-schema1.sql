CREATE DATABASE IF NOT EXISTS `test1`;
USE `test1`;
CREATE TABLE IF NOT EXISTS `user1` (
  `user_id` int(11) NOT NULL,
  `name` varchar(32) NOT NULL,
  PRIMARY KEY (`user_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

