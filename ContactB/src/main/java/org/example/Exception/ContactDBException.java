package org.example.Exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ContactDBException extends Exception {

    private String message;

    public ContactDBException(String message) {
        super(message);
        this.message = message;
    }
}

