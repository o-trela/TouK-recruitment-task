package pl.touk.recruitmenttask.ticketbookingapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.touk.recruitmenttask.ticketbookingapp.model.Reservation;
import pl.touk.recruitmenttask.ticketbookingapp.model.Ticket;
import pl.touk.recruitmenttask.ticketbookingapp.model.Screening;
import pl.touk.recruitmenttask.ticketbookingapp.model.Seat;
import pl.touk.recruitmenttask.ticketbookingapp.repository.TicketRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SeatService {
    private final TicketRepository ticketRepository;

    public List<Seat> getReservedSeatsByScreening(Screening screening) {
        List<Seat> reservedSeats = new ArrayList<>();

        List<Ticket> tickets = ticketRepository.findByScreening(screening);
        for (Ticket rs : tickets) {
            Seat seat = rs.getSeat();
            reservedSeats.add(seat);
        }

        return reservedSeats;
    }

    public List<Seat> getAvailableSeatsByScreening(Screening screening) {
        return screening.getRoom().getSeat();
    }

    public boolean validateSeats(Screening screening, List<Seat> pickedSeats) {
        List<Seat> roomSeats = screening.getRoom().getSeat();

        for (Seat seat : pickedSeats) {
            if (roomSeats.contains(seat)) continue;
            return false;
        }

        return true;
    }

}
