package pl.touk.recruitmenttask.ticketbookingapp.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Room {

    @Id
    private int id;
    private int no_seats;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "room"
    )
    @JsonManagedReference
    private List<Screening> screening;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "room"
    )
    @JsonManagedReference
    private List<Seat> seat;
}
