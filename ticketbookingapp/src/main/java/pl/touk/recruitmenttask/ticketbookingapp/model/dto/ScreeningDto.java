package pl.touk.recruitmenttask.ticketbookingapp.model.dto;

import java.time.LocalDateTime;

public record ScreeningDto(
        int screeningId,
        String title,
        LocalDateTime screeningTime
) {}
