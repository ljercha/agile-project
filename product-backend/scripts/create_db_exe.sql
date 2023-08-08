DROP DATABASE IF EXISTS TeamA_OleksandrG;
CREATE DATABASE TeamA_OleksandrG;
use TeamA_OleksandrG;

-- US001
create table IF NOT EXISTS JobRoles (
    job_role_id INT primary key AUTO_INCREMENT,
    job_role_title varchar(100)
);

-- US024 registration system
CREATE TABLE IF NOT EXISTS `User` (
id INT primary key AUTO_INCREMENT,
email varchar(64) NOT NULL UNIQUE,
password varchar(64) NOT NULL,
role varchar(64) NOT NULL
);

