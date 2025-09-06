package com.kipper.email_service.infra.Ses;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.*;
import com.kipper.email_service.adpter.EmailSenderGateway;
import com.kipper.email_service.core.exceptions.EmailServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SesEmailSender implements EmailSenderGateway {

    private  final AmazonSimpleEmailService amazonSimpleEmailService;

    @Autowired
    public SesEmailSender(AmazonSimpleEmailService amazonSimpleEmailService) {
        this.amazonSimpleEmailService = amazonSimpleEmailService;
    }

    @Override
    public void sendEmail(String to, String subject, String body) {

        log.info("Estrturando o email");
        SendEmailRequest request = new SendEmailRequest()
                .withSource("filipelisboaalves@gmail.com")
                .withDestination(new Destination().withToAddresses(to))
                .withMessage(new Message()
                        .withSubject(new Content(subject))
                        .withBody(new Body().withText(new Content(body)))
                );

        log.info("Email enviado");
        this.amazonSimpleEmailService.sendEmail(request);
    }
}
