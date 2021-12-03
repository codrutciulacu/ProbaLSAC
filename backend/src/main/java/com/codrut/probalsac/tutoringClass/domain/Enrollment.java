package com.codrut.probalsac.tutoringClass.domain;

import com.codrut.probalsac.tutoringClass.domain.TutoringClass;
import com.codrut.probalsac.user.domain.User;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "enrollments")
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tutoring_class_id")
    private TutoringClass tutoringClass;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private User student;
}
