package com.codrut.probalsac.contact.controller.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ContactCreationDTO {
    public final String name;
    public final String email;
    public final String message;
}
