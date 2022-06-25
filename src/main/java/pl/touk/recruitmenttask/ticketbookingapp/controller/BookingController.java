package pl.touk.recruitmenttask.ticketbookingapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.touk.recruitmenttask.ticketbookingapp.controller.validation.StringValidator;
import pl.touk.recruitmenttask.ticketbookingapp.exception.BadRequestException;
import pl.touk.recruitmenttask.ticketbookingapp.model.Reservation;
import pl.touk.recruitmenttask.ticketbookingapp.model.TicketType;
import pl.touk.recruitmenttask.ticketbookingapp.model.dto.SummaryDto;
import pl.touk.recruitmenttask.ticketbookingapp.service.BookingService;
import pl.touk.recruitmenttask.ticketbookingapp.service.mapper.SummaryDtoMapper;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
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
                                      @RequestParam @NotBlank @Size(min = 3) String name,
                                      @RequestParam @NotBlank @Size(min = 3) String surname,
                                      @RequestBody Map<Integer, TicketType> seats) {

        if (seats.isEmpty()) {
            throw new BadRequestException("No Seats Were Passed");
        }

        validateName(name);
        validateSurname(surname);

        Reservation reservation = bookingService.makeReservation(screeningId, name, surname, seats, LocalDateTime.now());
        return SummaryDtoMapper.mapToSummaryDto(reservation);
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
