package pl.touk.recruitmenttask.ticketbookingapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Screening {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private List<Ticket> ticket;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Screening screening = (Screening) o;

        return new EqualsBuilder()
                .append(id, screening.id)
                .append(startTime, screening.startTime)
                .append(movie, screening.movie)
                .append(room, screening.room)
                .append(reservation, screening.reservation)
                .append(ticket, screening.ticket)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(startTime)
                .append(movie)
                .append(room)
                .append(reservation)
                .append(ticket)
                .toHashCode();
    }
}
