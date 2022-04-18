package pl.touk.recruitmenttask.ticketbookingapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.touk.recruitmenttask.ticketbookingapp.exception.ResourceNotFoundException;
import pl.touk.recruitmenttask.ticketbookingapp.exception.WrongSeatException;
import pl.touk.recruitmenttask.ticketbookingapp.model.Reservation;
import pl.touk.recruitmenttask.ticketbookingapp.model.TicketType;
import pl.touk.recruitmenttask.ticketbookingapp.model.dto.SummaryDto;
import pl.touk.recruitmenttask.ticketbookingapp.service.BookingService;
import pl.touk.recruitmenttask.ticketbookingapp.service.mapper.SummaryDtoMapper;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping("/reservation/{screeningId}")
    @Validated
    public SummaryDto makeReservation(@PathVariable int screeningId,
                                      @RequestBody @NotBlank Map<Integer, TicketType> seats,
                                      @RequestParam
                                          @NotBlank @Size(min = 3)
                                          @Pattern(regexp = "^[A-Z][a-z]+$") String name,
                                      @RequestParam
                                          @NotBlank @Size(min = 3)
                                          @Pattern(regexp = "^[A-Z][a-z][a-z]+([\s][A-Z][a-z][a-z]+)*$") String surname) {

        if (seats.isEmpty()) {
            throw new WrongSeatException("No Seats Were Passed");
        }

        Reservation reservation = bookingService.makeReservation(screeningId, name, surname, seats);
        return SummaryDtoMapper.mapToSummaryDto(reservation);
    }
}
