package pl.touk.recruitmenttask.ticketbookingapp.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import pl.touk.recruitmenttask.ticketbookingapp.TestData;
import pl.touk.recruitmenttask.ticketbookingapp.exception.ResourceNotFoundException;
import pl.touk.recruitmenttask.ticketbookingapp.model.Screening;
import pl.touk.recruitmenttask.ticketbookingapp.repository.ScreeningRepository;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SearchServiceTest {

    @Mock
    private ScreeningRepository fakeScreeningRepository;

    private SearchService cheatedSearchService;

    @BeforeEach
    public void setup() {
        cheatedSearchService = new SearchService(fakeScreeningRepository);

        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
    }
    

    @Test
    void shouldReturnScreenings() {
        when(fakeScreeningRepository.findAllByStartTimeIsAfter(any(), any())).thenReturn(TestData.screeningList);

        assertEquals(TestData.screeningList, cheatedSearchService.getScreenings(0));
    }

    @Test
    void shouldReturnScreeningsOnInterval() {
        when(fakeScreeningRepository.findByStartTimeBetween(any(), any(), any()))
                .thenReturn(TestData.screeningList.subList(0, 2));

        assertEquals(cheatedSearchService.getScreeningsOnInterval(TestData.testStartTime), TestData.screeningList.subList(0, 2));
    }

    @Test
    void shouldReturnSingleScreening() {
        Screening testScreening = TestData.screeningList.get(0);
        int id = testScreening.getId();

        when(fakeScreeningRepository.findById(anyInt())).thenReturn(
                TestData.screeningList.stream()
                        .filter(screening -> screening.getId() == id)
                        .findAny()
        );

        assertEquals(cheatedSearchService.getSingleScreening(id), testScreening);
    }

    @Test
    void screeningNotFound() {
        when(fakeScreeningRepository.findById(anyInt())).thenThrow(ResourceNotFoundException.class);

        assertThrows(ResourceNotFoundException.class, () -> cheatedSearchService.getSingleScreening(0));
    }
}