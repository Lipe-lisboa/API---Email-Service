package com.kipper.email_service.infra.sendGrid;

import com.kipper.email_service.adpter.EmailSenderGateway;
import com.kipper.email_service.core.exceptions.EmailServiceException;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service("sendEmailSender")
public class SendEmailSender implements EmailSenderGateway {
    private static final Logger log = LoggerFactory.getLogger(SendEmailSender.class);
    private final SendGrid sendGrid;

    public SendEmailSender(SendGrid sendGrid) {
        this.sendGrid = sendGrid;
    }

    @Value("${sendgrid.from-email}")
    private String fromEmail;

    @Override
    public void sendEmail(String to, String subject, String body) {

        Email from = new Email(fromEmail);
        String subEmail = subject;
        Email toEmail = new Email(to);
        Content contentEmail = new Content("text/plain", body);

        log.info("Agrupando as informações do email no objeto Mail");
        Mail mail = new Mail(from, subEmail, toEmail, contentEmail);
        Request request = new Request();

        try {
            log.info("Iniciando o processo de enviar o email");
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            sendGrid.api(request);
            log.info("Email enviado");
        } catch (IOException e){
            log.info("Falha ao enviar o email");
            throw new EmailServiceException("Failed to send email", e);
        }

    }
}
