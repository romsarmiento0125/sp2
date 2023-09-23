package rps.local.sp2.students;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class StudentService {

	private final StudentRepository studentRepository;

	// @Autowired
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}


    public List<Student> getStudents() {
		return studentRepository.findAll();
	}

	public Optional<Student> getStudentsById(Long id) {
		return studentRepository.findById(id);
	}

	// public Student save(Student student) {
	// 	return studentRepository.save(student);
	// }

    public void addNewStudent(Student student) {
		Optional<Student> studeOptional = studentRepository.findStudentByEmail(student.getEmail());
		if(studeOptional.isPresent()){
			throw new IllegalStateException("email taken");
		}
		studentRepository.save(student);
	}

	public void deleteStudent(Long id){
		boolean idExist = studentRepository.existsById(id);
		if(!idExist) {
			throw new IllegalStateException("Student with id " + id + " does not exist");
		}
		studentRepository.deleteById(id);
	}

	@Transactional
	public void updateStudent (Long id, String name, String email){
		Student student = studentRepository.findById(id).orElseThrow(() -> new 
			IllegalStateException("Student with id " + id + " does not exist")
		);
		
		if(name != null && name.length() > 0 &&  !Objects.equals(student.getFirstname(), name)) {
			student.setFirstname(name);
		}

		if(email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {
			Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
			if(studentOptional.isPresent()) {
				throw new IllegalStateException("Email already taken");
			}
		}

	}

}
