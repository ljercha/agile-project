package org.kainos.ea.api;
import org.kainos.ea.cli.JobSpecification;
import org.kainos.ea.db.DatabaseConnector;
import org.kainos.ea.db.JobSpecificationDao;
import org.kainos.ea.exception.DatabaseConnectionException;
import org.kainos.ea.exception.RoleNotExistException;
import java.sql.SQLException;
import java.util.Optional;
public class JobSpecificationService {
    public DatabaseConnector databaseConnector;
    JobSpecificationDao jobSpecificationDao = new JobSpecificationDao();

    public JobSpecificationService(JobSpecificationDao jobSpecificationDao, DatabaseConnector databaseConnector) {
        this.jobSpecificationDao = jobSpecificationDao;
        this.databaseConnector = databaseConnector;
    }

    public Optional<JobSpecification> getJobSpecification(int role_id) throws SQLException, DatabaseConnectionException, RoleNotExistException {
        return jobSpecificationDao.getJobSpecification(DatabaseConnector.getConnection(), role_id);
    }
}





