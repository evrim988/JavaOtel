package org.example.javaotel.dto.request;

public record CreateAdminRequestDto(
        String name,
        String email,
        String userName,
        String password
) {
}
