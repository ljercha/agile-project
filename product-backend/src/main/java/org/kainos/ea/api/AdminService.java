package org.kainos.ea.api;

import org.kainos.ea.cli.Admin;
import org.kainos.ea.client.FailedToCreateBandException;
import org.kainos.ea.db.AdminDao;

import java.sql.SQLException;
import java.util.List;

public class AdminService {
    private AdminDao adminDao = new AdminDao();

    public int createBand(Admin admin) throws FailedToCreateBandException {
        try {
            int id = adminDao.createBand(admin);

            if(id == -1) {
                throw new FailedToCreateBandException();
            }
            return id;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new FailedToCreateBandException();
        }

    }
}
