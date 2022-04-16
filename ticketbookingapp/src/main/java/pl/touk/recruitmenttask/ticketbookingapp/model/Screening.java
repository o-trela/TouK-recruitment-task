package pl.touk.recruitmenttask.ticketbookingapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Screening {

    @Id
    private int id;
    @Column(name = "start_time")
    private LocalDateTime startTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_movie")
    @JsonBackReference
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_room")
    @JsonBackReference
    private Room room;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "screening"
    )
    @JsonManagedReference
    private List<Reservation> reservation;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "screening"
    )
    @JsonManagedReference
    private List<ReservedSeat> reservedSeat;
}
