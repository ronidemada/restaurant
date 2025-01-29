package com.example.restaurant.repository;

import com.example.restaurant.entity.Commandes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICommandesRepository extends JpaRepository<Commandes, Long> {
    List<Commandes> getCommandeByClientsId(Long idClient);

    boolean existsByPlatsList_Id(Long id);
}
