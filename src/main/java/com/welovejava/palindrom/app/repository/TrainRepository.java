package com.welovejava.palindrom.app.repository;

import com.welovejava.palindrom.app.models.Train;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Repository
public interface TrainRepository extends CrudRepository<Train, Integer> {

    @Query("DELETE FROM Train train " +
            "WHERE train.origin = :origin" +
            " AND train.destination = :destination" +
            " AND train.startingDateTime = :start" +
            " AND train.endingDateTime = :end")
    @Modifying
    @Transactional
    boolean deleteByInfo(String origin, String destination, LocalDateTime start, LocalDateTime end);
}
