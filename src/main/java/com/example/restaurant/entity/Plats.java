package com.example.restaurant.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "PLATS")
public class Plats {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "name for Plats is required")
    private String name;

    @NotNull(message = "type for Plat is required")
    private String type;

    @NotNull(message = "price for Plat is required")
    private Double price;

    @ManyToMany(mappedBy = "platsList")
    @JsonIgnore
    private List<Commandes> cmdList = new ArrayList<>();
}
