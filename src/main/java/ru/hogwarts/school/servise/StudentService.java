package ru.hogwarts.school.servise;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;

import java.util.HashMap;
import java.util.List;

@Service
public class StudentService {
    private final HashMap<Long, Student> listStudents = new HashMap<>();
    private Long counter = 0L;


    public Student getStudent(Long id){
        if (listStudents.containsKey(id)){
            return listStudents.get(id);
        }
        return null;
    }
    public Student createStudent(Student student){
        student.setId(++counter);
        listStudents.put(student.getId(),student);
        return student;
    }
    public Student updateStudent(Long id, Student student){
       return listStudents.put(id,student);
    }
    public Student deleteStudent(Long id){
        Student example = listStudents.get(id);
        if (example != null){
            listStudents.remove(id);
            return example;
        }
        return null;
    }

    public List<Student> getStudentsByAge(int age) {
        return listStudents.values().stream().filter(e->e.getAge()==age).toList();
    }
}
