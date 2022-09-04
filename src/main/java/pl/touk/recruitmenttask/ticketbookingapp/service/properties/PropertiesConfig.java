package pl.touk.recruitmenttask.ticketbookingapp.service.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "config")
public class PropertiesConfig {
    private BigDecimal adultPrice;
    private BigDecimal studentPrice;
    private BigDecimal childPrice;

    public long expirationTimeMin;
}
