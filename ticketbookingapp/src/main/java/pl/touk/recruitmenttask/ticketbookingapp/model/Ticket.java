package pl.touk.recruitmenttask.ticketbookingapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import pl.touk.recruitmenttask.ticketbookingapp.service.converter.TicketTypeAttributeConverter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ticket_type")
    @Convert(converter = TicketTypeAttributeConverter.class)
    private TicketType ticketType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_seat")
    @JsonBackReference
    private Seat seat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_reservation")
    @JsonBackReference
    private Reservation reservation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_screening")
    @JsonBackReference
    private Screening screening;

}
