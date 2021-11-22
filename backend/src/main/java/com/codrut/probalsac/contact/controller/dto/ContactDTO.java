package com.codrut.probalsac.contact.controller.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ContactDTO {
    private final Long id;
    private final String name;
    private final String email;
    private final String message;
    private final boolean isResolved;
}
