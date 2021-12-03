package com.codrut.probalsac.tutoringClass.mapper;

import com.codrut.probalsac.tutoringClass.controller.dto.TutoringClassCreationRequestDTO;
import com.codrut.probalsac.tutoringClass.controller.dto.TutoringClassDTO;
import com.codrut.probalsac.tutoringClass.controller.dto.TutoringClassUpdateRequestDTO;
import com.codrut.probalsac.tutoringClass.domain.TutoringClass;
import com.codrut.probalsac.user.domain.User;
import org.springframework.stereotype.Component;

@Component
public class TutoringClassMapper {

    public TutoringClass mapToEntity(TutoringClassCreationRequestDTO dto, User teacher) {
        return new TutoringClass(dto.description, teacher, dto.subject);
    }

    public TutoringClassDTO mapToDTO(TutoringClass entity) {
        return new TutoringClassDTO(entity.getId(),
                entity.getDescription(),
                entity.getTeacher().getId(),
                entity.getSubject());
    }
}
