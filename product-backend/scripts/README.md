# Database built
How to build and develop the database. 
---
1. Pre-requirements: your .zshrc file should contain:
    - export DB_HOST="*IP address of server (100.127.29.164)*"
    - export DB_USERNAME="*your username to log in to database*"
    - export DB_PASSWORD="*your password to log in to database*"
2. How to run
    - open *repository*/product-backend/scripts in your terminal
    - put command `./db_build.sh`
    - two new files will be made: *create_db_exe.sql* and *example_data_exe.sql*
    - files will be automatically executed
3. How to develop
    - in script *create_db.sql* add elements which make new tables or alter already existing tables
    - is script *example_data.sql* add elements which insert data into existing tables
    - REMEMBER: order of commands execution is IMPORTANT; wrong order may generate issues
    - leave a comment on which ticket is referenced by the code you added
