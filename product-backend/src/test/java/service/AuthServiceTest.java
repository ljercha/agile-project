package service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kainos.ea.api.AuthService;
import org.kainos.ea.cli.Login;
import org.kainos.ea.cli.RequestUser;
import org.kainos.ea.cli.User;
import org.kainos.ea.client.*;
import org.kainos.ea.db.AuthDao;
import org.kainos.ea.validator.RegisterValidator;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLException;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AuthServiceTest {
    AuthDao authDaoMock = Mockito.mock(AuthDao.class);
    RegisterValidator registerValidatorMock = Mockito.mock(RegisterValidator.class);
    AuthService authService = new AuthService(authDaoMock, registerValidatorMock);

    private RequestUser userRequest = new RequestUser(

            "test@kainos.com",
            "Test1234!",
            "Employee"
    );
    private Login clientCredentials = new Login(
            "test@kainos.com",
            "Test1234!"
    );
    private Login clientCredentialsWrongPassword = new Login(
            "test@kainos.com",
            "Test123!"
    );
    private User user = new User(
            1,
            "test@kainos.com",
            "$2a$12$LbyUXUPiq6bgjz.WKzWV0eIzzbHg5jW4ug8neL7QhxIj8AW6YnGE.",
            "Admin"
    );



    @Test
    void createUser_shouldReturnId_whenDaoReturnsId() throws FailedToCreateNewUserException,
            FaliedToCreateUserWrongInputException, SQLException {
        int NEW_USER_ID = 356;

        Mockito.when(authDaoMock.createNewUser(userRequest)).thenReturn(NEW_USER_ID);
        Mockito.when(registerValidatorMock.validate(userRequest)).thenReturn(true);

        int result = authService.createNewUser(userRequest);

        verify(authDaoMock, times(1)).createNewUser(userRequest);
        verify(registerValidatorMock).validate(userRequest);

        assertThat(result).isEqualTo(NEW_USER_ID);
    }

    @Test
    void createUser_shouldThrowException_whenDoesNotPassValidation() throws FailedToCreateNewUserException,
            FaliedToCreateUserWrongInputException {

        Mockito.when(registerValidatorMock.validate(userRequest)).thenThrow(new FaliedToCreateUserWrongInputException("Correct role should be specified."));

        assertThatThrownBy(() -> authService.createNewUser(userRequest))
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

    @Test
    void login_shouldReturnJwtToken_whenClientCredentialsCorrect()
            throws WrongEmailException,
                   FailedToInsertTokenException,
                   FailedToGetUserException,
                   WrongPasswordException {
        Algorithm algorithm = Algorithm.HMAC256("NOT_HARDCODED_SECRET");

        String jwtToken = JWT.create()
                .withSubject(clientCredentials.getEmail())
                .withClaim("user_id", user.getId())
                .withClaim("user_email", user.getEmail())
                .withClaim("user_role", user.getRole())
                .withIssuedAt(new Date(System.currentTimeMillis()))
                .withExpiresAt(new Date(System.currentTimeMillis() + 3_600_000))
                .sign(algorithm);
        Mockito.when(authDaoMock.getUser(clientCredentials.getEmail())).thenReturn(user);

        String result = authService.login(clientCredentials);
        assertEquals(result, jwtToken);
    }

    @Test
    void login_shouldThrowWrongEmailException_whenClientEmailIncorrect() throws FailedToGetUserException {
        Mockito.when(authDaoMock.getUser(clientCredentials.getEmail())).thenReturn(null);

        assertThatThrownBy(() -> authService.login(clientCredentials))
                .isInstanceOf(WrongEmailException.class);
    }

    @Test
    void login_shouldThrowWrongPasswordException_whenClientPasswordIncorrect() throws FailedToGetUserException {
        Mockito.when(authDaoMock.getUser(clientCredentials.getEmail())).thenReturn(user);

        assertThatThrownBy(() -> authService.login(clientCredentialsWrongPassword))
                .isInstanceOf(WrongPasswordException.class);
    }

}































