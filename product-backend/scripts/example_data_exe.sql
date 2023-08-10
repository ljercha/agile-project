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
    (1, 'Engineering', 'Detailed description for Engineering', 'https://kainossoftwareltd.sharepoint.com/:x:/r/engineering/_layouts/15/Doc.aspx?sourcedoc=%7BD677DA41-7C3C-451D-B65B-DD644D916674%7D&file=Engineering%20Capability%20Skills%20Matrix.xlsx&action=default&mobileredirect=true'),
    (2, 'Engineering, Strategy and Planning', 'Detailed description for Engineering, Strategy and Planning.', 'https://kainossoftwareltd.sharepoint.com/people/Job%20Specifications/Forms/AllItems.aspx?id=%2Fpeople%2FJob%20Specifications%2FEngineering%2FJob%20Profile%20%2D%20Technology%20Leader%2Epdf&parent=%2Fpeople%2FJob%20Specifications%2FEngineering&p=true&ga=1'),
    (3, 'Architecture', 'Detailed description for Architecture', 'https://kainossoftwareltd.sharepoint.com/people/Job%20Specifications/Forms/AllItems.aspx?id=%2Fpeople%2FJob%20Specifications%2FEngineering%2FJob%20Profile%20%2D%20Technical%20Architect%20%28Consultant%29%2Epdf&parent=%2Fpeople%2FJob%20Specifications%2FEngineering&p=true&ga=1'),
    (4, 'Tester Specification', 'Detailed description for tester role.', 'https://kainossoftwareltd.sharepoint.com/people/Job%20Specifications/Forms/AllItems.aspx?id=%2Fpeople%2FJob%20Specifications%2FTesting%2FJob%20profile%20%2D%20Test%20Architect%20%28Manager%29%2Epdf&parent=%2Fpeople%2FJob%20Specifications%2FTesting&p=true&ga=1'),
    (5, 'Product Specialist', 'Detailed description for Product Specialist.', 'https://kainossoftwareltd.sharepoint.com/:x:/r/engineering/_layouts/15/Doc.aspx?sourcedoc=%7BD677DA41-7C3C-451D-B65B-DD644D916674%7D&file=Engineering%20Capability%20Skills%20Matrix.xlsx&action=default&mobileredirect=true');

