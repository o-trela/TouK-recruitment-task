package pl.touk.recruitmenttask.ticketbookingapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Movie {

    @Id
    private int id;
    private String title;
    @Column(name = "duration_time_min")
    private int durationTime;

    @OneToMany
    @JoinColumn(name = "id_movie")
    private List<Screening> screening;
}
