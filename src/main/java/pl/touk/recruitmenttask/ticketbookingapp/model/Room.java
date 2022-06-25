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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        return new EqualsBuilder()
                .append(id, room.id)
                .append(no_seats, room.no_seats)
                .append(screening, room.screening)
                .append(seat, room.seat)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(no_seats)
                .append(screening)
                .append(seat)
                .toHashCode();
    }
}
