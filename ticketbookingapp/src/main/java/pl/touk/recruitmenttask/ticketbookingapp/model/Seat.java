package pl.touk.recruitmenttask.ticketbookingapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    private int rowNum;
    private int seatNum;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "seat"
    )
    @JsonManagedReference
    private List<ReservedSeat> reservedSeat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_room")
    @JsonBackReference
    private Room room;
}
