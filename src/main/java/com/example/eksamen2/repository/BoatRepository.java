package com.example.eksamen2.repository;

import com.example.eksamen2.model.Boat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BoatRepository extends JpaRepository<Boat, Long> {}

