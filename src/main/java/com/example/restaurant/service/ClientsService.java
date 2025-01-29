package com.example.restaurant.service;

import com.example.restaurant.dto.ClientsDTO;
import com.example.restaurant.entity.Clients;
import com.example.restaurant.exception.ClientNotFoundException;
import com.example.restaurant.repository.IClientsRepository;
import org.hibernate.sql.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
public class ClientsService {

    private final IClientsRepository clientsRepository;

    public ClientsService(IClientsRepository clientsRepository) {
        this.clientsRepository = clientsRepository;
    }

    public ClientsDTO addClient(ClientsDTO clientDTO) {

        // Convert UserDto into User JPA Entity
        Clients clients = ClientsMapperService.mapToClients(clientDTO);

        Clients savedClients = clientsRepository.save(clients);

        // Convert User JPA entity to UserDto
        ClientsDTO savedDTO = ClientsMapperService.mapToClientsDTO(savedClients);

        return savedDTO;
    }

    public ClientsDTO updateClient(Long id, ClientsDTO clientDTO){

        Optional<Clients> optionalClients = clientsRepository.findById(id);

        // Convert UserDto into User JPA Entity
        Clients clients = ClientsMapperService.mapToClients(clientDTO);

        //if (optionalClients.isPresent()) {

            Clients clientUpdate = optionalClients.get();
            clientUpdate.setLastname(clients.getLastname());
            clientUpdate.setFirstname(clients.getFirstname());
            clientUpdate.setEmail(clients.getEmail());

            Clients updatedClients = clientsRepository.save(clientUpdate);

            // Convert User JPA entity to UserDto
            ClientsDTO updatedDTO = ClientsMapperService.mapToClientsDTO(updatedClients);

            return updatedDTO;
        //}
    }

    public void deleteClient(Long id) {

        Optional<Clients> client = clientsRepository.findById(id);

        if(client.isEmpty()){
            throw new ClientNotFoundException("Client avec ID " + id + " non trouvé");
        }else{
            client.ifPresent(clientsRepository::delete);
        }
    }

}
