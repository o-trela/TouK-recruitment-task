package pl.touk.recruitmenttask.ticketbookingapp.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.touk.recruitmenttask.ticketbookingapp.exception.ResourceNotFoundException;
import pl.touk.recruitmenttask.ticketbookingapp.model.*;
import pl.touk.recruitmenttask.ticketbookingapp.repository.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class SearchService {
    private static final int PAGE_SIZE = 10;
    private final ScreeningRepository screeningRepository;

    public List<Screening> getScreenings(int pageNumber) {
        return screeningRepository
                .findAllByStartTimeIsAfter(
                        LocalDateTime.now(),
                        PageRequest.of(pageNumber, PAGE_SIZE)
                );
    }

    public List<Screening> getScreeningsOnInterval(LocalDateTime startingDate) {
        LocalDateTime endingDate = getEndOfTheDay(startingDate);

        return screeningRepository
                .findByStartTimeBetween(
                        startingDate,
                        endingDate,
                        Sort.by(Sort.Direction.ASC, "startTime", "movie.title")
                );
    }

    public Screening getSingleScreening(int id) {
        Screening pickedScreening;
        try {
            pickedScreening = screeningRepository.findById(id).orElseThrow();
        }
        catch (NoSuchElementException e) {
            throw new ResourceNotFoundException("Screening Not Found");
        }

        return pickedScreening;
    }

    private LocalDateTime getEndOfTheDay(LocalDateTime dateTime) {
        LocalDate localDate = dateTime.toLocalDate();
        return localDate.atTime(LocalTime.MAX);
    }
}
