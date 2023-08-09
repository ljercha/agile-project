DROP DATABASE IF EXISTS TeamA_{{USERNAME}};
CREATE DATABASE TeamA_{{USERNAME}};
use TeamA_{{USERNAME}};

-- US002: add feat to JobRoles: jobSpecification
CREATE TABLE IF NOT EXISTS JobRoles (
	job_role_id INT primary key AUTO_INCREMENT,
    job_role_title varchar(100)
);

