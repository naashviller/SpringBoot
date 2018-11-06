package ru.itis.exceptions;

@SuppressWarnings("serial")
public class EmailExistsExceptions extends Throwable {
    public EmailExistsExceptions(final String message) {
        super(message);
    }
}
