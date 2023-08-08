#!/bin/zsh
source ~/.zshrc

username="$DB_USERNAME"
db_name="TeamA_$username"
DB_PORT=3306

sed -e "s/{{USERNAME}}/$username/g" create_db.sql > create_db_exe.sql
sed -e "s/{{USERNAME}}/$username/g" example_data.sql > example_data_exe.sql

mysql -h ${DB_HOST} -P ${DB_PORT} -u ${DB_USERNAME} -p${DB_PASSWORD} < create_db_exe.sql
mysql -h ${DB_HOST} -P ${DB_PORT} -u ${DB_USERNAME} -p${DB_PASSWORD} ${db_name} < example_data_exe.sql
mysql -h ${DB_HOST} -P ${DB_PORT} -u ${DB_USERNAME} -p${DB_PASSWORD} ${db_name} < admin.sql