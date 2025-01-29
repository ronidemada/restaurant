package com.example.restaurant.service;

import com.example.restaurant.dto.ClientsDTO;
import com.example.restaurant.entity.Clients;

import java.util.ArrayList;

public class ClientsMapperService {

    // Convert Clients JPA Entity into ClientsDTO
    public static ClientsDTO mapToClientsDTO(Clients clients){
        return new ClientsDTO(
                clients.getId(),
                clients.getFirstname(),
                clients.getLastname(),
                clients.getEmail()
        );
    }

    // Convert ClientsDTO into Clients JPA Entity
    public static Clients mapToClients(ClientsDTO clientsDTO){
        return new Clients(
                clientsDTO.getId(),
                clientsDTO.getFirstname(),
                clientsDTO.getLastname(),
                clientsDTO.getEmail(),
                new ArrayList<>()
        );
    }
}
