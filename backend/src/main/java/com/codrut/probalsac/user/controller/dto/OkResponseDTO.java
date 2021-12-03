package com.codrut.probalsac.user.controller.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@RequiredArgsConstructor
public class OkResponseDTO {
    public final String message;
    public final LocalDate timestamp;
}
