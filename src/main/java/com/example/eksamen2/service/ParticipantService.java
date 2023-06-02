package com.example.eksamen2.service;

import com.example.eksamen2.model.Participant;
import com.example.eksamen2.repository.ParticipantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantService {
    private final ParticipantRepository participantRepository;

    public ParticipantService(ParticipantRepository participantRepository) {
        this.participantRepository = participantRepository;
    }

    public Participant save(Participant participant) {
        return participantRepository.save(participant);
    }

    public List<Participant> getAll() {
        return participantRepository.findAll();
    }

    public Participant getOne(Long id) {
        return participantRepository.findById(id).orElseThrow(() -> new RuntimeException("Participant not found"));
    }

    public void delete(Long id) {
        participantRepository.deleteById(id);
    }
}
