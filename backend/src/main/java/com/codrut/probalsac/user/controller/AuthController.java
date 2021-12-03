package com.codrut.probalsac.user.controller;

import com.codrut.probalsac.user.controller.dto.OkResponseDTO;
import com.codrut.probalsac.user.controller.dto.RegisterUserDTO;
import com.codrut.probalsac.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<OkResponseDTO> register(@RequestBody RegisterUserDTO dto) {
        userService.save(dto);

        return ResponseEntity
                .ok(new OkResponseDTO("The user was created successfully!", LocalDate.now()));
    }
}
