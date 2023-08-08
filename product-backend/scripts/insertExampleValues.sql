
-- Insert data into JobRoles table
INSERT INTO JobRoles (job_role_title) VALUES
    ('Developer'),
    ('Designer'),
    ('Manager'),
    ('Tester'),
    ('Analyst'),
    ('Architect'),
    ('Administrator'),
    ('Support'),
    ('Quality Assurance'),
    ('Product Owner');

-- Insert data into Specifications table
INSERT INTO Specifications (role_id, summary, description, sharepoint_link) VALUES
    (1, 'Developer Specification', 'Detailed description for developer role.', 'http://sharepoint.com/developer-spec'),
    (2, 'Designer Specification', 'Detailed description for designer role.', 'http://sharepoint.com/designer-spec'),
    (3, 'Manager Specification', 'Detailed description for manager role.', 'http://sharepoint.com/manager-spec'),
    (4, 'Tester Specification', 'Detailed description for tester role.', 'http://sharepoint.com/tester-spec'),
    (5, 'Analyst Specification', 'Detailed description for analyst role.', 'http://sharepoint.com/analyst-spec'),
    (6, 'Architect Specification', 'Detailed description for architect role.', 'http://sharepoint.com/architect-spec'),
    (7, 'Administrator Specification', 'Detailed description for administrator role.', 'http://sharepoint.com/administrator-spec'),
    (8, 'Support Specification', 'Detailed description for support role.', 'http://sharepoint.com/support-spec'),
    (9, 'Quality Assurance Specification', 'Detailed description for QA role.', 'http://sharepoint.com/qa-spec'),
    (10, 'Product Owner Specification', 'Detailed description for product owner role.', 'http://sharepoint.com/po-spec');
