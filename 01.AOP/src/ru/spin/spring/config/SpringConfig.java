package ru.spin.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("ru.spin.spring")
@EnableAspectJAutoProxy
public class SpringConfig {
}
