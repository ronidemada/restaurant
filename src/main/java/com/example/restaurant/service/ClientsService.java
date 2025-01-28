package com.example.restaurant.service;

import com.example.restaurant.entity.Clients;
import com.example.restaurant.exception.ClientNotFoundException;
import com.example.restaurant.repository.IClientsRepository;
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

    public Clients addClient(Clients client) {
        return clientsRepository.save(client);
    }

    public void updateClient(Long id, Clients clients){

        Optional<Clients> optionalClients = clientsRepository.findById(id);

        if (optionalClients.isPresent()) {

            Clients clientUpdate = optionalClients.get();
            clientUpdate.setLastname(clients.getLastname());
            clientUpdate.setFirstname(clients.getFirstname());
            clientUpdate.setEmail(clients.getEmail());

            clientsRepository.save(clientUpdate);
        }

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
