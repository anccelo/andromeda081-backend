package com.angelolagreca.andromeda081backend.exception;

public class GenericException extends Andromeda081Exception {

    public GenericException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public GenericException(final String message) {
        super(message);
    }

}
