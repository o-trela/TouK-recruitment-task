# Ticket Booking App
Repository containing cinema ticket booking application REST API which was created during recruitment for TouK.

## **Build With**

- [JDK 17](https://www.oracle.com/java/technologies/downloads/#java17) (**requirement**)
- [Spring Boot 2](https://spring.io/projects/spring-boot)
- [Spring Framework 5](https://spring.io/projects/spring-framework)

## **Description**
This project is REST API which imitates ticket booking app for cinema and contains features like:
- Screening search
- Ticket booking

## **Running the application locally**

To run the application open the terminal in the directory in which you cloned the repository and enter the project folder.
Depending on the operating system you are working on choose appropriate command.
- Windows:
```shell
.\gradlew bootRun
```
- Mac or Linux:
```shell
./gradlew bootRun
```
The application should be running now.

## Endpoints
This REST API contains 4 endpoints:
| URL                                | Description                              |
| ---------------------------------- | ---------------------------------------- |
| `/screenings`                      | Retrieve info about all screenings.      |
| `/screenings?start={start_time}`   | Retrieve info about all screenings starting after given time until the end of the day. |
| `/screening/{screening_id}`        | Retrieve info about particular screening (title, room number, seats available). |
| `/reservation/{screening_id}` | Make reservation on particular screening. Provide name and surname of person who is making reservation and pass seats through request body. |

**Request body for reservation endpoint:**
```properties
{
  "name": "{name}",
  "surname": "{surname}",
  "seats": {
    "{seat_id}": "{ticket_type}",
    "{seat_id}": "{ticket_type}",
    (...)
  }
}
```

**Ticket types:** 
- `ADULT`
- `STUDENT`
- `CHILD`

## Use case diagram

![image](https://user-images.githubusercontent.com/79324178/165572722-65c98afc-2da0-4d41-aa0c-92b7c87f8677.png)

## Reservation assumptions

- Name must be one word starting with capital letter (only first letter can be capital).
- Surname may consist of two words beginning with a capital letter and separated with one whitespace.
- Both name and surname must be at least three characters long.
- Seats can be booked at latest 15 minutes before the screening begins.
- Seats are devided to rows and there cannot be a single place left over between two already reserved places.
- Booked seat cannot be reserved again.
- When booking seats you are forced to choose at least one.

## Test cases

I prepared bash script to simulate test cases (**curl is required**), but you are welcome to test it manually.

Port 8080 is set by default.

Retrive all screenings:
```shell
curl -X GET "http://localhost:8080/screenings"
```

Retrive all screenings after provided date:
```shell
curl -X POST "http://localhost:8080/screenings?start=2022-04-27T20:00:00"
```

Retrive screening info:
```shell
curl -X GET "http://localhost:8080/screenings/1"
```

Make reservation:
```shell
curl -X POST "http://localhost:8080/reservation/1?name=Touk&surname=Touk" -H "Content-Type: application/json" -d '{"20": "adult", "21": "child"}'
```

**To run my script (bash):**

Step into project directory and <code>test_cases</code> folder.
```shell
cd test_cases
```

Successful test cases:
```shell
./success_demo
```

Failed test cases:
```shell
./failture_demo
```

Script takes additional parameter for PORT number:
```shell
./success_demo 8000
```

## Database

Database is build on H2 system with Hibernate.

Access to database is gained with the help of Spring JPA.

### Database structure

![Database ER diagram (crow's foot)](https://user-images.githubusercontent.com/79324178/165573650-0a2659f7-132f-4f98-b126-fe795f6f2b9a.jpeg)

## **Notes**
Test data is automatically initialized to the system and may expire over the time.
