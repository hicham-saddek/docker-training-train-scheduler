package com.welovejava.palindrom.app.payloads;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class TrainDto implements Serializable {
    private final String origin;
    private final String destination;
    private final LocalDateTime startingDateTime;
    private final LocalDateTime endingDateTime;

    public boolean isNotValid() {
        if (this.getOrigin() == null) return true;
        if (this.getDestination() == null) return true;
        if (this.getEndingDateTime() == null) return true;
        if (this.getStartingDateTime() == null) return true;
        return startingDateTime.isAfter(endingDateTime) || startingDateTime.equals(endingDateTime);
    }
}
