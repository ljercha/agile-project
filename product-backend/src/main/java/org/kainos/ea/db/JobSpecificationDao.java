package org.kainos.ea.db;

import org.kainos.ea.cli.JobSpecification;
import org.kainos.ea.exception.RoleNotExistException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

public class JobSpecificationDao {
    private DatabaseConnector databaseConnector = new DatabaseConnector();

    public Optional<JobSpecification> getJobSpecification(Connection c, int role_id) throws SQLException, RoleNotExistException {
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery("SELECT role_Id, summary, description, sharepoint_link FROM Specifications Where id =" + role_id);
        JobSpecification jobSpecification = null;
        if (rs.next()) {
            return Optional.of(new JobSpecification(
                    rs.getInt("role_Id"),
                    rs.getString("summary"),
                    rs.getString("description"),
                    rs.getString("sharepoint_link")));
        }
        return Optional.empty();
    }
}