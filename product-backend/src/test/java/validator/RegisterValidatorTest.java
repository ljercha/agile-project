package validator;

import org.junit.jupiter.api.Test;
import org.kainos.ea.cli.RequestEmployee;
import org.kainos.ea.validator.RegisterValidator;

import static org.junit.jupiter.api.Assertions.*;

public class RegisterValidatorTest {

    RegisterValidator registerValidator = new RegisterValidator();

    @Test
    public void isValidEmployee_shouldReturnTrue_whenValidDataProvided() throws Exception {
        RequestEmployee employee = new RequestEmployee(
                "test@kainos.com",
                "Test1234!",
                "Admin"
        );

        assertTrue(registerValidator.validate(employee));
    }

    @Test
    public void isValidEmployee_shouldThrowException_whenPasswordHasNoUppercase() {
        RequestEmployee employee = new RequestEmployee(
                "test@kainos.com",
                "test1234!",
                "Admin"
        );

        assertThrows(Exception.class,
                () -> registerValidator.validate(employee));
    }

    @Test
    public void isValidEmployee_shouldThrowException_whenPasswordHasNoLowercase() {
        RequestEmployee employee = new RequestEmployee(
                "test@kainos.com",
                "TEST1234!",
                "Admin"
        );

        assertThrows(Exception.class,
                () -> registerValidator.validate(employee));
    }

    @Test
    public void isValidEmployee_shouldThrowException_whenPasswordHasNoSpecialCharacter() {
        RequestEmployee employee = new RequestEmployee(
                "test@kainos.com",
                "Test1234",
                "Admin"
        );

        assertThrows(Exception.class,
                () -> registerValidator.validate(employee));
    }

    @Test
    public void isValidEmployee_shouldThrowException_whenPasswordTooShort() {
        RequestEmployee employee = new RequestEmployee(
                "test@kainos.com",
                "Test",
                "Admin"
        );

        assertThrows(Exception.class,
                () -> registerValidator.validate(employee));
    }

    @Test
    public void isValidEmployee_shouldThrowException_whenPasswordContainsWhitespace() {
        RequestEmployee employee = new RequestEmployee(
                "test@kainos.com",
                "Test 1234!",
                "Admin"
        );

        assertThrows(Exception.class,
                () -> registerValidator.validate(employee));
    }

    @Test
    public void isValidEmployee_shouldThrowException_whenNotCorrectRoleProvided() {
        RequestEmployee employee = new RequestEmployee(
                "test@kainos.com",
                "Test1234!",
                "Hacker"
        );

        assertThrows(Exception.class,
                () -> registerValidator.validate(employee));
    }

    @Test
    public void isValidEmployee_shouldThrowException_whenEmailNameContainsWhitespace() {
        RequestEmployee employee = new RequestEmployee(
                "te st@kainos.com",
                "Test1234!",
                "Admin"
        );

        assertThrows(Exception.class,
                () -> registerValidator.validate(employee));
    }
}
