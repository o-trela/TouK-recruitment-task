package pl.touk.recruitmenttask.ticketbookingapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.touk.recruitmenttask.ticketbookingapp.controller.validation.StringValidator;
import pl.touk.recruitmenttask.ticketbookingapp.exception.BadRequestException;
import pl.touk.recruitmenttask.ticketbookingapp.model.Reservation;
import pl.touk.recruitmenttask.ticketbookingapp.model.TicketType;
import pl.touk.recruitmenttask.ticketbookingapp.model.dto.ReservationDto;
import pl.touk.recruitmenttask.ticketbookingapp.model.dto.SummaryDto;
import pl.touk.recruitmenttask.ticketbookingapp.service.BookingService;
import pl.touk.recruitmenttask.ticketbookingapp.service.mapper.SummaryDtoMapper;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;
    private final StringValidator stringValidator;

    @PostMapping("/reservation/{screeningId}")
    @ResponseStatus(HttpStatus.CREATED)
    public SummaryDto makeReservation(@PathVariable int screeningId,
                                      @RequestBody ReservationDto clientReservationInfo) {

        var seats = clientReservationInfo.seats();
        var name = clientReservationInfo.name();
        var surname = clientReservationInfo.surname();

        validateSeats(seats);
        validateName(name);
        validateSurname(surname);

        Reservation reservation = bookingService.makeReservation(screeningId, name, surname, seats, LocalDateTime.now());
        return SummaryDtoMapper.mapToSummaryDto(reservation);
    }

    private void validateSeats(Map<Integer, TicketType> seats) {
        if (seats.isEmpty()) {
            throw new BadRequestException("No Seats Were Passed");
        }
    }

    private void validateName(String name) {
        stringValidator.setRegex("^[\\p{Lu}][\\p{Ll}][\\p{Ll}]+$");
        if (!stringValidator.isValid(name)) {
            throw new BadRequestException("Wrong Name Pattern");
        }
    }

    private void validateSurname(String surname) {
        stringValidator.setRegex("^[\\p{Lu}][\\p{Ll}][\\p{Ll}]+([ ][\\p{Lu}][\\p{Ll}][\\p{Ll}]+)?$");
        if (!stringValidator.isValid(surname)) {
            throw new BadRequestException("Wrong Surname Pattern");
        }
    }
}
