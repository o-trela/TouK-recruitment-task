package pl.touk.recruitmenttask.ticketbookingapp.model.record;

import java.time.LocalDateTime;

public record ScreeningSearchResult(
        int screeningId,
        String title,
        LocalDateTime screeningTime
) {}
