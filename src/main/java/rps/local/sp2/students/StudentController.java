package rps.local.sp2.students;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController  {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    // @RequestMapping(path = "/{id}")
    // public Optional<Student> getStudentsById(HttpServletRequest request, @PathVariable Long id) {
    //     return studentService.getStudentsById(id);
    // }

    @RequestMapping(path = "/{id}")
    public Optional<Student> getStudentsById(@PathVariable Long id){
        return studentService.getStudentsById(id);
    }

    @PostMapping(path = "/add")
    public void registerNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "/remove/{id}")
    public void deleteStudent(@PathVariable("id") Long studentId){
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "/edit/{var}")
    public void updateStudent(
        @PathVariable("var") Long studentId,
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String email
    ){
        studentService.updateStudent(studentId,name, email);
    }


} 

    //  @RequestMapping(path = "/upsert", method = (RequestMethod.POST))
    // public void upsert(StudentRepository studentRepository) {

    //     Student andrea = new Student(
    //             "Rom Sarmiento", 
    //             "andrsdfsdea@email.com", 
    //             LocalDate.of(2009, 9, 07)
    //         );
    //     // bean = new Student(15L,"Example", "example.com", LocalDate.of(2008, 9, 21));
    //      studentRepository.save(andrea);
    //     // return "success";
    // }
                                                                               

                        