package com.codrut.probalsac.review.controller.dto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ReviewDTO {
    public final Long id;
    public final String message;
    public final Long user_id;
}
