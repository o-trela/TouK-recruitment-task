package pl.touk.recruitmenttask.ticketbookingapp.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.touk.recruitmenttask.ticketbookingapp.model.*;
import pl.touk.recruitmenttask.ticketbookingapp.repository.SeatRepository;
import pl.touk.recruitmenttask.ticketbookingapp.repository.TicketRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class SeatService {
    private final TicketRepository ticketRepository;
    private final SeatRepository seatRepository;

    public List<Seat> getSeatsByIds(Set<Integer> ids) {
        Integer[] seatIds = ids.toArray(new Integer[0]);
        return seatRepository.findAllByIdIn(seatIds);
    }

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

    public boolean ensureNotReserved(Screening screening, List<Seat> pickedSeats) {
        List<Seat> reservedSeats = new ArrayList<>();
        screening.getTicket().forEach(ticket -> reservedSeats.add(ticket.getSeat()));

        for (Seat seat : pickedSeats) {
            if (!reservedSeats.contains(seat)) continue;
            return false;
        }

        return true;
    }

    public boolean ensureNoGapOccurs(Screening screening, List<Seat> pickedSeats) {
        Room room = screening.getRoom();
        List<Seat> roomSeats = room.getSeat();

        // consider reservation seats as already taken
        List<Seat> reservedSeats = new ArrayList<>();
        screening.getTicket().forEach(ticket -> reservedSeats.add(ticket.getSeat()));
        reservedSeats.addAll(pickedSeats);

        for (Seat seat : pickedSeats) {
            int rowNum = seat.getRowNum();
            int seatNum = seat.getSeatNum();
            int rowSize = getRowSize(roomSeats, rowNum);


            // in case row size is <= 3 (don't need to check anything for < 3)
            if (rowSize <= 3) {
                 if (rowSize == 3) {
                     Seat firstSeat = extractSeat(roomSeats, rowNum, 1);
                     Seat secondSeat = extractSeat(roomSeats, rowNum, 2);
                     Seat thirdSeat = extractSeat(roomSeats, rowNum, 3);
                     if (reservedSeats.contains(firstSeat)
                             && !reservedSeats.contains(secondSeat)
                             && reservedSeats.contains(thirdSeat))
                         return false;
                 }
                 continue;
            }

            // check on which side is seat
            int step = seatNum <= rowSize / 2 ? 1 : -1;
            if (checkNeighbours(seat, roomSeats, reservedSeats, step))
                return false;

            // pass second side if seat is near the edge
            if (seatNum < 3 || seatNum > rowSize - 2)
                continue;

            // change direction
            step *= -1;
            if (checkNeighbours(seat, roomSeats, reservedSeats, step))
                return false;
        }
        return true;
    }

    // returns true if there can be not allowed gap between seats
    private boolean checkNeighbours(Seat seat, List<Seat> roomSeats, List<Seat> reservedSeats, int step) {
        int rowNum = seat.getRowNum();
        int seatNum = seat.getSeatNum();

        int firstSeatNum = seatNum + step;
        int secondSeatNum = firstSeatNum + step;

        Seat firstStepSeat = extractSeat(roomSeats, rowNum, firstSeatNum);
        if (!reservedSeats.contains(firstStepSeat)) {
            Seat secondStepSeat = extractSeat(roomSeats, rowNum, secondSeatNum);
            return reservedSeats.contains(secondStepSeat);
        }
        return false;
    }

    private Seat extractSeat(List<Seat> seats, int rowNum, int seatNum) {
        return seats.stream()
                .filter(seat2 -> seat2.getRowNum() == rowNum && seat2.getSeatNum() == seatNum)
                .findAny()
                .orElseThrow(); // not suppose to happen
    }

    private int getRowSize(List<Seat> seats, int rowNum) {
        return (int) seats.stream()
                .filter(targetSeat -> targetSeat.getRowNum() == rowNum)
                .count();
    }
}
