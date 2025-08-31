package com.kipper.email_service.controllers;

import com.kipper.email_service.application.service.EmailSenderService;
import com.kipper.email_service.core.dtos.RequestEmailDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
public class EmailSenderController {

    private final EmailSenderService emailSenderService;

    @Autowired
    public EmailSenderController(EmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }

    @Operation(description = "Endpoint responsável enviar o email")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Email enviado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Falha ao enviar o email. " +
                "Verifique se os capos estão preenchidos corretamente"),
        @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @PostMapping
    public ResponseEntity<String> sendEmail(@RequestBody @Valid RequestEmailDTO email){
            this.emailSenderService.sendEmail(
                    email.to(),
                    email.subject(),
                    email.body()
            );

            return ResponseEntity.status(HttpStatus.OK).body("Email send successfully");
    }
}
