package com.pixDBrest.bank.DAO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class EmailValidator implements ConstraintValidator<EmailValid, String> {

    private static final String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    private Pattern pattern = Pattern.compile(EMAIL_PATTERN);

    @Override
    public void initialize(EmailValid constraintAnnotation) {
    }

    @Override  
    public boolean isValid(String email, ConstraintValidatorContext context) {
        return pattern.matcher(email).matches();
    }
    
}
