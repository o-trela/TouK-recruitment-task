# TouK-recruitment-task
Repository containing recruitment task from TouK for internship.

## **Build With**

- [JDK 17](https://www.oracle.com/java/technologies/downloads/#java17)
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

## **Notes**

