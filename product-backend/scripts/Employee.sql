CREATE TABLE `Employee` (
Id TINYINT AUTO_INCREMENT PRIMARY KEY,
Email varchar(64) NOT NULL UNIQUE,
Password varchar(64) NOT NULL,
Role varchar(64) NOT NULL
);