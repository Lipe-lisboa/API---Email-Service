package com.kipper.email_service.adpter;

// contrato da aplicação com o provedor de serviço (APIs provedoras de email, AWS ses sdk...)

public interface EmailSenderGateway {

    void sendEmail(String to, String subject,String body);
}
