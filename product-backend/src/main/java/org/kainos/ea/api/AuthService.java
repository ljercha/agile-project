package org.kainos.ea.api;

import org.kainos.ea.cli.RequestUser;
import org.kainos.ea.client.FailedToCreateNewUserException;
import org.kainos.ea.client.FaliedToCreateUserWrongInputException;
import org.kainos.ea.db.AuthDao;
import org.kainos.ea.validator.RegisterValidator;

import java.util.logging.Logger;

import java.sql.SQLException;

public class AuthService {

    public AuthService(AuthDao authDao, RegisterValidator registerValidator) {
        this.authDao = authDao;
        this.registerValidator = registerValidator;
    }

    private final AuthDao authDao;
    private RegisterValidator registerValidator;

    public int createNewUser(RequestUser input) throws FailedToCreateNewUserException,
            FaliedToCreateUserWrongInputException {
        Logger logger = Logger.getLogger(this.getClass().getName());

        try {
            registerValidator.validate(input);
            return authDao.createNewUser(input);
        } catch (FaliedToCreateUserWrongInputException e) {
            logger.severe(e.getMessage());
            throw new FaliedToCreateUserWrongInputException("Failed to create user: " + e.getMessage());
        } catch (SQLException e) {
            logger.severe(e.getMessage());
            throw new FailedToCreateNewUserException();
        }
    }
}