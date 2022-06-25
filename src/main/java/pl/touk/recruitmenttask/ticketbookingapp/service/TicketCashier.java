package pl.touk.recruitmenttask.ticketbookingapp.service;

import pl.touk.recruitmenttask.ticketbookingapp.model.TicketType;
import pl.touk.recruitmenttask.ticketbookingapp.service.properties.PropertiesConfig;

public class TicketCashier {
    private TicketCashier() {}

    public static double checkTicketCost(TicketType ticketType) {
        if (ticketType == null) {
            return 0;
        }

        double price;
        switch (ticketType) {
            case adult -> price = PropertiesConfig.adultPrice;
            case student -> price = PropertiesConfig.studentPrice;
            case child -> price = PropertiesConfig.childPrice;
            default -> throw new IllegalArgumentException(ticketType + "not supported.");
        }

        return price;
    }
}
