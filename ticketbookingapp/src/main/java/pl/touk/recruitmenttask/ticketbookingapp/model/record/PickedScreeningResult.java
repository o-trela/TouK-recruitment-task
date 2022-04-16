package pl.touk.recruitmenttask.ticketbookingapp.model.record;

import java.util.List;

public record PickedScreeningResult(
        ScreeningSearchResult movieInfo,
        int roomNum,
        List<SeatRecord> seatsAvailable,
        List<SeatRecord> seatsTaken
) {}
