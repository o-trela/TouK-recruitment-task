package pl.touk.recruitmenttask.ticketbookingapp.service;

import pl.touk.recruitmenttask.ticketbookingapp.model.TicketType;
import pl.touk.recruitmenttask.ticketbookingapp.service.properties.PropertiesConfig;

import java.math.BigDecimal;

public class TicketCashier {
    private TicketCashier() {}

    public static BigDecimal checkTicketCost(TicketType ticketType) {
        if (ticketType == null) {
            return BigDecimal.ZERO;
        }

        BigDecimal price;
        switch (ticketType) {
            case ADULT -> price = PropertiesConfig.adultPrice;
            case STUDENT -> price = PropertiesConfig.studentPrice;
            case CHILD -> price = PropertiesConfig.childPrice;
            default -> throw new IllegalArgumentException(ticketType + "not supported.");
        }

        return price;
    }
}
