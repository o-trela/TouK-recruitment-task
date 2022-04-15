package pl.touk.recruitmenttask.ticketbookingapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
public class Room {

    @Id
    private int id;
    private int no_seats;

    @OneToMany
    @JoinColumn(name = "id_room")
    private List<Screening> screening;

    @OneToMany
    @JoinColumn(name = "id_room")
    private List<Seat> seat;
}
