package com.codrut.probalsac.user.mapper;

import com.codrut.probalsac.user.controller.dto.RegisterUserDTO;
import com.codrut.probalsac.user.controller.dto.UserDTO;
import com.codrut.probalsac.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {
    private final RoleMapper roleMapper;
    public UserDTO mapToDTO(User user) {
        return new UserDTO(user.getLastname(),
                user.getFirstname(),
                user.getEmail(),
                user.getRole().name());
    }

    public User mapToEntity(RegisterUserDTO dto) {
        return new User(dto.lastname,
                dto.firstname,
                dto.email,
                dto.password,
                roleMapper.mapToEnum(dto.role));
    }
}
