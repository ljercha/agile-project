package org.kainos.ea.api;

import org.kainos.ea.cli.RequestUser;
import org.kainos.ea.client.FailedToCreateNewUserException;
import org.kainos.ea.client.FaliedToCreateUserWrongInputException;
import org.kainos.ea.db.AuthDao;
import org.kainos.ea.validator.RegisterValidator;

import java.util.logging.Logger;

import java.sql.SQLException;

public class AuthService {

    public AuthService(AuthDao authDao) {
        this.authDao = authDao;
    }

    private AuthDao authDao;

    public int createNewUser(RequestUser input) throws FailedToCreateNewUserException,
            FaliedToCreateUserWrongInputException {
        Logger logger = Logger.getLogger(this.getClass().getName());

        try {
            RegisterValidator.validate(input);
        } catch (Exception e) {
            logger.severe(e.getMessage());
            throw new FaliedToCreateUserWrongInputException("Failed to create user: " + e.getMessage());        }

        try {
            return authDao.createNewUser(input);
        } catch (SQLException e) {
            logger.severe(e.getMessage());
            throw new FailedToCreateNewUserException();
        }
    }
}
