package com.example.eksamen2.controller;

import com.example.eksamen2.model.Boat;
import com.example.eksamen2.service.BoatService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/boats")
public class BoatController {
    private final BoatService boatService;

    public BoatController(BoatService boatService) {
        this.boatService = boatService;
    }

    @PostMapping
    public Boat create(@RequestBody Boat boat) {
        return boatService.create(boat);
    }

    @GetMapping
    public List<Boat> getAll() {
        return boatService.getAll();
    }

    @GetMapping("/{id}")
    public Boat getOne(@PathVariable Long id) {
        return boatService.getOne(id);
    }

    @PutMapping("/{id}")
    public Boat update(@PathVariable Long id, @RequestBody Boat boat) {
        return boatService.update(id, boat);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        boatService.delete(id);
    }
}