package com.example.restaurant.repository;

import com.example.restaurant.entity.Commandes;
import com.example.restaurant.entity.Plats;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IPlatsRepository extends JpaRepository<Plats, Long> {

}
