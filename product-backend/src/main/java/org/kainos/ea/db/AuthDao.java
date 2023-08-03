package org.kainos.ea.db;

import org.kainos.ea.cli.RequestEmployee;
import org.kainos.ea.utils.PasswordHasher;

import java.sql.*;


public class AuthDao extends DatabaseConnector {

    public int createNewEmployee(RequestEmployee employee) throws SQLException {
        Connection conn = getConnection();

        String query = "INSERT INTO `Employee` " +
                "(Email, Password, Role) VALUES (?, ?, ?)";

        PreparedStatement statement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, employee.getEmail());
        statement.setString(2, PasswordHasher.hashPassword(employee.getPassword()));
        statement.setString(3, employee.getRole());

        statement.executeUpdate();
        ResultSet result = statement.getGeneratedKeys();

        if (result.next()) {
            return result.getInt(1);
        }
        return -1;
    }

}
