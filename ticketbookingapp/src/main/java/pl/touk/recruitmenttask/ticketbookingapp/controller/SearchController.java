package pl.touk.recruitmenttask.ticketbookingapp.controller;

import lombok.RequiredArgsConstructor;
import org.apache.tomcat.jni.Local;
import org.springframework.web.bind.annotation.*;
import pl.touk.recruitmenttask.ticketbookingapp.model.Room;
import pl.touk.recruitmenttask.ticketbookingapp.model.Screening;
import pl.touk.recruitmenttask.ticketbookingapp.model.Seat;
import pl.touk.recruitmenttask.ticketbookingapp.model.dto.ScreeningInfoDto;
import pl.touk.recruitmenttask.ticketbookingapp.model.dto.ScreeningDto;
import pl.touk.recruitmenttask.ticketbookingapp.model.dto.SeatDto;
import pl.touk.recruitmenttask.ticketbookingapp.service.BookingService;
import pl.touk.recruitmenttask.ticketbookingapp.service.RoomService;
import pl.touk.recruitmenttask.ticketbookingapp.service.SearchService;
import pl.touk.recruitmenttask.ticketbookingapp.service.SeatService;
import pl.touk.recruitmenttask.ticketbookingapp.service.mapper.ScreeningDtoMapper;
import pl.touk.recruitmenttask.ticketbookingapp.service.mapper.SeatDtoMapper;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class SearchController {

    private final SearchService searchService;
    private final SeatService seatService;
    private final RoomService roomService;

    @GetMapping("/screenings")
    public List<ScreeningDto> getAllScreenings() {
        List<Screening> screeningList = searchService.getScreenings();
        return ScreeningDtoMapper.mapToScreeningDtos(screeningList);
    }

    @PostMapping("/screenings")
    public List<ScreeningDto> getScreeningsBetween(
            @RequestParam(required = true) String start) {
        LocalDateTime startingTime = LocalDateTime.parse(start);
        List<Screening> screeningList = searchService.getScreeningsOnInterval(startingTime);
        return ScreeningDtoMapper.mapToScreeningDtos(screeningList);
    }

    @GetMapping("/screenings/{id}")
    public ScreeningInfoDto getSingleScreening(@PathVariable int id) {
        Screening screening = searchService.getSingleScreening(id);
        Room screeningRoom = roomService.getSingleRoom(screening);
        List<Seat> availableSeats = seatService.getAvailableSeatsByScreening(screening);
        List<SeatDto> availableSeatsInfo = SeatDtoMapper.mapToSeatDtos(availableSeats);

        List<Seat> reservedSeats = seatService.getReservedSeatsByScreening(screening);
        List<SeatDto> reservedSeatsInfo = SeatDtoMapper.mapToSeatDtos(reservedSeats);

        return new ScreeningInfoDto(
                ScreeningDtoMapper.mapToScreeningDto(screening),
                screeningRoom.getId(),
                availableSeatsInfo,
                reservedSeatsInfo
        );
    }

}
