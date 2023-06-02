package com.example.eksamen2.config;

import com.example.eksamen2.model.Boat;
import com.example.eksamen2.model.Race;
import com.example.eksamen2.repository.BoatRepository;
import com.example.eksamen2.repository.RaceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class InitData implements CommandLineRunner {

    private final BoatRepository boatRepository;
    private final RaceRepository raceRepository;

    public InitData(BoatRepository boatRepository, RaceRepository raceRepository) {
        this.boatRepository = boatRepository;
        this.raceRepository = raceRepository;
    }

    @Override
    public void run(String... args) {
        // Check if boats already exist
        if (boatRepository.count() == 0) {
            // Create boats with different types
            Boat boat1 = new Boat();
            boat1.setName("Boat 1");
            boat1.setType("1");
            boatRepository.save(boat1);

            Boat boat2 = new Boat();
            boat2.setName("Boat 2");
            boat2.setType("2");
            boatRepository.save(boat2);

            Boat boat3 = new Boat();
            boat3.setName("Boat 3");
            boat3.setType("3");
            boatRepository.save(boat3);
        }

        // Check if races already exist
        if (raceRepository.count() == 0) {
            // Generate races
            LocalDate startDate = LocalDate.of(2023, 5, 1);
            LocalDate endDate = LocalDate.of(2023, 10, 1);

            // Calculate the number of Wednesdays between the start and end dates
            int wednesdayCount = 0;
            LocalDate date = startDate;
            while (date.isBefore(endDate) || date.isEqual(endDate)) {
                if (date.getDayOfWeek() == DayOfWeek.WEDNESDAY) {
                    wednesdayCount++;
                }
                date = date.plusDays(1);
            }

            int raceCount = wednesdayCount;

            List<Race> races = new ArrayList<>();
            Random random = new Random();

            for (int i = 0; i < raceCount; i++) {
                LocalDate raceDate = startDate.plusDays(i * 7); // Assign a race date based on Wednesdays
                int boatType = random.nextInt(3) + 1; // Generate random boat type between 1 and 3
                int points = i + 1; // Assign points incrementally

                Race race = new Race(raceDate, boatType, points);
                races.add(race);
            }

            raceRepository.saveAll(races);
        }

        // Update points based on race status
        List<Race> allRaces = raceRepository.findAll();
        for (Race race : allRaces) {
            String status = race.getStatus(); // Get the status

            // Check for null status
            if (status != null) {
                switch (status) {
                    case "not completed", "Too early started" -> race.setPoints(race.getPoints() + 1);
                    case "Not started" -> race.setPoints(race.getPoints() + 2);
                    default -> {
                        // Handle other race statuses if needed
                    }
                }

            }


        }
        raceRepository.saveAll(allRaces);
    }
}