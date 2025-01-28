package com.example.restaurant.service;

import com.example.restaurant.entity.Clients;
import com.example.restaurant.entity.Plats;
import com.example.restaurant.exception.ClientNotFoundException;
import com.example.restaurant.exception.PlatNotFoundException;
import com.example.restaurant.repository.IPlatsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlatsService {

    private final IPlatsRepository platsRepository;

    public PlatsService(IPlatsRepository platsRepository) {
        this.platsRepository = platsRepository;
    }

    public Plats addPlats(Plats plats) {
        return platsRepository.save(plats);
    }

    public List<Plats> getAllPlats() {
        return platsRepository.findAll();
    }

    public void deletePlats(Long id) {

        Optional<Plats> plats = platsRepository.findById(id);

        if(plats.isEmpty()){
            throw new PlatNotFoundException("Client avec ID " + id + " non trouvé");
        }else{
            plats.ifPresent(platsRepository::delete);
        }
    }
}
