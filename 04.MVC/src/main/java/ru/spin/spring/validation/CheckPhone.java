package ru.spin.spring.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckPhoneValidator.class)
public @interface CheckPhone {
    public String value() default "123";
    public String message() default "Wrong phone format";

    public Class<?>[] groups() default {};
    public Class<? extends Payload>[] payload() default {};
}
