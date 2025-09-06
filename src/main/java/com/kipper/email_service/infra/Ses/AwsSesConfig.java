package com.kipper.email_service.infra.Ses;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceAsyncClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Configuration
public class AwsSesConfig {

    @Bean
    public AmazonSimpleEmailService amazonSimpleEmailService() {
        log.info("Configurando o serviço da AWS");
        return AmazonSimpleEmailServiceAsyncClientBuilder.standard()
                .withRegion("sa-east-1")
                .build();
    }
}
