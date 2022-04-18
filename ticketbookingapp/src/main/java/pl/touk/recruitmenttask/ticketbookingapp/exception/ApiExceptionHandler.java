package pl.touk.recruitmenttask.ticketbookingapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {ResourceNotFoundException.class})
    public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex) {
        HttpStatus notFound = HttpStatus.NOT_FOUND;
        ApiException apiEx = new ApiException(
                ex.getMessage(),
                notFound,
                ZonedDateTime.now()
        );
        return new ResponseEntity<>(apiEx, notFound);
    }

    @ExceptionHandler(value = {WrongSeatException.class})
    public ResponseEntity<Object> handleWrongSeatException(WrongSeatException ex) {
        HttpStatus notFound = HttpStatus.BAD_REQUEST;
        ApiException apiEx = new ApiException(
                ex.getMessage(),
                notFound,
                ZonedDateTime.now()
        );
        return new ResponseEntity<>(apiEx, notFound);
    }

    @ExceptionHandler(value = {TooLateException.class})
    public ResponseEntity<Object> handleTooLateException(TooLateException ex) {
        HttpStatus notFound = HttpStatus.I_AM_A_TEAPOT;
        ApiException apiEx = new ApiException(
                ex.getMessage(),
                notFound,
                ZonedDateTime.now()
        );
        return new ResponseEntity<>(apiEx, notFound);
    }
}
