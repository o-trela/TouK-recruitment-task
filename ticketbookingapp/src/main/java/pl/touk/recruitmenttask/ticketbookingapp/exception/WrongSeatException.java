package pl.touk.recruitmenttask.ticketbookingapp.exception;

public class WrongSeatException extends RuntimeException {
    public WrongSeatException(String message) {
        super(message);
    }
}
