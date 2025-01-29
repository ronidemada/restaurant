package com.example.restaurant.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ClientsDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull(message = "firstname for Client is required")
    private String firstname;
    @NotNull(message = "lastname for Client is required")
    private String lastname;
    @NotNull(message = "email for Client is required")
    @Email(message = "Please enter a valid email")
    private String email;

}
