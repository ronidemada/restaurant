package com.example.restaurant.repository;

import com.example.restaurant.entity.Commandes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICommandesRepository extends JpaRepository<Commandes, Long> {
}
