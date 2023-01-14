package ru.hogwarts.school.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.servise.StudentService;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        if (studentService.getStudent(id) != null) {
            return ResponseEntity.ok(studentService.getStudent(id));
        }
        return ResponseEntity.badRequest().build();
    }
    @GetMapping("/age{age}")
    public ResponseEntity<List<Student>> getStudentsByAge(@PathVariable int age){
        return ResponseEntity.ok(studentService.getStudentsByAge(age));
    }

    @PostMapping
    public Student createStudents(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @PutMapping
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        if (studentService.getStudent(student.getId()) != null) {
          return ResponseEntity.ok(studentService.updateStudent(student.getId(), student));
        }
        return ResponseEntity.badRequest().build();
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable Long id){
       Student example =  studentService.deleteStudent(id);
       if (example!=null){
           return ResponseEntity.ok(example);
       }
       return ResponseEntity.badRequest().build();
    }
}
