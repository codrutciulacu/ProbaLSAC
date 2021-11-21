package com.codrut.probalsac.contact.controller.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ContactUpdateDTO {
    private final boolean isResolved;
}
