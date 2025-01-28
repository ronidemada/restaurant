package com.example.restaurant.service;

import com.example.restaurant.dto.ClientsDto;
import com.example.restaurant.entity.Clients;
import com.example.restaurant.exception.ClientNotFoundException;
import com.example.restaurant.repository.IClientsRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientsMapperService {

    private final IClientsRepository clientsRepository;

    public ClientsMapperService(IClientsRepository clientsRepository) {
        this.clientsRepository = clientsRepository;
    }

    public ClientsDto toDTO(Clients client){
        return new ClientsDto(
                client.getId(),
                client.getLastname() +" "+client.getFirstname()
        );
    }

    public ClientsDto getUserById(Long id) {
        Clients clients = clientsRepository.findById(id).orElseThrow(() -> new ClientNotFoundException("Client not found DTO"));
        return toDTO(clients);
    }
}
