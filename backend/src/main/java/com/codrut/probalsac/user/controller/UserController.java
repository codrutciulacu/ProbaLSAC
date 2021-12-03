package com.codrut.probalsac.user.controller;

import com.codrut.probalsac.user.controller.dto.UpdateUserDTO;
import com.codrut.probalsac.user.controller.dto.UserDTO;
import com.codrut.probalsac.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping("/")
    public List<UserDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public UserDTO findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PatchMapping("/{id}")
    public void update(@PathVariable("id") Long id, @RequestBody UpdateUserDTO dto) {
        service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
