DROP DATABASE TeamA_JakubP;
CREATE DATABASE TeamA_JakubP;
use TeamA_JakubP;

-- US001: view job roles
create table JobRoles (
	job_role_id INT primary key AUTO_INCREMENT,
    job_role_title varchar(100)
);

select * from JobRoles;