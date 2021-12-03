package com.codrut.probalsac.tutoringClass.controller;

import com.codrut.probalsac.tutoringClass.service.EnrollmentService;
import com.codrut.probalsac.user.controller.dto.OkResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/tutoring-class")
@RequiredArgsConstructor
public class EnrollmentController {

    private final EnrollmentService service;

    @PostMapping("/{id}/enroll")
//    @PreAuthorize("hasRole('ROLE_STUDENT')")
    public ResponseEntity<OkResponseDTO> enroll(@PathVariable Long id) {
        var response = service.enroll(id);

        return ResponseEntity.ok(
                new OkResponseDTO("The enrollment with the id: " + response.getId() + " has been done!",
                LocalDate.now()));
    }

}
