package pl.touk.recruitmenttask.ticketbookingapp.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.touk.recruitmenttask.ticketbookingapp.TestData;
import pl.touk.recruitmenttask.ticketbookingapp.model.Seat;
import pl.touk.recruitmenttask.ticketbookingapp.repository.SeatRepository;
import pl.touk.recruitmenttask.ticketbookingapp.repository.TicketRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SeatServiceTest {

    @Mock
    private TicketRepository fakeTicketRepository;
    @Mock
    private SeatRepository fakeSeatRepository;

    private SeatService cheatedSeatService;

    @BeforeEach
    public void setup() {
        cheatedSeatService = new SeatService(fakeTicketRepository, fakeSeatRepository);
    }

    // Room 1
    //  0   1   2   3   4   5
    // [x] [ ] [x] [x] [ ] [ ]

    //Room 2
    //  6
    // [ ]

    @Test
    void getReservedSeatsByScreening() {
        when(fakeTicketRepository.findByScreening(any())).thenReturn(TestData.ticketList.subList(0,3));
        List<Seat> seats = List.of(TestData.seatList.get(0), TestData.seatList.get(2), TestData.seatList.get(3));

        assertEquals(seats, cheatedSeatService.getReservedSeatsByScreening(TestData.screeningList.get(0)));
    }

    @Test
    void validateSeats() {
        assertTrue(cheatedSeatService.validateSeats(
                TestData.screeningList.get(0),
                TestData.seatList.subList(0,6)
        ));
        assertFalse(cheatedSeatService.validateSeats(
                TestData.screeningList.get(1),
                TestData.seatList.subList(3,7)
        ));
    }

    @Test
    void ensureNotReservated() {
        assertTrue(cheatedSeatService.ensureNotReserved(
                TestData.screeningList.get(0),
                TestData.seatList.subList(1,2)
        ));
        assertFalse(cheatedSeatService.ensureNotReserved(
                TestData.screeningList.get(0),
                TestData.seatList.subList(0,2)
        ));
    }

    @Test
    void ensureNoGapOccurs() {
        assertTrue(cheatedSeatService.ensureNoGapOccurs(
                TestData.screeningList.get(0),
                TestData.seatList.subList(4,6)
        ));
        assertFalse(cheatedSeatService.ensureNoGapOccurs(
                TestData.screeningList.get(0),
                TestData.seatList.subList(5,6)
        ));

        // rowNum == 3
        assertTrue(
                cheatedSeatService.ensureNoGapOccurs(
                        TestData.screeningList.get(2),
                        TestData.seatList.subList(8,10)
                ));
        assertFalse(
                cheatedSeatService.ensureNoGapOccurs(
                TestData.screeningList.get(2),
                TestData.seatList.subList(9,10)
        ));
    }
}