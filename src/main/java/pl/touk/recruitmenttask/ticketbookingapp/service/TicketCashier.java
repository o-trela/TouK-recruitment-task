package pl.touk.recruitmenttask.ticketbookingapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.touk.recruitmenttask.ticketbookingapp.model.TicketType;
import pl.touk.recruitmenttask.ticketbookingapp.service.properties.PropertiesConfig;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class TicketCashier {
    public final PropertiesConfig propertiesConfig;

    public BigDecimal checkTicketCost(TicketType ticketType) {
        if (ticketType == null) {
            return BigDecimal.ZERO;
        }

        BigDecimal price;
        switch (ticketType) {
            case ADULT -> price = propertiesConfig.getAdultPrice();
            case STUDENT -> price = propertiesConfig.getStudentPrice();
            case CHILD -> price = propertiesConfig.getChildPrice();
            default -> throw new IllegalArgumentException(ticketType + " not supported.");
        }

        return price;
    }
}
