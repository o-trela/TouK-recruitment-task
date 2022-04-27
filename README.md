# TouK-recruitment-task
Repository containing recruitment task from TouK for internship.

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
```shell
cd ticketbookingapp/
```
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
| `/reservation/{screening_id}?name={name}&surname={surname}` | Make reservation on particular screening. Provide name and surname of person who is making reservation and pass seats through request body. |

**Request body for reservation endpoint:**
```properties
 {
    "{seat_id}": "{ticket_type}",
    "{seat_id}": "{ticket_type}",
    (...)
 }
```

## Test cases

I prepared bash script to simulate test cases, but you are welcome to test it manually.

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
curl -X POST "http://localhost:8080/reservation/1?name={Touk}&surname={Touk}" -H "Content-Type: application/json" -d '{"20": "adult", "21": "child"}'
```

**To run my script (bash):**

Step into project directory.
```shell
cd ticketbookingapp/
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


## **Notes**

