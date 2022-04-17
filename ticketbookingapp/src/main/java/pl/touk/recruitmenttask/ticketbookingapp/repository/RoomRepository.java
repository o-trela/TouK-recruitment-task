package pl.touk.recruitmenttask.ticketbookingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.touk.recruitmenttask.ticketbookingapp.model.Room;
import pl.touk.recruitmenttask.ticketbookingapp.model.Screening;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
    Room findByScreening(Screening screening);
}
