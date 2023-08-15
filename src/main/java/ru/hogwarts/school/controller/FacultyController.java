package ru.hogwarts.school.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.servise.FacultyService;

import java.util.List;

@RestController
@RequestMapping("faculty")
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Faculty> getFaculty(@PathVariable Long id) {
        Faculty example = facultyService.getFaculty(id);
        if (example != null) {
            return ResponseEntity.ok(example);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    @GetMapping("color/{color}")
    public List<Faculty> getFacultyByColor(@PathVariable String color){
        return facultyService.getFacultyByColor(color);
    }

    @PostMapping
    public ResponseEntity<Faculty> createFaculty(@RequestBody Faculty faculty) {
        return ResponseEntity.ok(facultyService.createFaculty(faculty));
    }
    @PutMapping()
    public ResponseEntity<Faculty> updateFaculty(@RequestBody Faculty faculty){
        Faculty example = facultyService.getFaculty(faculty.getId());
        if (example!=null){
            facultyService.updateFaculty(faculty.getId(), faculty);
            return ResponseEntity.ok(faculty);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Faculty> deleteFaculty(@PathVariable Long id){
        Faculty example = facultyService.deleteFaculty(id);
        if (example!=null){
            facultyService.deleteFaculty(id);
            return ResponseEntity.ok(example);
        }
        return ResponseEntity.badRequest().build();
    }
}
