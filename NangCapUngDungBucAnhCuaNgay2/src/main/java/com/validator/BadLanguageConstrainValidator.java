package com.validator;

import com.annotation.BadLanguage;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BadLanguageConstrainValidator implements ConstraintValidator<BadLanguage,String> {

    @Override
    public void initialize(BadLanguage constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean result= true;
        if (value== null) {
            return result;
        }else {
            List<String> badWords= new ArrayList<>();
            badWords.add("fuck");
            badWords.add("cunt");
            badWords.add("dick");
            badWords.add("pussy");
            badWords.add("nigga");

            String[] feedBackArray= value.split(" ");
            List<String> feedBack= Arrays.asList(feedBackArray);
            for (String badWord : badWords){
                if (feedBack.contains(badWord)) {
                    result= false;
                    break;
                }
            }
        }
        return result;
    }
}
