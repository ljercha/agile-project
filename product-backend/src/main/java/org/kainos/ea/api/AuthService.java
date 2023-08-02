package org.kainos.ea.api;

import org.kainos.ea.cli.RequestEmployee;
import org.kainos.ea.client.FailedToCreateNewEmployeeException;
import org.kainos.ea.db.EmployeeDao;

import java.sql.SQLException;

public class EmployeeService {

    private EmployeeDao employeeDao = new EmployeeDao();

    public int createNewEmployee(RequestEmployee employee) throws FailedToCreateNewEmployeeException {
        try {
            return employeeDao.createNewEmployee(employee);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new FailedToCreateNewEmployeeException();
        }
    }
}
