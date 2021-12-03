package com.codrut.probalsac.user.service;

import com.codrut.probalsac.user.controller.dto.RegisterUserDTO;
import com.codrut.probalsac.user.controller.dto.UpdateUserDTO;
import com.codrut.probalsac.user.controller.dto.UserDTO;
import com.codrut.probalsac.user.domain.Role;
import com.codrut.probalsac.user.mapper.UserMapper;
import com.codrut.probalsac.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository repository;
    private final UserMapper mapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByEmail(username)
                .orElseThrow(() -> new RuntimeException("The user couldn't be found!"));
    }

    public void save(RegisterUserDTO dto) {
        var entity = mapper.mapToEntity(dto);

        //TODO: validation
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));

        repository.save(entity);
    }

    public List<UserDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::mapToDTO)
                .collect(Collectors.toList());
    }

    public UserDTO findById(Long id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("The user couldn't be found!"));

        return mapper.mapToDTO(entity);
    }

    public void update(Long id, UpdateUserDTO dto) {
        var userToUpdate = repository.getById(id);

        if (dto.firstname != null && !dto.firstname.isEmpty())
            userToUpdate.setFirstname(dto.firstname);

        if (dto.lastname != null && !dto.lastname.isEmpty())
            userToUpdate.setLastname(dto.lastname);

        if (dto.email != null && !dto.email.isEmpty())
            userToUpdate.setEmail(dto.email);

        if (dto.password != null && !dto.password.isEmpty() &&
                dto.confirm_password != null && !dto.confirm_password.isEmpty() &&
                dto.confirm_password.equals(dto.password))
            userToUpdate.setPassword(dto.password);

        if (dto.role != null && !dto.role.isEmpty())
            userToUpdate.setRole(Role.valueOf(dto.role));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
