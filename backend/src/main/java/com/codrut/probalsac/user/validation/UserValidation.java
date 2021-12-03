package com.codrut.probalsac.user.validation;

import com.codrut.probalsac.user.controller.dto.RegisterUserDTO;
import com.codrut.probalsac.user.controller.dto.UserDTO;
import com.codrut.probalsac.user.domain.User;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class UserValidation {
    private final String EMAIL_REGEX = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$";
    private final Pattern VALID_EMAIL_ADDRESS_PATTERN = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);

    public void validate(RegisterUserDTO dto) {
        if (!(dto.firstname.length() <= 50 && !dto.firstname.isEmpty()))
            throw new RuntimeException("The firstname is too short or to long!");
        if (!(dto.lastname.length() <= 50 && !dto.lastname.isEmpty()))
            throw new RuntimeException("The lastname is too short or to long!");
        if (!(dto.password.length() <= 50 && !dto.password.isEmpty()))
            throw new RuntimeException("The password is not valid!");
        if (!(dto.password.equals(dto.confirm_password)))
            throw new RuntimeException("The password is not confirmed!");
        if (!verifyEmailFormat(dto.email))
            throw new RuntimeException("The email is not valid!");
    }

    private boolean verifyEmailFormat(String email) {
        var matcher = VALID_EMAIL_ADDRESS_PATTERN.matcher(email);
        return matcher.find();
    }
}
