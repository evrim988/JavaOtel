package org.example.javaotel.service;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.javaotel.dto.request.AdminLoginRequestDto;
import org.example.javaotel.dto.request.CreateAdminRequestDto;
import org.example.javaotel.entity.Admin;
import org.example.javaotel.exception.ErrorType;
import org.example.javaotel.exception.JavaOtelException;
import org.example.javaotel.mapper.AdminMapper;
import org.example.javaotel.repository.AdminRepository;
import org.example.javaotel.utility.JwtManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final AdminRepository adminRepository;
    private final JwtManager jwtManager;

    public String doLogin(@Valid AdminLoginRequestDto dto) {
        Optional<Admin> optionalAdmin = adminRepository.findByUserNameAndPassword(dto.userName(), dto.password());
        if(optionalAdmin.isEmpty())
            throw new JavaOtelException(ErrorType.INVALID_USERNAME_OR_PASSWORD);
        String token = jwtManager.createToken(optionalAdmin.get().getId());
        return token;
    }

    public void addAdmin(@Valid CreateAdminRequestDto dto) {
        adminRepository.save(AdminMapper.INSTANCE.fromCreateAdminRequestDto(dto));
    }

    public Admin getProfile(String token) {
        Optional<Long> optionalAdmin = jwtManager.validateToken(token);
        if (optionalAdmin.isEmpty())
            throw new JavaOtelException(ErrorType.INVALID_TOKEN);
        Optional<Admin> admin = adminRepository.findById(optionalAdmin.get());
        if(admin.isEmpty())
            throw new JavaOtelException(ErrorType.ADMIN_NOTFOUND);
        return admin.get();
    }
}
