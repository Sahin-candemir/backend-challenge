package com.enoca.backendchallenge.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Employee extends BaseEntity{

    private String firstName;

    private String lastName;

    private String email;

    private int age;

    @ManyToOne
    private Company company;
}
