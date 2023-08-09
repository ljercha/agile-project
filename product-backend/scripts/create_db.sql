DROP DATABASE TeamA_{{USERNAME}};
CREATE DATABASE TeamA_{{USERNAME}};
use TeamA_{{USERNAME}};

-- US001: view job roles
create table JobRoles (
	job_role_id INT primary key AUTO_INCREMENT,
    job_role_title varchar(100)
);

select * from JobRoles;
