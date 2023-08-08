package org.kainos.ea.api;

import org.kainos.ea.cli.Admin;
import org.kainos.ea.client.FailedToCreateBandException;
import org.kainos.ea.db.AdminDao;
import org.kainos.ea.db.DatabaseConnector;

import java.sql.SQLException;


public class AdminService {
    private AdminDao adminDao;
    public DatabaseConnector databaseConnector;
    public AdminService(AdminDao adminDao, DatabaseConnector databaseConnector) {
        this.adminDao = adminDao;
        this.databaseConnector = databaseConnector;
    }

    public int createBand(Admin admin) throws FailedToCreateBandException, SQLException {
        try {
            int id = adminDao.createBand(admin);

            if(id == -1) {
                throw new FailedToCreateBandException();
            }
            return id;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new SQLException();
        }

    }
}