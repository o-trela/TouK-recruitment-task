package pl.touk.recruitmenttask.ticketbookingapp.service.properties;

import java.math.BigDecimal;

public class PropertiesConfig {
    public final static BigDecimal adultPrice = new BigDecimal("25");
    public final static BigDecimal studentPrice = new BigDecimal("18");
    public final static BigDecimal childPrice = new BigDecimal("12.5");

    public final static long expirationTimeMin = 15;

    private PropertiesConfig() {}
}
