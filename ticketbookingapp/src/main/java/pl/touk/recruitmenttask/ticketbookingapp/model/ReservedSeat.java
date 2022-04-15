package pl.touk.recruitmenttask.ticketbookingapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class ReservedSeat {

    @Id
    private int id;
}
