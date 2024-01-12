package com.panda.Let.sTalk.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String userEmail;

    private String password;

    @CreationTimestamp
    private LocalDate createdDate;

}
