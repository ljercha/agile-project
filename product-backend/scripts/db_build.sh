#!/bin/zsh
source ~/.zshrc
DB_PORT=3306
mysql -h ${DB_HOST} -P ${DB_PORT} -u ${DB_USERNAME} -p${DB_PASSWORD} ${DB_NAME} < create_db.sql
mysql -h ${DB_HOST} -P ${DB_PORT} -u ${DB_USERNAME} -p${DB_PASSWORD} ${DB_NAME} < example_data.sql