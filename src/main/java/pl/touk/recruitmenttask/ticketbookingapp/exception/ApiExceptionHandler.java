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

    @ExceptionHandler(value = {BadRequestException.class})
    public ResponseEntity<Object> handleWrongSeatException(BadRequestException ex) {
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        ApiException apiEx = new ApiException(
                ex.getMessage(),
                badRequest,
                ZonedDateTime.now()
        );
        return new ResponseEntity<>(apiEx, badRequest);
    }

    @ExceptionHandler(value = {TooLateException.class})
    public ResponseEntity<Object> handleTooLateException(TooLateException ex) {
        HttpStatus methodNotAllowed = HttpStatus.GONE;
        ApiException apiEx = new ApiException(
                ex.getMessage(),
                methodNotAllowed,
                ZonedDateTime.now()
        );
        return new ResponseEntity<>(apiEx, methodNotAllowed);
    }

    @ExceptionHandler(value = {AlreadyTakenException.class})
    public ResponseEntity<Object> handleAlreadyTakenException(AlreadyTakenException ex) {
        HttpStatus conflict = HttpStatus.CONFLICT;
        ApiException apiEx = new ApiException(
                ex.getMessage(),
                conflict,
                ZonedDateTime.now()
        );
        return new ResponseEntity<>(apiEx, conflict);
    }
}
