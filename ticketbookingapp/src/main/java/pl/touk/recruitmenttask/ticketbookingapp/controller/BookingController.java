package pl.touk.recruitmenttask.ticketbookingapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.touk.recruitmenttask.ticketbookingapp.model.Reservation;
import pl.touk.recruitmenttask.ticketbookingapp.model.TicketType;
import pl.touk.recruitmenttask.ticketbookingapp.model.dto.SummaryDto;
import pl.touk.recruitmenttask.ticketbookingapp.service.BookingService;
import pl.touk.recruitmenttask.ticketbookingapp.service.mapper.SummaryDtoMapper;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping("/reservation/{screeningId}")
    public SummaryDto makeReservation(@PathVariable int screeningId,
                                      @RequestBody Map<Integer, TicketType> seats,
                                      @RequestParam String name,
                                      @RequestParam String surname) {

        Reservation reservation = bookingService.makeReservation(screeningId, name, surname, seats);
        return SummaryDtoMapper.mapToSummaryDto(reservation);
    }
}
