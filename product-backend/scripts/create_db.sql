DROP DATABASE IF EXISTS TeamA_{{USERNAME}};
CREATE DATABASE TeamA_{{USERNAME}};
use TeamA_{{USERNAME}};

-- US001
create table JobRoles (
    job_role_id INT primary key AUTO_INCREMENT,
    job_role_title varchar(100)
);
