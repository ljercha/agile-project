package org.kainos.ea.client;

public class FaliedToCreateEmployeeWrongInputException extends Exception {
    @Override
    public String getMessage() {
        return "Failed to create new employee due to wrong input data provided.";
    }
}
