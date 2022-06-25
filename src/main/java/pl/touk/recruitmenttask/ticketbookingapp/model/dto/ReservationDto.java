package pl.touk.recruitmenttask.ticketbookingapp.model.dto;

import pl.touk.recruitmenttask.ticketbookingapp.model.TicketType;

import java.util.Map;

public record ReservationDto(
        String name,
        String surname,
        Map<Integer, TicketType> seats
) {}
