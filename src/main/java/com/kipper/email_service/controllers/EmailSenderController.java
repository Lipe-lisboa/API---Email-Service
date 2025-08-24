package com.kipper.email_service.controllers;

import com.kipper.email_service.application.service.EmailSenderService;
import com.kipper.email_service.core.dtos.RequestEmailDTO;
import com.kipper.email_service.core.exceptions.EmailServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
public class EmailSenderController {

    private final EmailSenderService emailSenderService;

    @Autowired
    public EmailSenderController(EmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }

    @PostMapping
    public ResponseEntity<String> sendEmail(@RequestBody RequestEmailDTO email){
        try {
            this.emailSenderService.sendEmail(
                    email.to(),
                    email.subject(),
                    email.body()
            );

            return ResponseEntity.status(HttpStatus.OK).body("Email send successfully");

        }catch (EmailServiceException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to send email");
        }
    }
}
