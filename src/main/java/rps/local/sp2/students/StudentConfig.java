package rps.local.sp2.students;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student rom = new Student(
                "Rom Paulo", 
               "Sarmiento",
                "rom@email.com", 
                LocalDate.of(1990, 1, 25)
            );

            Student andrea = new Student(
                "Andrea", 
                 "Hermogenes", 
                "andrsdasea@email.com", 
                LocalDate.of(2000, 3, 27)
            );

            studentRepository.saveAll(
                List.of(rom, andrea)
            );
        };
    }
}
