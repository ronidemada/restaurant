package com.example.restaurant.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "CLIENTS")
public class Clients {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "lastname for Client is required")
    private String lastname;

    @NotNull(message = "firstname for Client is required")
    private String firstname;

    @NotNull(message = "email for Client is required")
    @Email(message = "Please enter a valid email")
    private String email;

    @OneToMany(mappedBy = "clients")
    @JsonIgnore
    private List<Commandes> cmdList = new ArrayList<>();
}
