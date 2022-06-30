package pl.touk.recruitmenttask.ticketbookingapp.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import pl.touk.recruitmenttask.ticketbookingapp.TestData;
import pl.touk.recruitmenttask.ticketbookingapp.exception.ResourceNotFoundException;
import pl.touk.recruitmenttask.ticketbookingapp.model.Screening;
import pl.touk.recruitmenttask.ticketbookingapp.service.RoomService;
import pl.touk.recruitmenttask.ticketbookingapp.service.SearchService;
import pl.touk.recruitmenttask.ticketbookingapp.service.SeatService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@WebMvcTest(SearchController.class)
class SearchControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SearchService fakeSearchService;

    @MockBean
    private SeatService fakeSeatService;

    @MockBean
    private RoomService fakeRoomService;


    @Test
    void getAllScreenings() throws Exception {
        when(fakeSearchService.getScreenings(anyInt())).thenReturn(TestData.screeningList);

        String url = "/all-screenings";
        mockMvc.perform(
                post(url).param("page", "0")
        ).andExpect(status().isOk())
                .andExpect(jsonPath("$..screeningId").hasJsonPath())
                .andExpect(jsonPath("$..title").hasJsonPath())
                .andExpect(jsonPath("$..screeningTime").hasJsonPath());
    }

    @Test
    void getScreeningsBetween() throws Exception {
        when(fakeSearchService.getScreeningsOnInterval(any())).thenReturn(TestData.screeningList);

        String url = "/screenings";
        mockMvc.perform(
                post(url).param("start", "2022-04-29T16:00:00")
        ).andExpect(status().isOk())
                .andExpect(jsonPath("$..screeningId").hasJsonPath())
                .andExpect(jsonPath("$..title").hasJsonPath())
                .andExpect(jsonPath("$..screeningTime").hasJsonPath());
    }

    @Test
    void getSingleScreening() throws Exception {
        when(fakeSearchService.getSingleScreening(anyInt())).thenReturn(TestData.screeningList.get(0));
        when(fakeRoomService.getSingleRoom(any(Screening.class))).thenReturn(TestData.roomList.get(0));
        when(fakeSeatService.getAvailableSeatsByScreening(any(Screening.class))).thenReturn(TestData.seatList);
        when(fakeSeatService.getReservedSeatsByScreening(any(Screening.class))).thenReturn(TestData.seatList);

        assertNotNull(TestData.roomList.get(0));

        String url = "/screenings/{id}";
        mockMvc.perform(
                get(url, anyInt())
        ).andExpect(status().isOk())
                .andExpect(jsonPath("$.movieInfo.screeningId").hasJsonPath())
                .andExpect(jsonPath("$.movieInfo.title").hasJsonPath())
                .andExpect(jsonPath("$.movieInfo.screeningTime").hasJsonPath())
                .andExpect(jsonPath("$.roomNum").hasJsonPath())
                .andExpect(jsonPath("$.seatsAvailable..seatId").hasJsonPath())
                .andExpect(jsonPath("$.seatsAvailable..seatNum").hasJsonPath())
                .andExpect(jsonPath("$.seatsAvailable..seatRow").hasJsonPath())
                .andExpect(jsonPath("$.seatsTaken..seatId").hasJsonPath())
                .andExpect(jsonPath("$.seatsTaken..seatNum").hasJsonPath())
                .andExpect(jsonPath("$.seatsTaken..seatRow").hasJsonPath());

        when(fakeSearchService.getSingleScreening(anyInt())).thenThrow(ResourceNotFoundException.class);

        mockMvc.perform(
                get(url, anyInt())
        ).andExpect(status().isNotFound());

    }
}