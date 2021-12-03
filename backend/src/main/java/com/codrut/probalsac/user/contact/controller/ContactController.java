package com.codrut.probalsac.user.contact.controller;

import com.codrut.probalsac.user.contact.controller.dto.ContactCreationDTO;
import com.codrut.probalsac.user.contact.controller.dto.ContactDTO;
import com.codrut.probalsac.user.contact.controller.dto.ContactUpdateDTO;
import com.codrut.probalsac.user.contact.controller.dto.MessageResponseDTO;
import com.codrut.probalsac.user.contact.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/contact-requests")
@RequiredArgsConstructor
public class ContactController {

    private final ContactService service;

    @PostMapping("/")
    public ResponseEntity<ContactDTO> save(@RequestBody ContactCreationDTO dto) {
        var response = service.save(dto);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/")
    public List<ContactDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ContactDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MessageResponseDTO> update(@PathVariable Long id, @RequestBody ContactUpdateDTO dto) {
        service.update(id, dto);

        return ResponseEntity.ok(new MessageResponseDTO("The entity was updated successfully!"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponseDTO> delete(@PathVariable Long id) {
        service.delete(id);

        return ResponseEntity.ok(new MessageResponseDTO("The entity was deleted successfully!"));
    }
}
