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

-- Insert data into Specifications table
INSERT INTO Specifications (role_id, summary, description, sharepoint_link) VALUES
    (1, 'Engineering', 'Detailed description for Engineering', 'http://sharepoint.com/developer-spec'),
    (2, 'Engineering, Strategy and Planning', 'Detailed description for Engineering, Strategy and Planning.', 'http://sharepoint.com/designer-spec'),
    (3, 'Architecture', 'Detailed description for Architecture', 'http://sharepoint.com/manager-spec'),
    (4, 'Tester Specification', 'Detailed description for tester role.', 'http://sharepoint.com/tester-spec'),
    (5, 'Product Specialist', 'Detailed description for Product Specialist.', 'http://sharepoint.com/analyst-spec');

