package com.example.restaurant.repository;

import com.example.restaurant.entity.Clients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClientsRepository extends JpaRepository<Clients, Long> {
}
