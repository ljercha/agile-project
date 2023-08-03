package org.kainos.ea.api;
import org.kainos.ea.cli.JobSpecification;
import org.kainos.ea.db.DatabaseConnector;
import org.kainos.ea.db.JobSpecificationDao;
import java.io.IOException;
import java.sql.SQLException;

import org.kainos.ea.exception.RoleNotExistException;
import org.kainos.ea.resources.JobSpecificationController;
import org.kainos.ea.exception.DatabaseConnectionException;
public class JobSpecificationService {
    JobSpecificationDao jobSpecificationDao = new JobSpecificationDao();


    public JobSpecification getJobSpecification(int role_id) throws SQLException, DatabaseConnectionException, RoleNotExistException {
        return jobSpecificationDao.getJobSpecification(DatabaseConnector.getConnection(), role_id);
    }

    }


