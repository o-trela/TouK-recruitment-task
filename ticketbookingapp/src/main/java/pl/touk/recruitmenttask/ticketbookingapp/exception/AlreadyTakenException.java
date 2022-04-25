package pl.touk.recruitmenttask.ticketbookingapp.exception;

public class AlreadyTakenException extends RuntimeException {
    public AlreadyTakenException(String message) {
        super(message);
    }
}
