package com.example.restaurant.service;

import com.example.restaurant.dto.ClientsDTO;
import com.example.restaurant.dto.PlatsDTO;
import com.example.restaurant.entity.Clients;
import com.example.restaurant.entity.Plats;
import com.example.restaurant.exception.ClientNotFoundException;
import com.example.restaurant.exception.PlatNotFoundException;
import com.example.restaurant.repository.ICommandesRepository;
import com.example.restaurant.repository.IPlatsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlatsService {

    private final IPlatsRepository platsRepository;

    private final ICommandesRepository commandesRepository;

    public PlatsService(IPlatsRepository platsRepository, ICommandesRepository commandesRepository) {
        this.platsRepository = platsRepository;
        this.commandesRepository = commandesRepository;
    }

    public PlatsDTO addPlats(PlatsDTO platsDTO) {

        // Convert PlatDTO into Plat JPA Entity
        Plats plats = PlatsMapperService.mapToPlats(platsDTO);

        Plats savedPlats = platsRepository.save(plats);

        // Convert Plat JPA entity to PlatDTO
        PlatsDTO savedDTO = PlatsMapperService.mapToPlatsDTO(savedPlats);

        return savedDTO;
    }

    public List<PlatsDTO> getAllPlats() {
        PlatsDTO platDTO;
        List<PlatsDTO> platsDTOS = new ArrayList<>();
        List<Plats> platsList = platsRepository.findAll();
        for (Plats plat : platsList){
            platDTO = PlatsMapperService.mapToPlatsDTO(plat);
            platsDTOS.add(platDTO);
        }
        return platsDTOS;
    }

    public void deletePlats(Long id) {

        Optional<Plats> plats = platsRepository.findById(id);

        if(commandesRepository.existsByPlatsList_Id(id)){
            throw new PlatNotFoundException("Plat avec ID " + id + " est déjà inclus dans une commande");
        }

        if(plats.isEmpty()){
            throw new PlatNotFoundException("Client avec ID " + id + " non trouvé");
        }else{
            plats.ifPresent(platsRepository::delete);
        }
    }
}
