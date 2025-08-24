package com.kipper.email_service.core;


// uso principal da aplicação
//interface (contrato) que define o comportamento da nossa aplicação
// lógica de negocio
public interface EmailSenderCase {

    void sendEmail(String to, String subject,String body);
}
