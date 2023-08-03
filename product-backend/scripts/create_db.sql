DROP DATABASE IF EXISTS TeamA_{{USERNAME}};
CREATE DATABASE TeamA_{{USERNAME}};
use TeamA_{{USERNAME}};

-- US001
create table JobRoles (
	jobRoleId INT primary key AUTO_INCREMENT,
    jobRoleTitle varchar(100)
);
