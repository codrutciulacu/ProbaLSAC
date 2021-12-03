package com.codrut.probalsac.contact.validation;

import com.codrut.probalsac.contact.domain.Contact;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class ContactValidator {

    private final String EMAIL_REGEX = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$";
    private final Pattern VALID_EMAIL_ADDRESS_PATTERN = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);

    //TODO: Replace RuntimeException with custom exception
    public void validate(Contact contact) {
        if (!verifyShortStingSize(contact.getName()))
            throw new RuntimeException("The contact name is too long or too short");
        if (!verifyShortStingSize(contact.getEmail()))
            throw new RuntimeException("The contact email is too long or too short");
        if (verifyEmailFormat(contact.getEmail()))
            throw new RuntimeException("The contact email is the wrong format");
        if (!verifyLongStingSize(contact.getMessage()))
            throw new RuntimeException("The contact message is too long or too short");
    }

    private boolean verifyLongStingSize(String text) {
        return text.length() <= 5000 && !text.isEmpty();
    }

    private boolean verifyShortStingSize(String text) {
        return text.length() <= 50 && !text.isEmpty();
    }

    private boolean verifyEmailFormat(String email) {
        var matcher = VALID_EMAIL_ADDRESS_PATTERN.matcher(email);
        return matcher.find();
    }


}
