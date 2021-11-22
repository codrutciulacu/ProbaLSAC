package com.codrut.probalsac.contact.service;

import com.codrut.probalsac.contact.controller.dto.ContactCreationDTO;
import com.codrut.probalsac.contact.controller.dto.ContactDTO;
import com.codrut.probalsac.contact.controller.dto.ContactUpdateDTO;
import com.codrut.probalsac.contact.mapper.ContactMapper;
import com.codrut.probalsac.contact.repository.ContactRepository;
import com.codrut.probalsac.contact.validation.ContactValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContactService {

    private ContactRepository repository;
    private ContactMapper mapper;
    private ContactValidator validator;

    public ContactDTO save(ContactCreationDTO dto) {
        var entity = mapper.mapToEntity(dto);

        validator.validate(entity);

        return mapper.mapToDTO(repository.save(entity));
    }

    public List<ContactDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::mapToDTO)
                .collect(Collectors.toList());
    }

    public ContactDTO findById(Long id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("The contact with this id does not exist!"));

        return mapper.mapToDTO(entity);
    }

    public void update(Long id, ContactUpdateDTO dto) {
        repository.update(id, dto.isResolved());
    }

    public void delete(Long id) {
        repository.delete(id);
    }

}
