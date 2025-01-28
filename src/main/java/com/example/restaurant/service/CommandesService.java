package com.example.restaurant.service;

import com.example.restaurant.entity.Clients;
import com.example.restaurant.entity.Commandes;
import com.example.restaurant.entity.Plats;
import com.example.restaurant.exception.ClientNotFoundException;
import com.example.restaurant.repository.IClientsRepository;
import com.example.restaurant.repository.ICommandesRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CommandesService {

    private final ICommandesRepository commandesRepository;
    private final IClientsRepository clientsRepository;

    public CommandesService(ICommandesRepository commandesRepository, IClientsRepository clientsRepository) {
        this.commandesRepository = commandesRepository;
        this.clientsRepository = clientsRepository;
    }

    public void addCommande(Long idClient, List<Plats> platsList) {

        Clients client = clientsRepository.findById(idClient)
                .orElseThrow(() -> new ClientNotFoundException("Le Client avec ID " + idClient + " non trouvé pour la commande"));

        Commandes commande = new Commandes();
        commande.setClients(client);
        commande.setPlatsList(platsList);
        commande.setDate(LocalDate.now());
        commandesRepository.save(commande);

    }
}
