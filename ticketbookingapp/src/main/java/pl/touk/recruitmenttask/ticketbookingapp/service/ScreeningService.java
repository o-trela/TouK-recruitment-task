package pl.touk.recruitmenttask.ticketbookingapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.touk.recruitmenttask.ticketbookingapp.model.ReservedSeat;
import pl.touk.recruitmenttask.ticketbookingapp.model.Room;
import pl.touk.recruitmenttask.ticketbookingapp.model.Screening;
import pl.touk.recruitmenttask.ticketbookingapp.model.Seat;
import pl.touk.recruitmenttask.ticketbookingapp.model.record.PickedScreeningResult;
import pl.touk.recruitmenttask.ticketbookingapp.model.record.ScreeningSearchResult;
import pl.touk.recruitmenttask.ticketbookingapp.model.record.SeatRecord;
import pl.touk.recruitmenttask.ticketbookingapp.repository.ReservedSeatRepository;
import pl.touk.recruitmenttask.ticketbookingapp.repository.RoomRepository;
import pl.touk.recruitmenttask.ticketbookingapp.repository.ScreeningRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScreeningService {

    private final ScreeningRepository screeningRepository;
    private final RoomRepository roomRepository;
    private final ReservedSeatRepository reservedSeatRepository;

    public List<Screening> getScreenings() {
        return screeningRepository.findAll();
    }

    public List<ScreeningSearchResult> getScreeningsAfter(String start) {
        LocalDateTime startingDate = LocalDateTime.parse(start);
        LocalDate localDate = startingDate.toLocalDate();
        LocalDateTime endingDate = localDate.atTime(LocalTime.MAX);

        List<Screening> screeningList = screeningRepository.findByStartTimeBetween(startingDate, endingDate);

        return extractScreeningInfo(screeningList);
    }

    public PickedScreeningResult getSingleScreening(int id) {
        Screening pickedScreening = screeningRepository.findById(id).orElseThrow();
        Room screeningRoom = roomRepository.findByScreening(pickedScreening);

        List<Seat> availableSeats = screeningRoom.getSeat();
        List<SeatRecord> availableSeatsInfo = extractSeatInfo(availableSeats);

        List<Seat> reservedSeats = getReservedSeatsByScreeningId(id);
        List<SeatRecord> reservedSeatsInfo = extractSeatInfo(reservedSeats);

        return new PickedScreeningResult(
                extractScreeningInfo(List.of(pickedScreening)).get(0),
                screeningRoom.getId(),
                availableSeatsInfo,
                reservedSeatsInfo
        );
    }

    public List<Seat> getReservedSeatsByScreeningId(int id) {
        List<Seat> reservedSeats = new ArrayList<>();

        List<ReservedSeat> tickets = reservedSeatRepository.findByScreeningId(id);
        for (ReservedSeat rs : tickets) {
            Seat seat = rs.getSeat();
            reservedSeats.add(seat);
        }

        return reservedSeats;
    }

    private List<ScreeningSearchResult> extractScreeningInfo(List<Screening> screeningList) {
        List<ScreeningSearchResult> resultList = new ArrayList<>();
        for (Screening s : screeningList) {
            int id = s.getId();
            String title = s.getMovie().getTitle();
            LocalDateTime startTime = s.getStartTime();
            ScreeningSearchResult result = new ScreeningSearchResult(id, title, startTime);
            resultList.add(result);
        }

        return resultList;
    }

    public List<SeatRecord> extractSeatInfo(List<Seat> seats) {
        List<SeatRecord> seatRecords = new ArrayList<>();

        for (Seat seat : seats) {
            int seatId = seat.getId();
            int seatNum = seat.getSeatNum();
            int seatRow = seat.getRowNum();
            seatRecords.add(new SeatRecord(seatId, seatNum, seatRow));
        }

        return seatRecords;
    }

}
