package pl.touk.recruitmenttask.ticketbookingapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.touk.recruitmenttask.ticketbookingapp.exception.AlreadyTakenException;
import pl.touk.recruitmenttask.ticketbookingapp.exception.ResourceNotFoundException;
import pl.touk.recruitmenttask.ticketbookingapp.exception.TooLateException;
import pl.touk.recruitmenttask.ticketbookingapp.exception.BadRequestException;
import pl.touk.recruitmenttask.ticketbookingapp.model.*;
import pl.touk.recruitmenttask.ticketbookingapp.repository.ReservationRepository;
import pl.touk.recruitmenttask.ticketbookingapp.repository.TicketRepository;
import pl.touk.recruitmenttask.ticketbookingapp.service.properties.PropertiesConfig;

import java.time.LocalDateTime;
import java.util.*;

@Service
@RequiredArgsConstructor
public class BookingService {
    private final ReservationRepository reservationRepository;
    private final TicketRepository ticketRepository;
    private final SeatService seatService;
    private final SearchService searchService;

    public Reservation makeReservation(int screeningId, String name, String surname, Map<Integer, TicketType> seatsType, LocalDateTime now) {
        Reservation reservation = new Reservation();

        Screening screening = searchService.getSingleScreening(screeningId);

        LocalDateTime startTime = screening.getStartTime();
        if (startTime
                .minusMinutes(PropertiesConfig.expirationTimeMin)
                .isBefore(now)) {
            throw new TooLateException("It Is Too Late To Make A Reservation");
        }

        reservation.setScreening(screening);
        reservation.setName(name);
        reservation.setSurname(surname);

        List<Ticket> tickets = prepareTickets(reservation, seatsType);
        reservation.setTicket(tickets);

        reservationRepository.save(reservation);
        ticketRepository.saveAll(tickets);

        return reservation;
    }

    private List<Ticket> prepareTickets(Reservation reservation, Map<Integer, TicketType> seatsType) {
        Screening screening = reservation.getScreening();
        Set<Integer> seatIds = seatsType.keySet();
        List<Seat> seatList = seatService.getSeatsByIds(seatIds);

        if (seatList.isEmpty() || !seatService.validateSeats(screening, seatList))
            throw new BadRequestException("Seat Not Found");

        if (!seatService.ensureNotReserved(screening, seatList))
            throw new AlreadyTakenException("Seat Already Taken");

        if (!seatService.ensureNoGapOccurs(screening, seatList))
            throw new BadRequestException("Not Allowed To Leave One Seat Between");

        List<Ticket> tickets = new ArrayList<>();
        seatList.forEach(seat -> {
                    Ticket ticket = new Ticket();
                    TicketType ticketType = seatsType.get(seat.getId());

                    ticket.setTicketType(ticketType);
                    ticket.setReservation(reservation);
                    ticket.setScreening(screening);
                    ticket.setSeat(seat);

                    tickets.add(ticket);
                });

        return tickets;
    }
}
