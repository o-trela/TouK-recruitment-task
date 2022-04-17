package pl.touk.recruitmenttask.ticketbookingapp.service.mapper;

import pl.touk.recruitmenttask.ticketbookingapp.model.Screening;
import pl.touk.recruitmenttask.ticketbookingapp.model.dto.ScreeningDto;

import java.util.List;
import java.util.stream.Collectors;

public class ScreeningDtoMapper {
    private ScreeningDtoMapper() {}

    public static List<ScreeningDto> mapToScreeningDtos(List<Screening> screeningList) {
        return screeningList.stream()
                .map(ScreeningDtoMapper::mapToScreeningDto)
                .collect(Collectors.toList());
    }

    public static ScreeningDto mapToScreeningDto(Screening screening) {
        return new ScreeningDto(
                screening.getId(),
                screening.getMovie().getTitle(),
                screening.getStartTime()
        );
    }
}
