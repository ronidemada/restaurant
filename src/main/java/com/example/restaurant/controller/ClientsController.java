package com.example.restaurant.controller;

import com.example.restaurant.dto.ClientsDto;
import com.example.restaurant.entity.Clients;
import com.example.restaurant.service.ClientsMapperService;
import com.example.restaurant.service.ClientsService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/clients")
public class ClientsController {

    private final ClientsService clientsService;
    private final ClientsMapperService clientsMapperService;

    public ClientsController(ClientsService clientsService, ClientsMapperService clientsMapperService) {
        this.clientsService = clientsService;
        this.clientsMapperService = clientsMapperService;
    }

    @PostMapping
    public ResponseEntity<String> createClient(@Valid @RequestBody Clients client, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
        }

        clientsService.addClient(client);
        return ResponseEntity.ok("created user");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateClient(@PathVariable Long id, @Valid @RequestBody Clients client, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
        }
        clientsService.updateClient(id, client);
        return ResponseEntity.ok("updated client");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable Long id){
        clientsService.deleteClient(id);
        return ResponseEntity.ok("delete client");
    }

    @GetMapping("/dto/{id}")
    public ClientsDto getClient(@PathVariable Long id){
        return clientsMapperService.getUserById(id);
    }
}
