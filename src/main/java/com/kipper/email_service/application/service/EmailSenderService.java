package com.kipper.email_service.application.service;


import com.kipper.email_service.adpter.EmailSenderGateway;
import com.kipper.email_service.core.EmailSenderCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmailSenderService implements EmailSenderCase {

    private EmailSenderGateway emailSenderGateway;

    // Com o Autowired o spring vai procurar altomaticamente alguma classe
    // que tenha implementado a interface EmailSenderGateway
    @Autowired
    public EmailSenderService(@Qualifier("sendEmailSender") EmailSenderGateway emailSenderGateway) {
        this.emailSenderGateway = emailSenderGateway;
    }


    @Override
    public void sendEmail(String to, String subject, String body) {

        log.info("Chamando um serviço que tenha implementado a interface EmailSenderGateway");
        this.emailSenderGateway.sendEmail(to, subject, body);
    }
}
