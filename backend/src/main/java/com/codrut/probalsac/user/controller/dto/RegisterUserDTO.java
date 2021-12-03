package com.codrut.probalsac.user.controller.dto;

import lombok.RequiredArgsConstructor;

/**
 * {
 * "email": "teacher@onmicrosoft.upb.ro",
 * "firstname": "Mihai",
 * "lastname": "Popescu",
 * "password": "teacher1",
 * "confirmation_password": "teacher1",
 * "role": "teacher"
 * }
 */


@RequiredArgsConstructor
public class RegisterUserDTO {
    public final String email;
    public final String firstname;
    public final String lastname;
    public final String password;
    public final String confirm_password;
    public final String role;
}
