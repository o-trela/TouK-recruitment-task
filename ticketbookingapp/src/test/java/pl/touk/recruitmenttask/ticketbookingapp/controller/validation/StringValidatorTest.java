package pl.touk.recruitmenttask.ticketbookingapp.controller.validation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringValidatorTest {

    @Test
    void isValid() {
        StringValidator validator = new StringValidator();

        String validName = "Jacob";
        String invalidName = "JAcoB";
        validator.setRegex("^[\\p{Lu}][\\p{Ll}][\\p{Ll}]+$");

        assertTrue(validator.isValid(validName));
        assertFalse(validator.isValid(invalidName));

        String validSurname1 = "Super";
        String validSurname2 = "Super Mario";
        String invalidSurname1 = "SupeR";
        String invalidSurname2 = "Super MariO";
        String invalidSurname3 = "Super MariO Bros";
        validator.setRegex("^[\\p{Lu}][\\p{Ll}][\\p{Ll}]+([ ][\\p{Lu}][\\p{Ll}][\\p{Ll}]+)?$");

        assertTrue(validator.isValid(validSurname1));
        assertTrue(validator.isValid(validSurname2));
        assertFalse(validator.isValid(invalidSurname1));
        assertFalse(validator.isValid(invalidSurname2));
        assertFalse(validator.isValid(invalidSurname3));
    }
}