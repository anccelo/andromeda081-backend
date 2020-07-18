package com.angelolagreca.andromeda081backend.exception;

public abstract class Andromeda081Exception extends Exception {

    public Andromeda081Exception(final String message) {
        super(message);
    }

    public Andromeda081Exception(final String message, final Throwable cause) {
        super(message, cause);
    }

}
