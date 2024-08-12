package com.example.capstone.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class MerchantStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(columnDefinition = "varchar(15) not null unique")
    @NotEmpty(message = "must not be empty")
    @Size(min = 3)
    private String productid;
    @Column(columnDefinition = "varchar(20) not null unique")
    @NotEmpty(message = "must not be empty")
    @Size(min = 2)
    private String merchantid;
    @NotNull(message = "must not be null ")
    @Column(columnDefinition = "int not null ")
    @Size(min = 10)
    private int stock;
}
