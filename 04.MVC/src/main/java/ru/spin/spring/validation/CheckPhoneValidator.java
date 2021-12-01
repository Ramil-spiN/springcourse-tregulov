package ru.spin.spring.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckPhoneValidator implements ConstraintValidator<CheckPhone, String> {

    private String startOfPhone;

    @Override
    public void initialize(CheckPhone checkPhone) {
        startOfPhone = checkPhone.value();
    }

    @Override
    public boolean isValid(String enteredValue, ConstraintValidatorContext constraintValidatorContext) {
        return enteredValue.startsWith(startOfPhone);
    }
}
