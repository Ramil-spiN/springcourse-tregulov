package ru.spin.spring.exceptionhandling;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class EmployeeIncorrectData {
    private String info;
    private String otherInfo;
}
