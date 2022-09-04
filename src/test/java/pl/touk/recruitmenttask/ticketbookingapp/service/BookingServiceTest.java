package pl.touk.recruitmenttask.ticketbookingapp.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.touk.recruitmenttask.ticketbookingapp.TestData;
import pl.touk.recruitmenttask.ticketbookingapp.exception.TooLateException;
import pl.touk.recruitmenttask.ticketbookingapp.model.Reservation;
import pl.touk.recruitmenttask.ticketbookingapp.model.Screening;
import pl.touk.recruitmenttask.ticketbookingapp.model.Ticket;
import pl.touk.recruitmenttask.ticketbookingapp.model.TicketType;
import pl.touk.recruitmenttask.ticketbookingapp.repository.ReservationRepository;
import pl.touk.recruitmenttask.ticketbookingapp.repository.TicketRepository;
import pl.touk.recruitmenttask.ticketbookingapp.service.properties.PropertiesConfig;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookingServiceTest {

    @Mock
    private ReservationRepository fakeReservationRepository;
    @Mock
    private TicketRepository fakeTicketRepository;
    @Mock
    private SeatService fakeSeatService;
    @Mock
    private SearchService fakeSearchService;
    @Mock
    private PropertiesConfig fakePropertiesConfig;

    private BookingService cheatedBookingService;

    @BeforeEach
    public void setup() {
        cheatedBookingService = new BookingService(
                fakeReservationRepository,
                fakeTicketRepository,
                fakeSeatService,
                fakeSearchService,
                fakePropertiesConfig
        );
    }

    @Test
    void makeCorrectReservationAndTickets() {
        Screening testScreening = TestData.screeningList.get(0);
        String testName = "testName";
        String testSurname = "testSurname";

        when(fakeSearchService.getSingleScreening(anyInt())).thenReturn(testScreening);
        when(fakeSeatService.getSeatsByIds(anySet())).thenReturn(TestData.seatList.subList(1,2));
        when(fakeSeatService.validateSeats(any(), any())).thenReturn(true);
        when(fakeSeatService.ensureNotReserved(any(), any())).thenReturn(true);
        when(fakeSeatService.ensureNoGapOccurs(any(), any())).thenReturn(true);

        Map<Integer, TicketType> seatsType = Map.of(
                2, TicketType.ADULT
        );

        Reservation testReservation = cheatedBookingService.makeReservation(
                1,
                testName,
                testSurname,
                seatsType,
                TestData.testStartTime.minusMinutes(30)
        );
        assertNotNull(testReservation);

        Ticket correctTicket = Ticket.builder()
                        .ticketType(TicketType.ADULT)
                        .reservation(testReservation)
                        .screening(testScreening)
                        .seat(TestData.seatList.get(1))
                        .build();
        assertEquals(testReservation.getTicket().get(0), correctTicket);

        Reservation correctReservation = Reservation.builder()
                .screening(testScreening)
                .name(testName)
                .surname(testSurname)
                .ticket(List.of(correctTicket))
                .build();
        assertEquals(correctReservation, testReservation);

    }

    @Test
    void makeReservationTooLate() {
        Screening testScreening = TestData.screeningList.get(0);
        String testName = "testName";
        String testSurname = "testSurname";

        when(fakeSearchService.getSingleScreening(anyInt())).thenReturn(testScreening);
        when(fakePropertiesConfig.getExpirationTimeMin()).thenReturn(15L);

        Map<Integer, TicketType> seatsType = Map.of(
                2, TicketType.ADULT
        );

        assertThrows(TooLateException.class, () -> cheatedBookingService.makeReservation(
                1,
                testName,
                testSurname,
                seatsType,
                TestData.testStartTime.minusMinutes(10)
        ));

    }
}