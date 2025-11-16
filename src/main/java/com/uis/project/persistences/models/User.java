package com.uis.project.persistences.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(indexes = {
        @Index(name = "idx_email", columnList = "email", unique = true)
})
@Data
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "first_name")
    private String firstName;
    @Column(name = "second_name")
    private String secondName;
    @Column(name = "first_last_name", nullable = false)
    private String firstLastName;
    @Column(name = "second_last_name")
    private String secondLastName;

    @Column(name = "email")
    private String email;

    @Column(nullable = false, length = 355)
    private String password;
    @Column(unique = true, length = 20)
    private String phone;

}
