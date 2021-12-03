package com.codrut.probalsac.review.validation;

import com.codrut.probalsac.review.controller.dto.ReviewCreationDTO;
import org.springframework.stereotype.Component;

@Component
public class ReviewValidation {

    public void validate(ReviewCreationDTO dto) {
        if(!(dto.message.length() <= 500 && !dto.message.isEmpty()))
            throw new RuntimeException("The message is too short or to long!");
        if(dto.user_id < 0)
            throw new RuntimeException("The message is too short or to long!");
    }

}
