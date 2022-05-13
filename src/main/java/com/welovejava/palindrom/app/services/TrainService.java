package com.welovejava.palindrom.app.services;

import com.welovejava.palindrom.app.models.Train;

import java.util.List;

public interface TrainService {
    Train create(Train train);

    Train update(int id, Train train);

    boolean delete(int id);

    Train getOne(int id);

    List<Train> getAll();
}
