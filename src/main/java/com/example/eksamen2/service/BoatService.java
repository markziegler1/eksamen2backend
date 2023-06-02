package com.example.eksamen2.service;

import com.example.eksamen2.model.Boat;
import com.example.eksamen2.repository.BoatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoatService {
    private final BoatRepository boatRepository;

    public BoatService(BoatRepository boatRepository) {
        this.boatRepository = boatRepository;
    }

    public Boat save(Boat boat) {
        return boatRepository.save(boat);
    }

    public List<Boat> getAll() {
        return boatRepository.findAll();
    }

    public Boat getOne(Long id) {
        return boatRepository.findById(id).orElseThrow(() -> new RuntimeException("Boat not found"));
    }

    public void delete(Long id) {
        boatRepository.deleteById(id);
    }

    public Boat update(Long id, Boat updatedBoat) {
        Boat boat = boatRepository.findById(id).orElseThrow(() -> new RuntimeException("Boat not found"));
        boat.setName(updatedBoat.getName());
        boat.setType(updatedBoat.getType());
        return boatRepository.save(boat);
    }

    public Boat create(Boat boat) {
        return boatRepository.save(boat);
    }

}