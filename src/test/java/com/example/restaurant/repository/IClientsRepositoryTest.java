package com.example.restaurant.repository;

import com.example.restaurant.entity.Clients;
import lombok.Data;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class IClientsRepositoryTest {
    @Autowired
    private IClientsRepository clientsRepository;
    @Test
    void saveClients(){
        Clients clients = new Clients();
        clients.setLastname("SAVY");
        clients.setFirstname("Steve");
        clients.setEmail("s@gmail.com");

        Clients saveClient = clientsRepository.save(clients);
        assertNotNull(saveClient.getId());
        assertEquals("SAVY",saveClient.getLastname());
        assertEquals("Steve",saveClient.getFirstname());
        assertEquals("s@gmail.com",saveClient.getEmail());
    }

    @Test
    void updateClients(){
        Clients clients = clientsRepository.findById(1L).get();
        clients.setLastname("SAVY update");
        clients.setFirstname("Steve update");
        clients.setEmail("s@gmailup.com");

        Clients saveClient = clientsRepository.save(clients);
        assertEquals("SAVY update",saveClient.getLastname());
        assertEquals("Steve update",saveClient.getFirstname());
        assertEquals("s@gmailup.com",saveClient.getEmail());
    }

    @Test
    void deleteClients(){
        clientsRepository.deleteById(1L);
        Optional<Clients> clients = clientsRepository.findById(1L);
        assertFalse(clients.isPresent());
    }
}