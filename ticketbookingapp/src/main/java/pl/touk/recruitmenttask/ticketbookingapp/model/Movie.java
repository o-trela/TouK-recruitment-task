package pl.touk.recruitmenttask.ticketbookingapp.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private int durationTime;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "movie"
    )
    @JsonManagedReference
    private List<Screening> screening;
}
