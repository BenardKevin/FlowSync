package com.ib.flowsync.exception;

public class AddressExistsException extends RuntimeException {
    public AddressExistsException(String message) {
        super(message);
    }
}
