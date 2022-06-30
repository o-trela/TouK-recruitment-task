package pl.touk.recruitmenttask.ticketbookingapp.controller.validation;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class SurnameValidator implements Validator<String> {
    private final Pattern validPattern;

    public SurnameValidator() {
        String REGEX = "^[\\p{Lu}][\\p{Ll}][\\p{Ll}]+([ ][\\p{Lu}][\\p{Ll}][\\p{Ll}]+)?$";
        validPattern = Pattern.compile(REGEX);
    }

    @Override
    public boolean isValid(String value) {
        if (value == null) return false;

        Matcher matcher = validPattern.matcher(value);
        return matcher.matches();
    }
}
