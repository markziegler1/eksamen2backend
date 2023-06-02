package com.example.eksamen2.controller;

import com.example.eksamen2.model.Race;
import com.example.eksamen2.service.RaceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/races")
public class RaceController {
    private final RaceService raceService;

    public RaceController(RaceService raceService) {
        this.raceService = raceService;
    }

    @PostMapping
    public Race create(@RequestBody Race race) {
        return raceService.save(race);
    }

    @GetMapping
    public List<Race> getAll() {
        return raceService.getAll();
    }

    @GetMapping("/{id}")
    public Race getOne(@PathVariable Long id) {
        return raceService.getOne(id)
                .orElseThrow(() -> new RuntimeException("Race not found"));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        raceService.delete(id);
    }
}