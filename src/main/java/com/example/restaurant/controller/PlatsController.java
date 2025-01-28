package com.example.restaurant.controller;

import com.example.restaurant.entity.Plats;
import com.example.restaurant.service.PlatsService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/plats")
public class PlatsController {

    private final PlatsService platsService;

    public PlatsController(PlatsService platsService) {
        this.platsService = platsService;
    }

    @PostMapping
    public ResponseEntity<String> createPlat(@Valid @RequestBody Plats plats, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
        }

        platsService.addPlats(plats);
        return ResponseEntity.ok("created plat");
    }

    @GetMapping
    public ResponseEntity<List<Plats>> getAllPlats() {
        return ResponseEntity.ok(platsService.getAllPlats());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable Long id){
        platsService.deletePlats(id);
        return ResponseEntity.ok("delete plat");
    }
}
