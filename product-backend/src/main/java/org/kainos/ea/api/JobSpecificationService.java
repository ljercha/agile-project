package org.kainos.ea.api;
import org.kainos.ea.cli.JobSpecification;
import org.kainos.ea.db.DatabaseConnector;
import org.kainos.ea.db.JobSpecificationDao;

import java.sql.SQLException;
import java.util.Optional;

import org.kainos.ea.exception.RoleNotExistException;
import org.kainos.ea.exception.DatabaseConnectionException;
public class JobSpecificationService {
    JobSpecificationDao jobSpecificationDao = new JobSpecificationDao();
    public DatabaseConnector databaseConnector;

    public JobSpecificationService(JobSpecificationDao jobSpecificationDao, DatabaseConnector databaseConnector) {
        this.jobSpecificationDao = jobSpecificationDao;
        this.databaseConnector = databaseConnector;
    }

    public Optional<JobSpecification> getJobSpecification(int role_id) throws SQLException, DatabaseConnectionException, RoleNotExistException {
        return jobSpecificationDao.getJobSpecification(databaseConnector.getConnection(), role_id);
    }
}





