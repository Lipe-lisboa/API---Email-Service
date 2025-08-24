package com.kipper.email_service.application.service;


import com.kipper.email_service.adpter.EmailSenderGateway;
import com.kipper.email_service.core.EmailSenderCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService implements EmailSenderCase {

    private EmailSenderGateway emailSenderGateway;

    // Com o Autowired o spring vai procurar altomaticamente alguma classe
    // que tenha implementado a interface EmailSenderGateway
    @Autowired
    public EmailSenderService(EmailSenderGateway emailSenderGateway) {
        this.emailSenderGateway = emailSenderGateway;
    }


    @Override
    public void sendEmail(String to, String subject, String body) {
        this.emailSenderGateway.sendEmail(to, subject, body);
    }
}
