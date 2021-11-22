package com.codrut.probalsac.contact.controller.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ContactCreationDTO {
    private final String name;
    private final String email;
    private final String message;
}
