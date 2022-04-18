package pl.touk.recruitmenttask.ticketbookingapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.touk.recruitmenttask.ticketbookingapp.model.*;
import pl.touk.recruitmenttask.ticketbookingapp.repository.SeatRepository;
import pl.touk.recruitmenttask.ticketbookingapp.repository.TicketRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SeatService {
    private final TicketRepository ticketRepository;
    private final SeatRepository seatRepository;

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

    public boolean checkAround(Screening screening, List<Seat> seats) {
        Room room = screening.getRoom();
        List<Seat> roomSeats = room.getSeat();

        // consider reservation seats as already taken
        List<Seat> reservedSeats = new ArrayList<>();
        screening.getTicket().forEach(ticket -> reservedSeats.add(ticket.getSeat()));
        reservedSeats.addAll(seats);

        for (Seat seat : seats) {
            int rowNum = seat.getRowNum();
            int seatNum = seat.getSeatNum();
            int rowSize = getRowSize(roomSeats, rowNum);

            if (seatNum < 3 || seatNum > rowSize - 2) {
                int diff = seatNum < 3 ? 1 : -1;
                int newSeatNum = seatNum + diff;

                Seat seat1 = extractSeat(roomSeats, rowNum, newSeatNum);
                if (!reservedSeats.contains(seat1)) {
                    Seat seat3 = extractSeat(roomSeats, rowNum, newSeatNum + diff);
                    if (reservedSeats.contains(seat3))
                        return false;
                }
                continue;
            }

            int leftNum = seatNum - 1;
            int rightNum = seatNum + 1;

            Seat seat1 = extractSeat(roomSeats, rowNum, leftNum);
            if (!reservedSeats.contains(seat1)) {
                Seat seat2 = extractSeat(roomSeats, rowNum, leftNum - 1);
                if (reservedSeats.contains(seat2))
                    return false;
            }
            Seat seat2 = extractSeat(roomSeats, rowNum, rightNum);
            if (!reservedSeats.contains(seat2)) {
                Seat seat3 = extractSeat(roomSeats, rowNum, rightNum + 1);
                if (reservedSeats.contains(seat3))
                    return false;
            }
        }
        return true;
    }

    private Seat extractSeat(List<Seat> seats, int rowNum, int seatNum) {
        return seats.stream()
                .filter(seat2 -> seat2.getRowNum() == rowNum && seat2.getSeatNum() == seatNum)
                .findAny()
                .orElseThrow();
    }

    private int getRowSize(List<Seat> seats, int rowNum) {
        return (int) seats.stream()
                .filter(targetSeat -> targetSeat.getRowNum() == rowNum)
                .count();
    }

}
