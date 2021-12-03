package com.codrut.probalsac.user.contact.mapper;

import com.codrut.probalsac.user.contact.controller.dto.ContactCreationDTO;
import com.codrut.probalsac.user.contact.controller.dto.ContactDTO;
import com.codrut.probalsac.user.contact.domain.Contact;
import org.springframework.stereotype.Component;

@Component
public class ContactMapper {

    public Contact mapToEntity(ContactDTO dto) {
        return new Contact(dto.name,
                dto.email,
                dto.message,
                dto.is_resolved);
    }

    public Contact mapToEntity(ContactCreationDTO dto) {
        return new Contact(dto.name,
                dto.email,
                dto.message,
                false);
    }

    public ContactDTO mapToDTO(Contact entity) {
        return new ContactDTO(entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getMessage(),
                entity.getIsResolved());
    }
}
