package com.codrut.probalsac.review.service;

import com.codrut.probalsac.review.controller.dto.ReviewCreationDTO;
import com.codrut.probalsac.review.controller.dto.ReviewDTO;
import com.codrut.probalsac.review.controller.dto.UpdateReviewDTO;
import com.codrut.probalsac.review.mapper.ReviewMapper;
import com.codrut.probalsac.review.repository.ReviewRepository;
import com.codrut.probalsac.user.domain.User;
import com.codrut.probalsac.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository repository;
    private final UserRepository userRepository;
    private final ReviewMapper mapper;

    public void save(ReviewCreationDTO dto) {
        var user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        var entity = mapper.mapToEntity(dto, user);

        repository.save(entity);
    }

    public List<ReviewDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::mapToDTO)
                .collect(Collectors.toList());
    }

    public ReviewDTO findById(Long id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("The user couldn't be found!"));

        return mapper.mapToDTO(entity);
    }

    public void update(Long id, UpdateReviewDTO dto) {
        var user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        var entity = repository.getById(id);

        if(!Objects.equals(entity.getUser().getId(), user.getId())) {
            throw new RuntimeException("The user doesn't have permission for this");
        }

        if (dto.message != null)
            entity.setMessage(dto.message);

        repository.save(entity);
    }

    public void delete(Long id) {
        var user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        var entity = repository.getById(id);

        if(!Objects.equals(entity.getUser().getId(), user.getId())) {
            throw new RuntimeException("The user doesn't have permission for this");
        }

        repository.deleteById(id);
    }

}
