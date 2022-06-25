package pl.touk.recruitmenttask.ticketbookingapp.exception;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}
