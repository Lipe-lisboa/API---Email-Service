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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service("sendEmailSender")
public class SendEmailSender implements EmailSenderGateway {

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

        Mail mail = new Mail(from, subEmail, toEmail, contentEmail);
        Request request = new Request();

        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sendGrid.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException e){
            throw new EmailServiceException("Failed to send email", e);
        }

    }
}
