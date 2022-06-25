package pl.touk.recruitmenttask.ticketbookingapp.exception;

public class TooLateException extends RuntimeException {
    public TooLateException(String message) {
        super(message);
    }
}
