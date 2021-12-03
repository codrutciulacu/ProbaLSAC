package com.codrut.probalsac.user.controller.dto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UpdateUserDTO {
    public final String lastname;
    public final String firstname;
    public final String email;
    public final String password;
    public final String confirmation_password;
    public final String role;
}
