package com.ib.flowsync.exception;

public class EmailExistsEception extends RuntimeException {
    public EmailExistsEception(String message) {
        super(message);
    }
}
