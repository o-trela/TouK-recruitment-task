package pl.touk.recruitmenttask.ticketbookingapp.service.mapper;

import pl.touk.recruitmenttask.ticketbookingapp.model.Seat;
import pl.touk.recruitmenttask.ticketbookingapp.model.dto.SeatDto;

import java.util.List;
import java.util.stream.Collectors;

public class SeatDtoMapper {
    public static List<SeatDto> mapToSeatDtos(List<Seat> seats) {
        return seats.stream()
                .map(SeatDtoMapper::mapToSeatDto)
                .collect(Collectors.toList());
    }

    public static SeatDto mapToSeatDto(Seat seat) {
        return new SeatDto(
                seat.getId(),
                seat.getSeatNum(),
                seat.getRowNum()
        );
    }
}
