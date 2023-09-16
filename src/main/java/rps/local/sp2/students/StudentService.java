package rps.local.sp2.students;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StudentService {
    public List<Student> getStudents() {
		return List.of(
			new Student(
				1L, 
				"rom", 
				"rom@email.com", 
				LocalDate.of(2000, Month.JANUARY, 5), 
				22)
		);
	}
}
