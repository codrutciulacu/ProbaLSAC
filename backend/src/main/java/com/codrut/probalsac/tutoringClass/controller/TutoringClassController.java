package com.codrut.probalsac.tutoringClass.controller;

import com.codrut.probalsac.tutoringClass.controller.dto.TutoringClassDTO;
import com.codrut.probalsac.tutoringClass.controller.dto.TutoringClassCreationRequestDTO;
import com.codrut.probalsac.tutoringClass.controller.dto.TutoringClassUpdateRequestDTO;
import com.codrut.probalsac.tutoringClass.service.TutoringClassService;
import com.codrut.probalsac.user.controller.dto.OkResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/tutoring-classes")
@RequiredArgsConstructor
public class TutoringClassController {

    private final TutoringClassService service;

    @GetMapping("/")
    public List<TutoringClassDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public TutoringClassDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping("/")
    public ResponseEntity<OkResponseDTO> save(@RequestBody TutoringClassCreationRequestDTO dto) {
        service.save(dto);
        return ResponseEntity.ok(new OkResponseDTO("The tutoring class was created with success!", LocalDate.now()));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<OkResponseDTO> update(@PathVariable Long id, @RequestBody TutoringClassUpdateRequestDTO dto) {
        service.update(id, dto);
        return ResponseEntity.ok(new OkResponseDTO("The tutoring class was updated with success!", LocalDate.now()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<OkResponseDTO> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok(new OkResponseDTO("The tutoring class was deleted with success!", LocalDate.now()));
    }
}
