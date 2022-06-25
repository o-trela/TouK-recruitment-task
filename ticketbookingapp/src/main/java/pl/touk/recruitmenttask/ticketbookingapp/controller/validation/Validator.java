package pl.touk.recruitmenttask.ticketbookingapp.controller.validation;

public interface Validator<T> {
    boolean isValid(T object);
}
