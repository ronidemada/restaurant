package com.example.restaurant.service;

import com.example.restaurant.dto.ClientDto;
import com.example.restaurant.entity.Clients;
import com.example.restaurant.exception.ClientNotFoundException;
import com.example.restaurant.repository.IClientsRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientMapperService {

    private final IClientsRepository clientsRepository;

    public ClientMapperService(IClientsRepository clientsRepository) {
        this.clientsRepository = clientsRepository;
    }

    public ClientDto toDTO(Clients client){
        return new ClientDto(
                client.getId(),
                client.getLastname() +" "+client.getFirstname()
        );
    }

    public ClientDto getUserById(Long id) {
        Clients clients = clientsRepository.findById(id).orElseThrow(() -> new ClientNotFoundException("Client not found DTO"));
        return toDTO(clients);
    }
}
