package pl.touk.recruitmenttask.ticketbookingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.touk.recruitmenttask.ticketbookingapp.model.Room;
import pl.touk.recruitmenttask.ticketbookingapp.model.Seat;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Integer> {
    List<Seat> findAllByIdIn(Set<Integer> ids);
    Optional<Seat> findById(int id);
    Optional<Seat> findByRoomAndRowNumAndSeatNum(Room room, int rowNum, int seatNum);
    List<Seat> findAllByRowNumAndRoom(int rowNum, Room room);
}
