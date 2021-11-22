package com.codrut.probalsac.contact.mapper;

import com.codrut.probalsac.contact.controller.dto.ContactCreationDTO;
import com.codrut.probalsac.contact.controller.dto.ContactDTO;
import com.codrut.probalsac.contact.domain.Contact;
import org.springframework.stereotype.Component;

@Component
public class ContactMapper {

    public Contact mapToEntity(ContactDTO dto) {
        return new Contact(dto.getName(),
                dto.getEmail(),
                dto.getMessage(),
                dto.isResolved());
    }

    public Contact mapToEntity(ContactCreationDTO dto) {
        return new Contact(dto.getName(),
                dto.getEmail(),
                dto.getMessage(),
                false);
    }

    public ContactDTO mapToDTO(Contact entity) {
        return new ContactDTO(entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getMessage(),
                entity.isResolved());
    }
}
