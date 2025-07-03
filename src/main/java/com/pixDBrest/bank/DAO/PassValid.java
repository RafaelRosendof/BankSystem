package com.pixDBrest.bank.DAO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class PassValid implements ConstraintValidator<ValidPass, String> {

    private static final String PASSWORD_PATTERN = "^(?=.*[A-Z])(?=.*[!@#$%^&*()_+\\-=[\\]{};':\"\\\\|,.<>/?]).+$";

    private Pattern pattern = Pattern.compile(PASSWORD_PATTERN);

    @Override
    public void initialize(ValidPass constraintAnnotation) {
    }

    @Override  
    public boolean isValid(String password, ConstraintValidatorContext context) {
        return pattern.matcher(password).matches();
    }
    
}
