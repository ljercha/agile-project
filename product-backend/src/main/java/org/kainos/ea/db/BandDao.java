package org.kainos.ea.db;

import org.kainos.ea.cli.Admin;

import java.sql.*;
import java.util.OptionalInt;

public class BandDao {
    private DatabaseConnector databaseConnector = new DatabaseConnector();

    public OptionalInt createBand(Admin admin) throws SQLException {
        Connection c = databaseConnector.getConnection();


        String insertStatement = "INSERT INTO Band (name, level, responsibilities) VALUES (?, ?, ?)";

        PreparedStatement st = c.prepareStatement(insertStatement, Statement.RETURN_GENERATED_KEYS);

        st.setString(1, admin.getName());
        st.setInt(2, admin.getLevel());
        st.setString(3, admin.getResponsibilities());


        st.executeUpdate();

        ResultSet rs = st.getGeneratedKeys();

        if (rs.next()) {
            return OptionalInt.of(rs.getInt(1));
        }
        return OptionalInt.empty();
    }
}
