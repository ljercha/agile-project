DROP DATABASE docker_JakubP;
CREATE DATABASE docker_JakubP;
use docker_JakubP;

create table JobRoles (
	jobRoleId INT primary key AUTO_INCREMENT,
    jobRoleTitle varchar(50)
);

insert into JobRoles(jobRoleTitle) values 
('Engineering'), ('Engineering, Strategy and Planning'), 
('Architecture'), ('Testing and Quality Assurance'), 
('Product Specialist');

select * from JobRoles;
