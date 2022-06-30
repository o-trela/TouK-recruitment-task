package pl.touk.recruitmenttask.ticketbookingapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int rowNum;
    private int seatNum;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "seat"
    )
    @JsonManagedReference
    private List<Ticket> ticket;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_room")
    @JsonBackReference
    private Room room;
}
