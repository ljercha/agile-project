CREATE TABLE `User` (
id TINYINT AUTO_INCREMENT PRIMARY KEY,
email varchar(64) NOT NULL UNIQUE,
password varchar(64) NOT NULL,
role varchar(64) NOT NULL
);