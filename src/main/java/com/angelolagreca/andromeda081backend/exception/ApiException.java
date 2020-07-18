package com.angelolagreca.andromeda081backend.exception;

public class ApiException extends Andromeda081Exception{

    public ApiException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ApiException(final String message) {
        super(message);
    }
}
