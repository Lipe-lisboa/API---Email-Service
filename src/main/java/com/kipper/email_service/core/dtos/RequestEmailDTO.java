package com.kipper.email_service.core.dtos;

public record RequestEmailDTO(
        String to,
        String subject,
        String body
) {}
