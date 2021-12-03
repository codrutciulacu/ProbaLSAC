package com.codrut.probalsac.review.domain;

import com.codrut.probalsac.user.domain.User;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String message;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
