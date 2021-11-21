package com.codrut.probalsac.contact.repository;

import com.codrut.probalsac.contact.domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    Optional<Contact> findById(Long id);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE contact c SET c.is_resolved=:isResolved where c.id = :id")
    void update(@Param("id") Long id, @Param("isResolved") boolean isResolved);

    @Query("DELETE contact c WHERE c.id = :id")
    void delete(@Param("id") Long id);
}
