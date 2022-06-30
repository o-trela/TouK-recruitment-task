package pl.touk.recruitmenttask.ticketbookingapp.service.mapper;

import pl.touk.recruitmenttask.ticketbookingapp.model.Reservation;
import pl.touk.recruitmenttask.ticketbookingapp.model.Ticket;
import pl.touk.recruitmenttask.ticketbookingapp.model.TicketType;
import pl.touk.recruitmenttask.ticketbookingapp.model.dto.SummaryDto;
import pl.touk.recruitmenttask.ticketbookingapp.service.TicketCashier;
import pl.touk.recruitmenttask.ticketbookingapp.service.properties.PropertiesConfig;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class SummaryDtoMapper {
    private SummaryDtoMapper() {}

    public static SummaryDto mapToSummaryDto(Reservation reservation) {
        List<Ticket> tickets = reservation.getTicket();
        LocalDateTime now = LocalDateTime.now();

        BigDecimal total = BigDecimal.ZERO;
        for (Ticket ticket : tickets) {
            BigDecimal price = TicketCashier.checkTicketCost(ticket.getTicketType());
            total = total.add(price);
        }

        return new SummaryDto(total, now.plusMinutes(PropertiesConfig.expirationTimeMin));
    }
}
