package com.pixDBrest.bank.DAO;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Constraint(validatedBy = PassValid.class)
@Target({ElementType.FIELD , ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)

public @interface ValidPass {
   String message() default "Invalid Password";
   Class<?> [] groups() default {};
   Class<? extends Payload>[] payload() default {}; 
}
