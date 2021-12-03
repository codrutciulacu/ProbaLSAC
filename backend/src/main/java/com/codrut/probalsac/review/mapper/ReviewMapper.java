package com.codrut.probalsac.review.mapper;

import com.codrut.probalsac.review.controller.dto.ReviewCreationDTO;
import com.codrut.probalsac.review.controller.dto.ReviewDTO;
import com.codrut.probalsac.review.domain.Review;
import com.codrut.probalsac.user.domain.User;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapper {
    public ReviewDTO mapToDTO(Review review) {
        return new ReviewDTO(review.getId(), review.getMessage(), review.getUser().getId());
    }

    public Review mapToEntity(ReviewCreationDTO dto, User user) {
        return new Review(dto.message, user);
    }
}
