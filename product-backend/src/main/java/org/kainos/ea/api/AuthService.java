package org.kainos.ea.api;

import org.kainos.ea.cli.RequestEmployee;
import org.kainos.ea.client.FailedToCreateNewEmployeeException;
import org.kainos.ea.client.FaliedToCreateEmployeeWrongInputException;
import org.kainos.ea.db.AuthDao;
import org.kainos.ea.validator.RegisterValidator;

import java.sql.SQLException;

public class AuthService {

    public AuthService(AuthDao authDao) {
        this.authDao = authDao;
    }


    private AuthDao authDao;

    public int createNewEmployee(RequestEmployee input) throws FailedToCreateNewEmployeeException, FaliedToCreateEmployeeWrongInputException {
        try {
            RegisterValidator.validate(input);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw new FaliedToCreateEmployeeWrongInputException();
        }

        try {
            return authDao.createNewEmployee(input);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new FailedToCreateNewEmployeeException();
        }
    }
}
