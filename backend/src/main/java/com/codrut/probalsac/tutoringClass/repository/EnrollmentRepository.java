package com.codrut.probalsac.tutoringClass.repository;

import com.codrut.probalsac.tutoringClass.domain.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
}
