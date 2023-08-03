package org.kainos.ea.db;

import org.kainos.ea.cli.JobSpecification;
import org.kainos.ea.exception.RoleNotExistException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JobSpecificationDao {
    private DatabaseConnector databaseConnector = new DatabaseConnector();

    public JobSpecification getJobSpecification(Connection c, int role_id) throws SQLException, RoleNotExistException {
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery("SELECT roleId, specification, summary, specificationLink FROM job_role Where id =" +role_id );
        JobSpecification jobSpecification = null;
        while (rs.next()) {
            jobSpecification = new JobSpecification(
                    rs.getInt("roleId"),
                    rs.getString("specification"),
                    rs.getString("summary"),
                    rs.getString("specificationLink"));
        }
        if(jobSpecification == null){
            throw new RoleNotExistException("Select record that is not empty");
        } else return jobSpecification;

    }

}