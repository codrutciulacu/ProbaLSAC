package com.codrut.probalsac.review.mapper;

import com.codrut.probalsac.review.controller.dto.ReviewCreationDTO;
import com.codrut.probalsac.review.controller.dto.ReviewDTO;
import com.codrut.probalsac.review.domain.Review;

public class ReviewMapper {
    public ReviewDTO mapToDTO(Review review) {
        return new ReviewDTO(review.getId(), review.getMessage(), review.getUserId());
    }

    public Review mapToEntity(ReviewCreationDTO dto) {
        return new Review(dto.message, dto.user_id);
    }
}
