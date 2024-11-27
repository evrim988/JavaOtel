package org.example.javaotel.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import static org.example.javaotel.constant.RestApis.*;

import org.example.javaotel.dto.request.AdminLoginRequestDto;
import org.example.javaotel.dto.request.CreateAdminRequestDto;
import org.example.javaotel.dto.response.BaseResponse;
import org.example.javaotel.service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ADMIN)
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;

    @PostMapping(ADMIN_ADD)
    public ResponseEntity<BaseResponse<Boolean>> addAdmin(@RequestBody @Valid CreateAdminRequestDto dto) {
        adminService.addAdmin(dto);
        return ResponseEntity.ok(BaseResponse.<Boolean>builder()
                .code(200)
                .success(true)
                .message("Enter success")
                .data(true)
                .build());
    }

    @PostMapping(ADMIN_LOGIN)
    public ResponseEntity<BaseResponse<String>> doLogin(@RequestBody @Valid AdminLoginRequestDto dto){
        return ResponseEntity.ok(BaseResponse.<String>builder()
                        .code(200)
                        .success(true)
                        .message("Ok.")
                        .data(adminService.doLogin(dto))
                .build());
    }
}
