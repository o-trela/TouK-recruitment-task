package pl.touk.recruitmenttask.ticketbookingapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Seat {

    @Id
    private int id;
    @Column(name = "row_num")
    private int rowNum;
    @Column(name = "no_seats")
    private int seatNum;

    @OneToMany
    @JoinColumn(name = "id_seat")
    private List<ReservedSeat> reservedSeat;
}
