package com.codrut.probalsac.tutoringClass.domain;

import com.codrut.probalsac.user.domain.User;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "tutoring_classes")
public class TutoringClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String description;

    @NonNull
    @OneToOne
    private User teacher;

    @NonNull
    private String subject;

    public TutoringClass() {
        description = "";
        teacher = new User();
        subject = "";
    }
}
