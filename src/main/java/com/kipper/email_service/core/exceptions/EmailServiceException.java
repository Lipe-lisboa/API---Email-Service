package com.kipper.email_service.core.exceptions;

import javax.swing.text.TableView;

public class EmailServiceException extends RuntimeException {
    public EmailServiceException(String message) {super(message);}


    public EmailServiceException(String message, Throwable cause) {
        super(message, cause);}
}
