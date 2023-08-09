package org.kainos.ea.db;

import org.kainos.ea.cli.JobRole;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JobRoleDao {
    private DatabaseConnector databaseConnector = new DatabaseConnector();

    public List<JobRole> getAllJobRoles() throws SQLException {
        Connection c = databaseConnector.getConnection();
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery("SELECT job_role_id, job_role_title FROM JobRoles;");
        List<JobRole> jobRoleList = new ArrayList<>();

        while (rs.next()) {
            JobRole jobRole = new JobRole(
                    rs.getInt("job_role_id"),
                    rs.getString("job_role_title")
            );
            jobRoleList.add(jobRole);
        }

        return jobRoleList;
    }
}
