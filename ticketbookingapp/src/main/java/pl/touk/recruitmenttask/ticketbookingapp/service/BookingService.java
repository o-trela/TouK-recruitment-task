package pl.touk.recruitmenttask.ticketbookingapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.touk.recruitmenttask.ticketbookingapp.model.*;
import pl.touk.recruitmenttask.ticketbookingapp.repository.ReservationRepository;
import pl.touk.recruitmenttask.ticketbookingapp.repository.ScreeningRepository;
import pl.touk.recruitmenttask.ticketbookingapp.repository.SeatRepository;
import pl.touk.recruitmenttask.ticketbookingapp.repository.TicketRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class BookingService {
    private final ScreeningRepository screeningRepository;
    private final SeatRepository seatRepository;
    private final ReservationRepository reservationRepository;
    private final TicketRepository ticketRepository;

    public Reservation makeReservation(int screeningId, String name, String surname, Map<Integer, TicketType> seats) {
        Screening screening = screeningRepository.findById(screeningId).orElseThrow();
        Integer[] seatIds = seats.keySet().toArray(new Integer[0]);
        List<Seat> seatList = seatRepository.findAllByIdIn(seatIds);

        Reservation reservation = new Reservation();
        List<Ticket> tickets = new ArrayList<>();

        for (Seat seat : seatList) {
            Ticket ticket = new Ticket();
            TicketType ticketType = seats.get(seat.getId());

            ticket.setTicketType(ticketType);
            ticket.setReservation(reservation);
            ticket.setScreening(screening);
            ticket.setSeat(seat);

            tickets.add(ticket);
        }

        reservation.setScreening(screening);
        reservation.setName(name);
        reservation.setSurname(surname);
        reservation.setTicket(tickets);

        reservationRepository.save(reservation);
        ticketRepository.saveAll(tickets);

        return reservation;
    }
}
