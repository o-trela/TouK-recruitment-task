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
public class Reservation {

    @Id
    private int id;
    private String name;
    private String surname;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "reservation"
    )
    @JsonManagedReference
    private List<ReservedSeat> reservedSeat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_screening")
    @JsonBackReference
    private Screening screening;

}
