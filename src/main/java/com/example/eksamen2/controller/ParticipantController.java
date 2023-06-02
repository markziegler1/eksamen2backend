package com.example.eksamen2.controller;

import com.example.eksamen2.model.Participant;
import com.example.eksamen2.service.ParticipantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/participants")
public class ParticipantController {
    private final ParticipantService participantService;

    public ParticipantController(ParticipantService participantService) {
        this.participantService = participantService;
    }

    @PostMapping
    public Participant create(@RequestBody Participant participant) {
        return participantService.save(participant);
    }


    @GetMapping
    public List<Participant> getAll() {
        return participantService.getAll();
    }

    @GetMapping("/{id}")
    public Participant getOne(@PathVariable Long id) {
        return participantService.getOne(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        participantService.delete(id);
    }
}