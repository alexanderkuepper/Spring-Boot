package com.example.demo.student;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudent() {
        return studentService.getStudent();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student, HttpServletResponse response) {
        try {
            studentService.addNewStudent(student);
        } catch (IllegalAccessException e) {
            response.setStatus(HttpServletResponse.SC_CONFLICT);
        }
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long id, HttpServletResponse response) {
        try {
            studentService.deleteStudent(id);
        } catch (IllegalStateException e) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable("studentId") Long id,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email) {
        studentService.updateStudent(id,name,email);
    }
}
