package com.example.restaurant.controller;

import com.example.restaurant.entity.Clients;
import com.example.restaurant.entity.Commandes;
import com.example.restaurant.entity.Plats;
import com.example.restaurant.service.CommandesService;
import com.example.restaurant.service.PlatsService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/commandes")
public class CommandesController {

    private final CommandesService commandesService;

    public CommandesController(CommandesService commandesService) {
        this.commandesService = commandesService;
    }

    @PostMapping("/client/{id_user}")
    public ResponseEntity<String> createCmd(@PathVariable Long id_user, @RequestBody List<Plats> platList){
        commandesService.addCommande(id_user,platList);
        return ResponseEntity.ok("created commande");
    }

    @GetMapping("/client/{id_user}")
    public List<Commandes> createCmd(@PathVariable Long id_user){
        return commandesService.getAllCommande(id_user);
    }
}
