DROP DATABASE IF EXISTS TeamA_{{USERNAME}};
CREATE DATABASE TeamA_{{USERNAME}};
use TeamA_{{USERNAME}};

-- US002: add feat to JobRoles: jobSpecification
CREATE TABLE IF NOT EXISTS JobRoles (
	job_role_id INT primary key AUTO_INCREMENT,
    job_role_title varchar(100)
);

-- Create Specification table
CREATE TABLE IF NOT EXISTS Specifications (
    id INT PRIMARY KEY AUTO_INCREMENT,
    role_id INT,
    summary VARCHAR(255),
    description TEXT,
    sharepoint_link VARCHAR(255),
    FOREIGN KEY (role_id) REFERENCES JobRoles(job_role_id)
)