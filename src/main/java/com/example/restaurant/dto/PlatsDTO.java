package com.example.restaurant.dto;

import com.example.restaurant.entity.Commandes;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PlatsDTO{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "name for Plats is required")
    private String name;

    @NotNull(message = "type for Plat is required")
    private String type;

    @NotNull(message = "price for Plat is required")
    private Double price;

    private List<Commandes> cmdList = new ArrayList<>();
}
