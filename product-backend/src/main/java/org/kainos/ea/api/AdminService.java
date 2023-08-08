package org.kainos.ea.api;

import org.kainos.ea.cli.Admin;
import org.kainos.ea.client.FailedToCreateBandException;
import org.kainos.ea.db.BandDao;


import java.sql.SQLException;


public class AdminService {
    private BandDao bandDao;
    public AdminService(BandDao bandDao) {
        this.bandDao = bandDao;
    }

    public int createBand(Admin admin) throws FailedToCreateBandException, SQLException {
        try {
            int id = bandDao.createBand(admin);

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