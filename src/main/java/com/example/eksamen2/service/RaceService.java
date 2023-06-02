package com.example.eksamen2.service;

import com.example.eksamen2.model.Race;
import com.example.eksamen2.repository.BoatRepository;
import com.example.eksamen2.repository.RaceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class RaceService {
    private final RaceRepository raceRepository;
    private final BoatRepository boatRepository;

    public RaceService(RaceRepository raceRepository, BoatRepository boatRepository) {
        this.raceRepository = raceRepository;
        this.boatRepository = boatRepository;
    }

    public Race save(Race race) {
        return raceRepository.save(race);
    }

    public List<Race> getAll() {
        return raceRepository.findAll();
    }

    public Optional<Race> getOne(Long id) {
        return raceRepository.findById(id);
    }

    public void delete(Long id) {
        raceRepository.deleteById(id);
    }

    public void setupRaces() {
        LocalDate startDate = LocalDate.of(2023, 5, 1);
        int raceCount = 22;

        List<Race> races = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < raceCount; i++) {
            LocalDate date = startDate.plusDays(i);
            int boatType = random.nextInt(3) + 1; // Generate a random boat type (1, 2, or 3)
            int points = random.nextInt(10) + 1; // Generate a random points value (1 to 10)

            Race race = new Race(date, boatType, points);
            races.add(race);
        }

        raceRepository.saveAll(races);
    }
}