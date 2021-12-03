package com.codrut.probalsac.user.mapper;

import com.codrut.probalsac.user.controller.dto.UserDTO;
import com.codrut.probalsac.user.domain.User;

public class UserMapper {
    public UserDTO mapToDTO(User user) {
        return new UserDTO(user.getLastname(),
                user.getFirstname(),
                user.getEmail(),
                user.getRole().toString());
    }
}
