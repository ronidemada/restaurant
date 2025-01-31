package com.example.restaurant.controller;

import com.example.restaurant.dto.ClientsDTO;
import com.example.restaurant.entity.Clients;
import com.example.restaurant.service.ClientsMapperService;
import com.example.restaurant.service.ClientsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ClientsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private ClientsService clientsService;

    @InjectMocks
    private ClientsController clientsController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(clientsController).build();
    }

    @Test
    void createClients() throws Exception{
        String json = """
                {
                "lastname" : "SAVY",
                "firstname" : "Steve",
                "email" : "s@gmail.com"
                }
                """;
        Clients clients = new Clients(1L,"SAVY","Steve","s@gmail.com",null);
        ClientsDTO clientsDTO = ClientsMapperService.mapToClientsDTO(clients);
        when(clientsService.addClient(clientsDTO)).thenReturn(clientsDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/clients").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    void updateClients() throws Exception{
        String json = """
                {
                "lastname" : "SAVY",
                "firstname" : "Steve",
                "email" : "s@gmail.com"
                }
                """;
        Clients clients = new Clients(1L,"SAVY","Steve","s@gmail.com",null);
        ClientsDTO clientsDTO = ClientsMapperService.mapToClientsDTO(clients);

        Clients clientsUp = new Clients(1L,"SAVY Update","Steve Update","s@gmailup.com",null);
        ClientsDTO clientsDTOUP = ClientsMapperService.mapToClientsDTO(clientsUp);

        when(clientsService.updateClient(1L,clientsDTO)).thenReturn(clientsDTOUP);

        mockMvc.perform(MockMvcRequestBuilders.put("/clients/1").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void deleteClients() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.delete("/clients/delete/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
