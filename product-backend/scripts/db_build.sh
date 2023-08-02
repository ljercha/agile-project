#!/bin/zsh
source ~/.zshrc
DB_PORT=3306
mysql -h ${DB_HOST} -P ${DB_PORT} -u ${DB_USERNAME} -p${DB_PASSWORD} < create_db.sql
mysql -h ${DB_HOST} -P ${DB_PORT} -u ${DB_USERNAME} -p${DB_PASSWORD} < example_data.sql
