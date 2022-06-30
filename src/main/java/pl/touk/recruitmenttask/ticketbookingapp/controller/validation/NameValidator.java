package pl.touk.recruitmenttask.ticketbookingapp.controller.validation;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class NameValidator implements Validator<String> {
    private final Pattern validPattern;

    public NameValidator() {
        String REGEX = "^[\\p{Lu}][\\p{Ll}][\\p{Ll}]+$";
        validPattern = Pattern.compile(REGEX);
    }

    @Override
    public boolean isValid(String value) {
        if (value == null) return false;

        Matcher matcher = validPattern.matcher(value);
        return matcher.matches();
    }
}
