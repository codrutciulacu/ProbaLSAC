package com.codrut.probalsac.user.mapper;

import com.codrut.probalsac.user.domain.Role;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class RoleMapper {
    public Role mapToEnum(String roleName) {
        if(roleName.equals(Role.TEACHER.name().toLowerCase()) ||
                roleName.equals(Role.TEACHER.name().toUpperCase()))
            return Role.TEACHER;
        if(roleName.equals(Role.STUDENT.name().toLowerCase()) ||
                roleName.equals(Role.STUDENT.name().toUpperCase()))
            return Role.STUDENT;

        return Role.STUDENT;
    }
}
