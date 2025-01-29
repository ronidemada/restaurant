package com.example.restaurant.service;

import com.example.restaurant.dto.ClientsDTO;
import com.example.restaurant.entity.Clients;
import com.example.restaurant.entity.Commandes;
import com.example.restaurant.repository.IClientsRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class ClientsServiceTest {
    @Mock
    private IClientsRepository clientsRepository;

    @InjectMocks
    private ClientsService clientsService;

    @Test
    void createClients(){
        Clients client = new Clients(1L,"SAVY","Steve","s@gmail.com", new ArrayList<>());
        when(clientsRepository.save(client)).thenReturn(client);

        ClientsDTO clientDTO = ClientsMapperService.mapToClientsDTO(client);
        ClientsDTO c = clientsService.addClient(clientDTO);
        assertEquals(clientDTO, c);

    }

    @Test
    void updateClients(){
        Clients client = new Clients(1L,"SAVY Update","Steve Update","s@gmailup.com", new ArrayList<>());
        when(clientsRepository.save(client)).thenReturn(client);

        ClientsDTO clientDTO = ClientsMapperService.mapToClientsDTO(client);
        ClientsDTO c = clientsService.updateClient(1L,clientDTO);
        assertEquals(clientDTO, c);

    }

    @Test
    void deleteClients(){
        clientsService.deleteClient(1L);
        verify(clientsRepository).deleteById(1L);
    }


}