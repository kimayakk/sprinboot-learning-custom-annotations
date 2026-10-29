package com.Learn.CreateCustomAnnotation.Configs;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class checkPrimeNumberValidator implements ConstraintValidator<checkPrimeNumber,Integer> {

    @Override
    public boolean isValid(Integer inoutNo,ConstraintValidatorContext constraintValidatorContext)
    {
        if (inoutNo <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(inoutNo); i++) {
            if (inoutNo % i == 0) {
                return false;
            }
        }
        return true;
    }
}
