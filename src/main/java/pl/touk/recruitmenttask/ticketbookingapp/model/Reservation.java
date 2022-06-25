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
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String surname;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "reservation"
    )
    @JsonManagedReference
    private List<Ticket> ticket;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_screening")
    @JsonBackReference
    private Screening screening;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Reservation that = (Reservation) o;

        return new EqualsBuilder()
                .append(id, that.id)
                .append(name, that.name)
                .append(surname, that.surname)
                .append(ticket, that.ticket)
                .append(screening, that.screening)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(name)
                .append(surname)
                .append(ticket)
                .append(screening)
                .toHashCode();
    }
}
