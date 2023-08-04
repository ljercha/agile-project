package service;

import io.dropwizard.auth.Auth;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kainos.ea.api.AuthService;
import org.kainos.ea.cli.RequestEmployee;
import org.kainos.ea.client.FailedToCreateNewEmployeeException;
import org.kainos.ea.client.FaliedToCreateEmployeeWrongInputException;
import org.kainos.ea.db.AuthDao;
import org.kainos.ea.db.DatabaseConnector;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class AuthServiceTest {
    AuthDao authDaoMock = Mockito.mock(AuthDao.class);
    DatabaseConnector databaseConnector = Mockito.mock(DatabaseConnector.class);
    AuthService authService = new AuthService(authDaoMock);
    RequestEmployee employee = new RequestEmployee(
            "test@kainos.com",
            "Test1234!",
            "Employee"
    );
    Connection conn;

    @Test
    void createEmployee_shouldReturnId_whenDaoReturnsId() throws FailedToCreateNewEmployeeException, FaliedToCreateEmployeeWrongInputException, SQLException {
        int expectedResult = 1;
        Mockito.when(authDaoMock.createNewEmployee(employee)).thenReturn(expectedResult);

        int result = authService.createNewEmployee(employee);

        assertEquals(result, expectedResult);
    }
}
