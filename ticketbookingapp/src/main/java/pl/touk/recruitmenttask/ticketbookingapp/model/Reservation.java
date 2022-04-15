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
public class Reservation {

    @Id
    private int id;
    private String name;
    private String surname;

    @OneToMany
    @JoinColumn(name = "id_reservation")
    private List<ReservedSeat> reservedSeat;

}
