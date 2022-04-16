package pl.touk.recruitmenttask.ticketbookingapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.touk.recruitmenttask.ticketbookingapp.model.Room;
import pl.touk.recruitmenttask.ticketbookingapp.model.Screening;
import pl.touk.recruitmenttask.ticketbookingapp.model.Seat;
import pl.touk.recruitmenttask.ticketbookingapp.model.dto.ScreeningInfoDto;
import pl.touk.recruitmenttask.ticketbookingapp.model.dto.ScreeningDto;
import pl.touk.recruitmenttask.ticketbookingapp.model.dto.SeatDto;
import pl.touk.recruitmenttask.ticketbookingapp.repository.RoomRepository;
import pl.touk.recruitmenttask.ticketbookingapp.repository.ScreeningRepository;
import pl.touk.recruitmenttask.ticketbookingapp.service.mapper.ScreeningDtoMapper;
import pl.touk.recruitmenttask.ticketbookingapp.service.mapper.SeatDtoMapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {
    private final ScreeningRepository screeningRepository;
    private final RoomRepository roomRepository;
    private final SeatService seatService;

    public List<Screening> getScreenings() {
        return screeningRepository.findAll();
    }

    public List<ScreeningDto> getScreeningsAfter(String start) {
        LocalDateTime startingDate = LocalDateTime.parse(start);
        LocalDate localDate = startingDate.toLocalDate();
        LocalDateTime endingDate = localDate.atTime(LocalTime.MAX);

        List<Screening> screeningList = screeningRepository.findByStartTimeBetween(startingDate, endingDate);

        return ScreeningDtoMapper.mapToScreeningDtos(screeningList);
    }

    public ScreeningInfoDto getSingleScreening(int id) {
        Screening pickedScreening = screeningRepository.findById(id).orElseThrow();
        Room screeningRoom = roomRepository.findByScreening(pickedScreening);

        List<Seat> availableSeats = seatService.getAvailableSeatsByScreening(pickedScreening);
        List<SeatDto> availableSeatsInfo = SeatDtoMapper.mapToSeatDtos(availableSeats);

        List<Seat> reservedSeats = seatService.getReservedSeatsByScreening(pickedScreening);
        List<SeatDto> reservedSeatsInfo = SeatDtoMapper.mapToSeatDtos(reservedSeats);

        return new ScreeningInfoDto(
                ScreeningDtoMapper.mapToScreeningDto(pickedScreening),
                screeningRoom.getId(),
                availableSeatsInfo,
                reservedSeatsInfo
        );
    }
}
