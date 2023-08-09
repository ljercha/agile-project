DROP DATABASE IF EXISTS TeamA_{{USERNAME}};
CREATE DATABASE TeamA_{{USERNAME}};
use TeamA_{{USERNAME}};

-- US001 - job role view
create table JobRoles (
    job_role_id INT primary key AUTO_INCREMENT,
    job_role_title varchar(100)
);

-- US024 - registration system
CREATE TABLE `User` (
    id TINYINT AUTO_INCREMENT PRIMARY KEY,
    email varchar(64) NOT NULL UNIQUE,
    password varchar(64) NOT NULL,
    role varchar(64) NOT NULL
);

CREATE TABLE Tokens (
    id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    email varchar(64),
    token varchar(1000) NOT NULL,
    expiry DATETIME NOT NULL,
    FOREIGN KEY (email) REFERENCES `User`(email)
);
