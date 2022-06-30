package pl.touk.recruitmenttask.ticketbookingapp.model;

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
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
