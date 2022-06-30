package pl.touk.recruitmenttask.ticketbookingapp.model.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record SummaryDto(BigDecimal total,
                         LocalDateTime expiration
) {}
