package com.example.restaurant.controller;

import com.example.restaurant.dto.ClientDto;
import com.example.restaurant.dto.ClientsDTO;
import com.example.restaurant.entity.Clients;
import com.example.restaurant.exception.ClientNotFoundException;
import com.example.restaurant.service.ClientMapperService;
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
    private final ClientMapperService clientMapperService;

    public ClientsController(ClientsService clientsService, ClientMapperService clientMapperService) {
        this.clientsService = clientsService;
        this.clientMapperService = clientMapperService;
    }

    @PostMapping
    public ResponseEntity<ClientsDTO> createClient(@RequestBody @Valid ClientsDTO client/*, BindingResult bindingResult*/){

        ClientsDTO ClientCreatedDTO;

        /*if(bindingResult.hasErrors()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
        }*/

        ClientCreatedDTO = clientsService.addClient(client);
        //return ResponseEntity.ok("created user");
        return new ResponseEntity<>(ClientCreatedDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientsDTO> updateClient(@PathVariable Long id, @Valid @RequestBody ClientsDTO client/*, BindingResult bindingResult*/){

        ClientsDTO ClientUpdatedDTO;

        /*if(bindingResult.hasErrors()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
        }*/
        ClientUpdatedDTO = clientsService.updateClient(id, client);
        //return ResponseEntity.ok("updated client");
        return new ResponseEntity<>(ClientUpdatedDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable Long id){
        clientsService.deleteClient(id);
        return ResponseEntity.ok("delete client");
    }

    @GetMapping("/dto/{id}")
    public ClientDto getClient(@PathVariable Long id){
        return clientMapperService.getUserById(id);
    }
}
