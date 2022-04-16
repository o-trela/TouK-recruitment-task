package pl.touk.recruitmenttask.ticketbookingapp.model.dto;

import java.util.List;

public record ScreeningInfoDto(
        ScreeningDto movieInfo,
        int roomNum,
        List<SeatDto> seatsAvailable,
        List<SeatDto> seatsTaken
) {}
