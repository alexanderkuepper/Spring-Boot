package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student alex = new Student(
                    "Alex",
                    "alex@email.de",
                    LocalDate.of(2000, Month.APRIL, 2));
            Student leo = new Student(
                    "Leo",
                    "Leo@email.de",
                    LocalDate.of(2000, Month.APRIL, 2));

            repository.saveAll(List.of(alex, leo));
        };

    }
}
