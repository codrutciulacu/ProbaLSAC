package com.codrut.probalsac.tutoringClass.service;

import com.codrut.probalsac.tutoringClass.domain.Enrollment;
import com.codrut.probalsac.tutoringClass.repository.EnrollmentRepository;
import com.codrut.probalsac.tutoringClass.repository.TutoringClassRepository;
import com.codrut.probalsac.user.domain.Role;
import com.codrut.probalsac.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnrollmentService {

    private final EnrollmentRepository repository;
    private final TutoringClassRepository tutoringClassRepository;


    public Enrollment enroll(Long classId) {
        var student = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        var tutoringClass = tutoringClassRepository.findById(classId)
                .orElseThrow(() -> new RuntimeException("The tutoring class couldn't be found!"));

        if (student.getRole() != Role.STUDENT)
            throw new RuntimeException("You are a teacher, can't perform this action");

        return repository.save(new Enrollment(tutoringClass, student));
    }

}
