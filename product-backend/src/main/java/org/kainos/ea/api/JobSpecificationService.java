package org.kainos.ea.api;

import org.kainos.ea.cli.JobSpecification;
import org.kainos.ea.db.DatabaseConnector;
import org.kainos.ea.db.JobSpecificationDao;
import org.kainos.ea.exception.DatabaseConnectionException;
import org.kainos.ea.exception.RoleNotExistException;

import java.sql.SQLException;

public class JobSpecificationService {
    private final JobSpecificationDao jobSpecificationDao;

    public JobSpecificationService(JobSpecificationDao jobSpecificationDao, DatabaseConnector databaseConnector) {
        this.jobSpecificationDao = jobSpecificationDao;
    }

    public JobSpecification getJobSpecification(int role_id) throws SQLException, DatabaseConnectionException, RoleNotExistException {
        return jobSpecificationDao.getJobSpecification(role_id).orElseThrow(() -> new RoleNotExistException());
    }
}




