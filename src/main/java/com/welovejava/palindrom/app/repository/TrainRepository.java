package com.welovejava.palindrom.app.repository;

import com.welovejava.palindrom.app.models.Train;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainRepository extends CrudRepository<Train, Integer> {

}
