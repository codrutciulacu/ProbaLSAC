package com.codrut.probalsac.user.contact.domain;


import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "contacts")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private final String name;
    private final String email;
    private final String message;

    @Column(name = "is_resolved")
    @NonNull
    private Boolean isResolved;

    public Contact() {
        name = "";
        email = "";
        message = "";
        isResolved = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Contact contact = (Contact) o;

        return Objects.equals(id, contact.id)
                && Objects.equals(name, contact.name)
                && Objects.equals(email, contact.email)
                && Objects.equals(message, contact.message)
                && Objects.equals(isResolved, contact.isResolved);
    }

}
