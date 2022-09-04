package pl.touk.recruitmenttask.ticketbookingapp.controller.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.touk.recruitmenttask.ticketbookingapp.model.Reservation;
import pl.touk.recruitmenttask.ticketbookingapp.model.Ticket;
import pl.touk.recruitmenttask.ticketbookingapp.model.TicketType;
import pl.touk.recruitmenttask.ticketbookingapp.model.dto.SummaryDto;
import pl.touk.recruitmenttask.ticketbookingapp.service.TicketCashier;
import pl.touk.recruitmenttask.ticketbookingapp.service.properties.PropertiesConfig;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class SummaryMapper {

    private final PropertiesConfig propertiesConfig;
    private final TicketCashier ticketCashier;

    public SummaryDto mapToSummaryDto(Reservation reservation) {
        List<Ticket> tickets = reservation.getTicket();
        LocalDateTime now = LocalDateTime.now();

        BigDecimal total = BigDecimal.ZERO;
        for (Ticket ticket : tickets) {
            TicketType ticketType = ticket.getTicketType();
            BigDecimal price = ticketCashier.checkTicketCost(ticketType);
            total = total.add(price);
        }

        return new SummaryDto(total, now.plusMinutes(propertiesConfig.getExpirationTimeMin()));
    }
}
