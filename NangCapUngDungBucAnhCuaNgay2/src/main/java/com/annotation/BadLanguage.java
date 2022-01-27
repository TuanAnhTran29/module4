package com.annotation;

import com.validator.BadLanguageConstrainValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = BadLanguageConstrainValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface BadLanguage {
    String message() default "{BadLanguage} is not accepted";

    Class<?>[] group() default {};

    Class<? extends Payload>[] payload() default {};
}
