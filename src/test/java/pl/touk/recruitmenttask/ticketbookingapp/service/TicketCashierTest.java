package pl.touk.recruitmenttask.ticketbookingapp.service;

import org.junit.jupiter.api.Test;
import pl.touk.recruitmenttask.ticketbookingapp.model.TicketType;
import pl.touk.recruitmenttask.ticketbookingapp.service.properties.PropertiesConfig;

import static org.junit.jupiter.api.Assertions.*;

class TicketCashierTest {

    @Test
    void checkTicketCost() {
        assertEquals(PropertiesConfig.adultPrice, TicketCashier.checkTicketCost(TicketType.ADULT));
        assertEquals(PropertiesConfig.studentPrice, TicketCashier.checkTicketCost(TicketType.STUDENT));
        assertEquals(PropertiesConfig.childPrice, TicketCashier.checkTicketCost(TicketType.CHILD));

    }
}