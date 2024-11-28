package org.example.javaotel.dto.request;

import jakarta.validation.constraints.Email;

public record CreateAdminRequestDto(
        String name,
        String surname,
        @Email
        String email,
        String userName,
        String password
) {
}
