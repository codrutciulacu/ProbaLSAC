package com.codrut.probalsac.user.contact.controller.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class ContactUpdateDTO {
    public Boolean is_resolved;

    public ContactUpdateDTO() {
        is_resolved = false;
    }

    public ContactUpdateDTO(Boolean is_resolved) {
        this.is_resolved = is_resolved;
    }

    public void setIsResolved(Boolean isResolved) {
        this.is_resolved = isResolved;
    }
}
