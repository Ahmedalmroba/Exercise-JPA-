package com.example.capstone.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "must not be null")
    private int id;
    @Column(columnDefinition = "varchar(20) not null unique")
    @NotEmpty(message = "must not be empty")
    @Size(min = 5)
    private String username;
    @Column(columnDefinition = "varchar(20) not null unique")
    @NotEmpty(message = "must not be empty")
    @Size(min = 6)
    @Pattern(regexp = "^(?=.[a-zA-Z])(?=.[0-9]).{6,}$")
    private String password;
    @Column(columnDefinition = "varchar(20) not null unique")
    @NotEmpty(message = "must not be empty")
    @Email
    private String email;
    @Column(columnDefinition = "varchar(20) not null unique")
    @NotEmpty(message = "must not be empty")
    @Size(min = 3)
    @Pattern(regexp = "Admin|Customer")
    private String role;
    @NotNull(message = "must not be null")
    @Positive
    private double balance;
    private double Discount;

}
