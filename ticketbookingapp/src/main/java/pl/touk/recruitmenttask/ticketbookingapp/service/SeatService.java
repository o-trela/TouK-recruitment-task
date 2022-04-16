package pl.touk.recruitmenttask.ticketbookingapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.touk.recruitmenttask.ticketbookingapp.model.ReservedSeat;
import pl.touk.recruitmenttask.ticketbookingapp.model.Screening;
import pl.touk.recruitmenttask.ticketbookingapp.model.Seat;
import pl.touk.recruitmenttask.ticketbookingapp.repository.ReservedSeatRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SeatService {
    private final ReservedSeatRepository reservedSeatRepository;

    public List<Seat> getReservedSeatsByScreening(Screening screening) {
        List<Seat> reservedSeats = new ArrayList<>();
        int screeningId = screening.getId();

        List<ReservedSeat> tickets = reservedSeatRepository.findByScreeningId(screeningId);
        for (ReservedSeat rs : tickets) {
            Seat seat = rs.getSeat();
            reservedSeats.add(seat);
        }

        return reservedSeats;
    }

    public List<Seat> getAvailableSeatsByScreening(Screening screening) {
        return screening.getRoom().getSeat();
    }
}
