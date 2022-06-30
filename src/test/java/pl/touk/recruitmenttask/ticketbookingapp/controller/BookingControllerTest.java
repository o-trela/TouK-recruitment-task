package pl.touk.recruitmenttask.ticketbookingapp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import pl.touk.recruitmenttask.ticketbookingapp.TestData;
import pl.touk.recruitmenttask.ticketbookingapp.controller.validation.NameValidator;
import pl.touk.recruitmenttask.ticketbookingapp.controller.validation.SurnameValidator;
import pl.touk.recruitmenttask.ticketbookingapp.exception.AlreadyTakenException;
import pl.touk.recruitmenttask.ticketbookingapp.exception.ResourceNotFoundException;
import pl.touk.recruitmenttask.ticketbookingapp.exception.TooLateException;
import pl.touk.recruitmenttask.ticketbookingapp.model.TicketType;
import pl.touk.recruitmenttask.ticketbookingapp.service.BookingService;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookingController.class)
class BookingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookingService fakeBookingService;

    @MockBean
    private NameValidator fakeNameValidator;

    @MockBean
    private SurnameValidator fakeSurnameValidator;

    private String requestJson;

    @BeforeEach
    public void setup() throws JsonProcessingException {
        when(fakeBookingService.makeReservation(anyInt(), anyString(), anyString(), anyMap(), any())).thenReturn(TestData.reservation);
        when(fakeNameValidator.isValid(anyString())).thenReturn(true);
        when(fakeSurnameValidator.isValid(anyString())).thenReturn(true);

        Map<Integer, TicketType> seats = new HashMap<>();
        seats.put(1, TicketType.ADULT);

        Map<String, Object> testContents = new HashMap<>();
        testContents.put("name", "Test");
        testContents.put("surname", "Test");
        testContents.put("seats", seats);

        ObjectMapper objectMapper = new ObjectMapper();
        requestJson = objectMapper.writeValueAsString(testContents);
    }

    @Test
    void makeReservationCreated() throws Exception {
        String url = "/reservation/{screeningId}";
        mockMvc.perform(
                post(url, 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson)
        ).andExpect(status().isCreated())
                .andExpect(jsonPath("$.total").hasJsonPath())
                .andExpect(jsonPath("$.expiration").hasJsonPath());
    }

    @Test
    void makeReservationBadRequest() throws Exception {
        requestJson = """
                {
                  "surname": "Test",
                  "name": "Test",
                  "seats": {}
                }
                """;

        String url = "/reservation/{screeningId}";
        mockMvc.perform(
                post(url, 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson)
        ).andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.httpStatus").value("BAD_REQUEST"))
                .andExpect(jsonPath("$.message").value("No Seats Were Passed"))
                .andExpect(jsonPath("$.timestamp").hasJsonPath());
    }

    @Test
    void makeReservationBadRequestName() throws Exception {
        when(fakeNameValidator.isValid(anyString())).thenReturn(false);

        String url = "/reservation/{screeningId}";
        mockMvc.perform(
                post(url, 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson)
        ).andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.httpStatus").value("BAD_REQUEST"))
                .andExpect(jsonPath("$.message").value("Wrong Name Pattern"))
                .andExpect(jsonPath("$.timestamp").hasJsonPath());
    }

    @Test
    void makeReservationConflict() throws Exception {
        when(fakeBookingService.makeReservation(anyInt(), anyString(), anyString(), anyMap(), any())).thenThrow(AlreadyTakenException.class);

        String url = "/reservation/{screeningId}";
        mockMvc.perform(
                post(url, 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson)
        ).andExpect(status().isConflict())
                .andExpect(jsonPath("$.httpStatus").value("CONFLICT"))
                .andExpect(jsonPath("$.message").hasJsonPath())
                .andExpect(jsonPath("$.timestamp").hasJsonPath());
    }

    @Test
    void makeReservationNotFound() throws Exception {
        when(fakeBookingService.makeReservation(anyInt(), anyString(), anyString(), anyMap(), any())).thenThrow(ResourceNotFoundException.class);

        String url = "/reservation/{screeningId}";
        mockMvc.perform(
                post(url, 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson)
        ).andExpect(status().isNotFound())
                .andExpect(jsonPath("$.httpStatus").value("NOT_FOUND"))
                .andExpect(jsonPath("$.message").hasJsonPath())
                .andExpect(jsonPath("$.timestamp").hasJsonPath());;
    }

    @Test
    void makeReservationTooLate() throws Exception {
        when(fakeBookingService.makeReservation(anyInt(), anyString(), anyString(), anyMap(), any())).thenThrow(TooLateException.class);

        String url = "/reservation/{screeningId}";
        mockMvc.perform(
                post(url, 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson)
        ).andExpect(status().isGone())
                .andExpect(jsonPath("$.httpStatus").value("GONE"))
                .andExpect(jsonPath("$.message").hasJsonPath())
                .andExpect(jsonPath("$.timestamp").hasJsonPath());;
    }
}