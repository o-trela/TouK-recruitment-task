package pl.touk.recruitmenttask.ticketbookingapp.controller.validation;

import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
@Setter
public class StringValidator implements Validator<String> {

    private String regex;

    @Override
    public boolean isValid(String value) {
        if (value == null) return false;
        if (regex.isEmpty()) throw new IllegalStateException("Regex Not Known");

        Pattern validPattern = Pattern.compile(regex);

        Matcher matcher = validPattern.matcher(value);
        return matcher.matches();
    }
}
