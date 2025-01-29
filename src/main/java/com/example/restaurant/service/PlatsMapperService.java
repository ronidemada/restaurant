package com.example.restaurant.service;

import com.example.restaurant.dto.PlatsDTO;
import com.example.restaurant.entity.Plats;

public class PlatsMapperService {

    // Convert Plats JPA Entity into PlatsDTO
    public static PlatsDTO mapToPlatsDTO(Plats plats){
        return new PlatsDTO(
                plats.getId(),
                plats.getName(),
                plats.getType(),
                plats.getPrice(),
                plats.getCmdList()
        );
    }

    // Convert ClientsDTO into Clients JPA Entity
    public static Plats mapToPlats(PlatsDTO platsDTO){
        return new Plats(
                platsDTO.getId(),
                platsDTO.getName(),
                platsDTO.getType(),
                platsDTO.getPrice(),
                platsDTO.getCmdList()
        );
    }
}
