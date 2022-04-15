package pl.touk.recruitmenttask.ticketbookingapp.model;

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

    @OneToMany
    @JoinColumn(name = "id_screening")
    private List<Reservation> reservation;

    @OneToMany
    @JoinColumn(name = "id_screening")
    private List<ReservedSeat> reservedSeat;
}
