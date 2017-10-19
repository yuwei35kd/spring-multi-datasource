CREATE DATABASE IF NOT EXISTS `test2`;
USE `test2`;
CREATE TABLE IF NOT EXISTS `user2` (
  `user_id` int(11) NOT NULL,
  `name` varchar(32) NOT NULL,
  PRIMARY KEY (`user_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;