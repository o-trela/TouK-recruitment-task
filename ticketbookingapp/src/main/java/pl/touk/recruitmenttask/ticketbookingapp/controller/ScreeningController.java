package pl.touk.recruitmenttask.ticketbookingapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.touk.recruitmenttask.ticketbookingapp.model.Screening;
import pl.touk.recruitmenttask.ticketbookingapp.model.record.PickedScreeningResult;
import pl.touk.recruitmenttask.ticketbookingapp.model.record.ScreeningSearchResult;
import pl.touk.recruitmenttask.ticketbookingapp.service.ScreeningService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScreeningController {

    private final ScreeningService screeningService;

    @GetMapping("/screenings")
    public List<Screening> getAllScreenings() {
        return screeningService.getScreenings();
    }

    @PostMapping("/screenings")
    public List<ScreeningSearchResult> getScreeningsBetween(
            @RequestParam(required = true) String start) {
        return screeningService.getScreeningsAfter(start);
    }

    @GetMapping("/screenings/{id}")
    public PickedScreeningResult getSingleScreening(@PathVariable int id) {
        return screeningService.getSingleScreening(id);
    }
}
