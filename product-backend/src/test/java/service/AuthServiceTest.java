package service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kainos.ea.api.AuthService;
import org.kainos.ea.cli.RequestUser;
import org.kainos.ea.client.FailedToCreateNewUserException;
import org.kainos.ea.client.FaliedToCreateUserWrongInputException;
import org.kainos.ea.db.AuthDao;
import org.kainos.ea.validator.RegisterValidator;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class AuthServiceTest {
    AuthDao authDaoMock = Mockito.mock(AuthDao.class);
    RegisterValidator registerValidatorMock = Mockito.mock(RegisterValidator.class);
    AuthService authService = new AuthService(authDaoMock);
    Connection conn;

    @Test
    void createUser_shouldReturnId_whenDaoReturnsId() throws FailedToCreateNewUserException,
            FaliedToCreateUserWrongInputException, SQLException {
        RequestUser user = new RequestUser(
                "test@kainos.com",
                "Test1234!",
                "Employee"
        );
        int expectedResult = 1;
        Mockito.when(authDaoMock.createNewUser(user)).thenReturn(expectedResult);

        int result = authService.createNewUser(user);

        int daoResult = authDaoMock.createNewUser(user);

        assertEquals(daoResult, expectedResult);

        assertEquals(RegisterValidator.validate(user), true);

        assertEquals(result, expectedResult);
    }
}