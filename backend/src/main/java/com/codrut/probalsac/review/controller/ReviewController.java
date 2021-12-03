package com.codrut.probalsac.review.controller;

import com.codrut.probalsac.review.controller.dto.ReviewCreationDTO;
import com.codrut.probalsac.review.controller.dto.ReviewDTO;
import com.codrut.probalsac.review.controller.dto.UpdateReviewDTO;
import com.codrut.probalsac.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService service;

    @PostMapping("/")
    public void save(@RequestBody ReviewCreationDTO dto) {
        service.save(dto);
    }

    @GetMapping("/")
    public List<ReviewDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ReviewDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PatchMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody UpdateReviewDTO dto) {
        service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
