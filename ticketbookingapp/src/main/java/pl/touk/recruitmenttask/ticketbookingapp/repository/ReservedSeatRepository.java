package pl.touk.recruitmenttask.ticketbookingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.touk.recruitmenttask.ticketbookingapp.model.ReservedSeat;

import java.util.List;

@Repository
public interface ReservedSeatRepository extends JpaRepository<ReservedSeat, Integer> {

    @Query("SELECT rs FROM ReservedSeat rs WHERE rs.screening.id = ?1")
    List<ReservedSeat> findByScreeningId(int id);
}
