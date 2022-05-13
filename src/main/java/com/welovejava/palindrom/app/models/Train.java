package com.welovejava.palindrom.app.models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "trains")
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Getter
@Setter
public class Train {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter
    @Setter
    private String origin;

    @Getter
    @Setter
    private String destination;

    @Getter
    @Setter
    private LocalDateTime startingDateTime;

    @Getter
    @Setter
    private LocalDateTime endingDateTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Train train = (Train) o;
        return id != null && Objects.equals(id, train.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
