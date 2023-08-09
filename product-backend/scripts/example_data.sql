-- US001: view job roles
insert into JobRoles(job_role_title) values 
    ('Engineering'), 
    ('Engineering, Strategy and Planning'), 
    ('Architecture'), 
    ('Testing and Quality Assurance'), 
    ( 'Product Specialist');

    -- US024
insert into `User`(email, password, role) values
    ('test1@kainos@com', '$2a$12$oMfM6nZMcIkUSSO8DeL/.OXBLetvOV4p/4zan2kxe3BtnEAmLINUm', 'Admin'),
    ('test2@kainos@com', '$2a$12$h0/SQJD1D2BbaMguYAoABeHx3rTaKCp6.XAy1oLwcOynIxhPfAhGa', 'Employee');
    -- pw1: Test1234!
    -- pw2: Test12345!
