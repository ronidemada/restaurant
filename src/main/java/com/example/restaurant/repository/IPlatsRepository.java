package com.example.restaurant.repository;

import com.example.restaurant.entity.Plats;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPlatsRepository extends JpaRepository<Plats, Long> {
}
