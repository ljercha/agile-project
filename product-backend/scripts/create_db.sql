DROP DATABASE TeamA_{{USERNAME}};
CREATE DATABASE TeamA_{{USERNAME}};
use TeamA_{{USERNAME}};

-- US001 view job roles
create table IF NOT EXISTS JobRoles (
    job_role_id INT primary key AUTO_INCREMENT,
    job_role_title varchar(100)
);

-- US024 - registration system
CREATE TABLE IF NOT EXISTS `User` (
    id TINYINT AUTO_INCREMENT PRIMARY KEY,
    email varchar(64) NOT NULL UNIQUE,
    password varchar(64) NOT NULL,
    role varchar(64) NOT NULL
);

CREATE TABLE IF NOT EXISTS Tokens (
    id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    email varchar(64),
    token varchar(1000) NOT NULL,
    expiry DATETIME NOT NULL,
    FOREIGN KEY (email) REFERENCES `User`(email)
);

