package com.kipper.email_service.infra.sendGrid;

import com.sendgrid.SendGrid;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SendGridConfig {

    //@Value("${API_KEY}")
    //private String apiKey;

    @Bean
    public SendGrid sendGrid() {
        Dotenv dotenv = Dotenv.load();
        return new SendGrid(dotenv.get("API_SEND_GRID_KEY"));
    }
}
