package com.pixDBrest.bank.DAO;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = EmailValidator.class)
@Target({ElementType.FIELD , ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)

public @interface EmailValid {
   String message() default "Invalid Email";
   Class<?> [] groups() default {};
   Class<? extends Payload>[] payload() default {}; 
}