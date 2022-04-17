package pl.touk.recruitmenttask.ticketbookingapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.touk.recruitmenttask.ticketbookingapp.model.Reservation;
import pl.touk.recruitmenttask.ticketbookingapp.model.Screening;
import pl.touk.recruitmenttask.ticketbookingapp.model.TicketType;
import pl.touk.recruitmenttask.ticketbookingapp.model.dto.ScreeningInfoDto;
import pl.touk.recruitmenttask.ticketbookingapp.model.dto.ScreeningDto;
import pl.touk.recruitmenttask.ticketbookingapp.model.dto.SummaryDto;
import pl.touk.recruitmenttask.ticketbookingapp.service.BookingService;
import pl.touk.recruitmenttask.ticketbookingapp.service.SearchService;
import pl.touk.recruitmenttask.ticketbookingapp.service.mapper.SummaryDtoMapper;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class SearchController {

    private final SearchService searchService;
    private final BookingService bookingService;

    @GetMapping("/screenings")
    public List<Screening> getAllScreenings() {
        return searchService.getScreenings();
    }

    @PostMapping("/screenings")
    public List<ScreeningDto> getScreeningsBetween(
            @RequestParam(required = true) String start) {
        return searchService.getScreeningsOnInterval(start);
    }

    @GetMapping("/screenings/{id}")
    public ScreeningInfoDto getSingleScreening(@PathVariable int id) {
        return searchService.getSingleScreening(id);
    }

}
