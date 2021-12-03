package com.codrut.probalsac.review.controller.dto;

import lombok.RequiredArgsConstructor;

public class ReviewCreationDTO {
    public String message;

    public ReviewCreationDTO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
