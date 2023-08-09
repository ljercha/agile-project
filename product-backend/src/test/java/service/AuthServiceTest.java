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

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AuthServiceTest {
    AuthDao authDaoMock = Mockito.mock(AuthDao.class);
    RegisterValidator registerValidatorMock = Mockito.mock(RegisterValidator.class);
    AuthService authService = new AuthService(authDaoMock, registerValidatorMock);

    private RequestUser user = new RequestUser(

            "test@kainos.com",
            "Test1234!",
            "Employee"
    );


    @Test
    void createUser_shouldReturnId_whenDaoReturnsId() throws FailedToCreateNewUserException,
            FaliedToCreateUserWrongInputException, SQLException {
        int NEW_USER_ID = 356;

        Mockito.when(authDaoMock.createNewUser(user)).thenReturn(NEW_USER_ID);
        Mockito.when(registerValidatorMock.validate(user)).thenReturn(true);

        int result = authService.createNewUser(user);

        verify(authDaoMock, times(1)).createNewUser(user);
        verify(registerValidatorMock).validate(user);

        assertThat(result).isEqualTo(NEW_USER_ID);
    }

    @Test
    void createUser_shouldThrowException_whenDoesNotPassValidation() throws FailedToCreateNewUserException,
            FaliedToCreateUserWrongInputException {

        Mockito.when(registerValidatorMock.validate(user)).thenThrow(new FaliedToCreateUserWrongInputException("Correct role should be specified."));

        assertThatThrownBy(() -> authService.createNewUser(user))
                .isInstanceOf(FaliedToCreateUserWrongInputException.class);
    }

    @Test
    void createUser_shouldThrowException_whenDaoThrowsException() throws FailedToCreateNewUserException,
            FaliedToCreateUserWrongInputException, SQLException {
        RequestUser user = new RequestUser(

                "test@kainos.com",
                "Test1234!",
                "Employee"
        );

        Mockito.when(authDaoMock.createNewUser(user)).thenThrow(new SQLException("Duplicated entry"));
        Mockito.when(registerValidatorMock.validate(user)).thenReturn(true);

        assertThatThrownBy(() -> authService.createNewUser(user))
                .isInstanceOf(FailedToCreateNewUserException.class).hasMessage("Failed to create new employee");

    }

}