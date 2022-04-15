CREATE TABLE Movie (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(128) NOT NULL,
    duration_time_min INT NOT NULL
);

CREATE TABLE Screening (
    id INT AUTO_INCREMENT PRIMARY KEY,
    start_time TIMESTAMP,
    id_movie INT NOT NULL,
    id_room INT NOT NULL
);

CREATE TABLE Room (
    id INT AUTO_INCREMENT PRIMARY KEY,
    no_seats INT NOT NULL
);

CREATE TABLE Seat (
    id INT AUTO_INCREMENT PRIMARY KEY,
    row_num INT NOT NULL,
    number INT NOT NULL,
    id_room INT NOT NULL
);

CREATE TABLE Reserved_seat (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_seat INT NOT NULL,
    id_reservation INT NOT NULL,
    id_screening INT NOT NULL
);

CREATE TABLE Reservation (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(64) NOT NULL,
    surname VARCHAR(128) NOT NULL,
    id_screening INT NOT NULL
);

ALTER TABLE Screening
    ADD CONSTRAINT screening_movie_FK
        FOREIGN KEY (id_movie) REFERENCES Movie(id);

ALTER TABLE Screening
    ADD CONSTRAINT screening_room_FK
        FOREIGN KEY (id_room) REFERENCES Room(id);

ALTER TABLE Seat
    ADD CONSTRAINT seat_room_FK
        FOREIGN KEY (id_room) REFERENCES Room(id);

ALTER TABLE Reserved_seat
    ADD CONSTRAINT reserved_seat_FK
        FOREIGN KEY (id_seat) REFERENCES Seat(id);

ALTER TABLE Reserved_seat
    ADD CONSTRAINT reserved_reservation_FK
        FOREIGN KEY (id_reservation) REFERENCES Reservation(id);

ALTER TABLE Reserved_seat
    ADD CONSTRAINT reserved_screening_FK
        FOREIGN KEY (id_screening) REFERENCES Screening(id);

ALTER TABLE Reservation
    ADD CONSTRAINT reservation_screening_FK
        FOREIGN KEY (id_screening) REFERENCES Screening(id);
