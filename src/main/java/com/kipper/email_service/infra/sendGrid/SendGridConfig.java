package com.kipper.email_service.infra.sendGrid;

import com.sendgrid.SendGrid;
import io.github.cdimascio.dotenv.Dotenv;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class SendGridConfig {

    //@Value("${API_KEY}")
    //private String apiKey;

    @Bean
    public SendGrid sendGrid() {
        log.info("Carregando o arquivo dotenv");
        Dotenv dotenv = Dotenv.load();

        log.info("Configurando a chave da API");
        return new SendGrid(dotenv.get("API_SEND_GRID_KEY"));
    }
}
