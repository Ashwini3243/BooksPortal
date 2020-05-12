package com.nendrasys.validations;

import com.nendrasys.model.RegistrationModel;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

public class RegistrationValidation implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {

        return RegistrationModel.class.isAssignableFrom(aClass);

    }

    @Override
    public void validate(Object o, Errors errors) {
             ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "id.empty");
        ValidationUtils.rejectIfEmpty(errors,"name","name.empty");
        ValidationUtils.rejectIfEmpty(errors, "age", "age.empty");
        ValidationUtils.rejectIfEmpty(errors, "email", "email.empty");
        ValidationUtils.rejectIfEmpty(errors, "address", "address.empty");
        ValidationUtils.rejectIfEmpty(errors, "country", "country.empty");
        ValidationUtils.rejectIfEmpty(errors,"username","username.empty");
        ValidationUtils.rejectIfEmpty(errors, "password", "password.empty");
        ValidationUtils.rejectIfEmpty(errors,"role","role.empty");
        ValidationUtils.rejectIfEmpty(errors,"enabled","enabled.empty");
        RegistrationModel user = (RegistrationModel) o;

        Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
                Pattern.CASE_INSENSITIVE);
        if (!(pattern.matcher(user.getEmail()).matches())) {
            errors.rejectValue("email", "user.email.invalid");
            System.out.println("in validation 4");
        }
    }
}
