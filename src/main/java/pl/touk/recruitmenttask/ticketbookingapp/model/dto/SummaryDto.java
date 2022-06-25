package pl.touk.recruitmenttask.ticketbookingapp.model.dto;

import java.time.LocalDateTime;

public record SummaryDto(double total,
                         LocalDateTime expiration
) {}
