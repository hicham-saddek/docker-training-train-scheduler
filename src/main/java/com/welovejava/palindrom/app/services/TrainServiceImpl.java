package com.welovejava.palindrom.app.services;

import com.welovejava.palindrom.app.models.Train;
import com.welovejava.palindrom.app.repository.TrainRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class TrainServiceImpl implements TrainService {
    protected final TrainRepository repository;

    @Autowired
    TrainServiceImpl(TrainRepository repository) {
        this.repository = repository;
    }

    @Override
    public Train create(Train train) {
        return repository.save(train);
    }

    @Override
    public Train update(int id, Train train) {
        Optional<Train> optional = repository.findById(id);
        if (optional.isEmpty()) return null;
        Train origin = optional.get();
        if (train.getOrigin() != null)
            origin.setOrigin(train.getOrigin());
        if (train.getDestination() != null)
            origin.setDestination(train.getDestination());
        if (train.getStartingDateTime() != null && !train.getStartingDateTime().isBefore(LocalDateTime.now()))
            origin.setStartingDateTime(train.getEndingDateTime());
        if (train.getEndingDateTime() != null && !train.getEndingDateTime().isBefore(train.getStartingDateTime()) && !train.getEndingDateTime().isEqual(train.getStartingDateTime()) && !train.getEndingDateTime().isBefore(LocalDateTime.now()))
            origin.setEndingDateTime(train.getEndingDateTime());
        return repository.save(origin);
    }

    @Override
    public boolean delete(int id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public Train getOne(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Train> getAll() {
        return (List<Train>) repository.findAll();
    }
}
