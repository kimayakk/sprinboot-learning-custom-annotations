package com.Learn.CreateCustomAnnotation.Configs;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Pattern;

public class checkPasswordCriteriaValidator implements ConstraintValidator<checkPasswordCriteria,String> {
    @Override
    public boolean isValid(@Digits(integer = 10, fraction = 0) String value, ConstraintValidatorContext context) {

        boolean hasUpperChar=false;
        boolean hasLowerChar=false;
        boolean hasSpecialChar=false;
        for(char ch: value.toCharArray())
        {
            if (Character.isUpperCase(ch)) {
                hasUpperChar = true;
            }

            if (Character.isLowerCase(ch)) {
                hasLowerChar = true;
            }

            if (!Character.isLetterOrDigit(ch)) {
                hasSpecialChar = true;
            }
        }

        return hasLowerChar && hasUpperChar && hasSpecialChar;
    }
}
