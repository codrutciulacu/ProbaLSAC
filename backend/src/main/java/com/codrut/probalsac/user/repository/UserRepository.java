package com.codrut.probalsac.user.repository;

import com.codrut.probalsac.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    @Query("DELETE users u WHERE u.id = :id")
    void delete(@Param("id") Long id);

}