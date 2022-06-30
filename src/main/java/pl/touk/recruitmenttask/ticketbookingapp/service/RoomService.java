package pl.touk.recruitmenttask.ticketbookingapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.touk.recruitmenttask.ticketbookingapp.exception.ResourceNotFoundException;
import pl.touk.recruitmenttask.ticketbookingapp.model.Room;
import pl.touk.recruitmenttask.ticketbookingapp.model.Screening;
import pl.touk.recruitmenttask.ticketbookingapp.repository.RoomRepository;

@Service
@RequiredArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository;

    public Room getSingleRoom(int id) {
        return roomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Room Not Found"));
    }

    public Room getSingleRoom(Screening screening) {
        return roomRepository.findByScreening(screening)
                .orElseThrow(() -> new ResourceNotFoundException("Room Not Found"));
    }
}
