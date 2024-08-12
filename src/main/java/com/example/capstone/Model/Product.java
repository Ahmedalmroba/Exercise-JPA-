package com.example.capstone.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "must not be null")
    private int id;
    @Column(columnDefinition = "varchar(20) not null unique")
    @NotEmpty(message = "must not be empty")
    @Size(min = 3)
    private String name;
   @NotNull(message = "must not be null")
   @Column(columnDefinition = " double not null ")
    @Positive
    private double price;
    @Column(columnDefinition = "varchar(20) not null unique")
    @NotEmpty(message = "must not be empty")
    private String categoryID;

}
