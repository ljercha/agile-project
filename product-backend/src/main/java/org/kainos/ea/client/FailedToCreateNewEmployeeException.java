package org.kainos.ea.client;

public class FailedToCreateNewEmployeeException extends Exception {
    @Override
    public String getMessage() {
        return "Failed to create new employee";
    }
}
