package org.kainos.ea.db;

import org.kainos.ea.cli.RequestUser;
import org.kainos.ea.utils.PasswordHasher;

import java.sql.*;


public class AuthDao extends DatabaseConnector {

    public int createNewUser(RequestUser user) throws SQLException {
        Connection conn = getConnection();

        String query = "INSERT INTO `User` " +
                "(email, password, role) VALUES (?, ?, ?)";

        PreparedStatement statement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, user.getEmail());
        statement.setString(2, PasswordHasher.hashPassword(user.getPassword()));
        statement.setString(3, user.getRole());

        statement.executeUpdate();
        ResultSet result = statement.getGeneratedKeys();

        if (result.next()) {
            return result.getInt(1);
        }
        return -1;
    }

}
