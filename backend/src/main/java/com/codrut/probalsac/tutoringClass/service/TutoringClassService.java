package com.codrut.probalsac.tutoringClass.service;

import com.codrut.probalsac.tutoringClass.controller.dto.TutoringClassCreationRequestDTO;
import com.codrut.probalsac.tutoringClass.controller.dto.TutoringClassDTO;
import com.codrut.probalsac.tutoringClass.controller.dto.TutoringClassUpdateRequestDTO;
import com.codrut.probalsac.tutoringClass.mapper.TutoringClassMapper;
import com.codrut.probalsac.tutoringClass.repository.TutoringClassRepository;
import com.codrut.probalsac.user.controller.dto.RegisterUserDTO;
import com.codrut.probalsac.user.controller.dto.UpdateUserDTO;
import com.codrut.probalsac.user.controller.dto.UserDTO;
import com.codrut.probalsac.user.domain.Role;
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
public class TutoringClassService {

    private final TutoringClassRepository repository;
    private final UserRepository userRepository;
    private final TutoringClassMapper mapper;

    public void save(TutoringClassCreationRequestDTO dto) {
        var teacher = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        var entity = mapper.mapToEntity(dto, teacher);

        if(teacher.getRole() != Role.TEACHER) {
            throw new RuntimeException("The user is not a teacher");
        }

        repository.save(entity);
    }

    public List<TutoringClassDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::mapToDTO)
                .collect(Collectors.toList());
    }

    public TutoringClassDTO findById(Long id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("The tutoring class couldn't be found!"));

        return mapper.mapToDTO(entity);
    }

    public void update(Long id, TutoringClassUpdateRequestDTO dto) {
        var classToUpdate = repository.getById(id);
        var user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if(!Objects.equals(classToUpdate.getTeacher().getId(), user.getId())) {
            throw new RuntimeException("The user doesn't have permission for this");
        }

        classToUpdate.setDescription(dto.description);

        repository.save(classToUpdate);
    }

    public void delete(Long id) {
        var classToUpdate = repository.getById(id);
        var user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if(!Objects.equals(classToUpdate.getTeacher().getId(), user.getId())) {
            throw new RuntimeException("The user doesn't have permission for this");
        }
        repository.deleteById(id);
    }

}
