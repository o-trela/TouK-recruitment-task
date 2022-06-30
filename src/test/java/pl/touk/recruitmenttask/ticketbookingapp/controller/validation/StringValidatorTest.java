package pl.touk.recruitmenttask.ticketbookingapp.controller.validation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;

class StringValidatorTest {

    @Test
    void isValid() {
        NameValidator nameValidator = new NameValidator();
        SurnameValidator surnameValidator = new SurnameValidator();

        String validName = "Jacob";
        String invalidName = "JAcoB";

        assertTrue(nameValidator.isValid(validName));
        assertFalse(nameValidator.isValid(invalidName));

        String validSurname1 = "Super";
        String validSurname2 = "Super Mario";
        String invalidSurname1 = "SupeR";
        String invalidSurname2 = "Super MariO";
        String invalidSurname3 = "Super MariO Bros";

        assertTrue(surnameValidator.isValid(validSurname1));
        assertTrue(surnameValidator.isValid(validSurname2));
        assertFalse(surnameValidator.isValid(invalidSurname1));
        assertFalse(surnameValidator.isValid(invalidSurname2));
        assertFalse(surnameValidator.isValid(invalidSurname3));
    }

    @Test
    void threadsTest() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        NameValidator nameValidator = new NameValidator();
        SurnameValidator surnameValidator = new SurnameValidator();
        String name = "Name";
        String surname = "Surname Surname";

        Callable<Boolean> testTask1 = () -> {
            for (var i = 0; i < 1000; i++) {
                if (!nameValidator.isValid(name)) return false;
            }
            return true;
        };

        Callable<Boolean> testTask2 = () -> {
            for (var i = 0; i < 1000; i++) {
                if (!surnameValidator.isValid(surname)) return false;
            }
            return true;
        };

        List<Callable<Boolean>> tasksList = new ArrayList<>();
        tasksList.add(testTask1);
        tasksList.add(testTask2);

        List<Future<Boolean>> returns = service.invokeAll(tasksList);
        returns.forEach(booleanFuture -> {
            try {
                assertTrue(booleanFuture.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
    }
}