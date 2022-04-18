package pl.touk.recruitmenttask.ticketbookingapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.touk.recruitmenttask.ticketbookingapp.exception.ResourceNotFoundException;
import pl.touk.recruitmenttask.ticketbookingapp.model.*;
import pl.touk.recruitmenttask.ticketbookingapp.model.dto.ScreeningInfoDto;
import pl.touk.recruitmenttask.ticketbookingapp.model.dto.ScreeningDto;
import pl.touk.recruitmenttask.ticketbookingapp.model.dto.SeatDto;
import pl.touk.recruitmenttask.ticketbookingapp.repository.*;
import pl.touk.recruitmenttask.ticketbookingapp.service.mapper.ScreeningDtoMapper;
import pl.touk.recruitmenttask.ticketbookingapp.service.mapper.SeatDtoMapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class SearchService {
    private final ScreeningRepository screeningRepository;
    private final RoomRepository roomRepository;
    private final SeatService seatService;

    public List<Screening> getScreenings() {
        return screeningRepository.findAll();
    }

    public List<ScreeningDto> getScreeningsOnInterval(String start) {
        LocalDateTime startingDate = LocalDateTime.parse(start);
        LocalDateTime endingDate = getEndOfTheDay(startingDate);

        List<Screening> screeningList = screeningRepository
                .findByStartTimeBetween(
                        startingDate,
                        endingDate,
                        Sort.by(Sort.Direction.ASC, "startTime", "movie.title")
                );

        return ScreeningDtoMapper.mapToScreeningDtos(screeningList);
    }

    public ScreeningInfoDto getSingleScreening(int id) {
        Screening pickedScreening;
        try {
            pickedScreening = screeningRepository.findById(id).orElseThrow();
        }
        catch (NoSuchElementException e) {
            throw new ResourceNotFoundException("Screening Not Found");
        }

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

    private LocalDateTime getEndOfTheDay(LocalDateTime dateTime) {
        LocalDate localDate = dateTime.toLocalDate();
        return localDate.atTime(LocalTime.MAX);
    }
}
