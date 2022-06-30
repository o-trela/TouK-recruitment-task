package pl.touk.recruitmenttask.ticketbookingapp;

import pl.touk.recruitmenttask.ticketbookingapp.model.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TestData {
    public static LocalDateTime testStartTime =
            LocalDateTime.of(
                    2000,
                    1,
                    1,
                    10,
                    0,
                    0
            );

    public static List<Movie> movieList = new ArrayList<>(
            List.of(
                    Movie.builder()
                            .title("test1")
                            .build(),
                    Movie.builder()
                            .title("test2")
                            .build()
            ));

    public static List<Seat> seatList = new ArrayList<>(
            List.of(
                    Seat.builder()
                            .id(1)
                            .seatNum(1)
                            .rowNum(1)
                            .build(),
                    Seat.builder()
                            .id(2)
                            .seatNum(2)
                            .rowNum(1)
                            .build(),
                    Seat.builder()
                            .id(3)
                            .seatNum(3)
                            .rowNum(1)
                            .build(),
                    Seat.builder()
                            .id(4)
                            .seatNum(4)
                            .rowNum(1)
                            .build(),
                    Seat.builder()
                            .id(5)
                            .seatNum(5)
                            .rowNum(1)
                            .build(),
                    Seat.builder()
                            .id(6)
                            .seatNum(6)
                            .rowNum(1)
                            .build(),
                    Seat.builder()
                            .id(127)
                            .seatNum(4)
                            .rowNum(1)
                            .build(),
                    // rowNum == 3 \/
                    Seat.builder()
                            .id(200)
                            .seatNum(1)
                            .rowNum(1)
                            .build(),
                    Seat.builder()
                            .id(201)
                            .seatNum(2)
                            .rowNum(1)
                            .build(),
                    Seat.builder()
                            .id(202)
                            .seatNum(3)
                            .rowNum(1)
                            .build()
            )
    );

    public static List<Room> roomList = new ArrayList<>(
            List.of(
                    Room.builder()
                            .id(1)
                            .seat(seatList.subList(0,6))
                            .build(),
                    Room.builder()
                            .id(2)
                            .seat(seatList.subList(6,7))
                            .build(),
                    Room.builder()
                            .id(3)
                            .seat(seatList.subList(7,10))
                            .build()
            )
    );

    public static List<Ticket> ticketList = new ArrayList<>(
            List.of(
                    Ticket.builder()
                            .id(1)
                            .seat(seatList.get(0))
                            .build(),
                    Ticket.builder()
                            .id(2)
                            .seat(seatList.get(2))
                            .build(),
                    Ticket.builder()
                            .id(3)
                            .seat(seatList.get(3))
                            .build(),
                    Ticket.builder()
                            .id(4)
                            .seat(seatList.get(7))
                            .build()
            )
    );

    public static Screening futureScreening = Screening.builder()
            .id(4)
            .movie(movieList.get(1))
            .startTime(LocalDateTime.now().plusDays(2))
            .room(roomList.get(2))
            .build();

    public static List<Screening> screeningList = new ArrayList<>(
            List.of(
                    Screening.builder()
                            .id(1)
                            .movie(movieList.get(0))
                            .startTime(testStartTime)
                            .room(roomList.get(0))
                            .ticket(ticketList.subList(0,3))
                            .build(),
                    Screening.builder()
                            .id(2)
                            .movie(movieList.get(1))
                            .startTime(testStartTime.plusHours(7))
                            .room(roomList.get(1))
                            .build(),
                    Screening.builder()
                            .id(3)
                            .movie(movieList.get(0))
                            .startTime(testStartTime.plusDays(1))
                            .room(roomList.get(2))
                            .ticket(ticketList.subList(3,4))
                            .build(),
                    futureScreening
            ));

    public static Reservation
            reservation = Reservation.builder()
                    .id(1)
                    .name("test")
                    .surname("test")
                    .ticket(ticketList.subList(0,3))
                    .screening(screeningList.get(0))
                    .build();
}
