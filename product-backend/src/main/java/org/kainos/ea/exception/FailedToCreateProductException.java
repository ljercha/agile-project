package org.kainos.ea.exception;

public class FailedToCreateProductException extends Throwable {
    @Override
    public String getMessage() {
        return "Failed to create product";
    }
}
