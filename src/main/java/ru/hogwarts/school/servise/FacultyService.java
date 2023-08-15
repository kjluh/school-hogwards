package ru.hogwarts.school.servise;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;

import java.util.HashMap;
import java.util.List;

@Service
public class FacultyService {
    private final HashMap<Long, Faculty> listFaculty = new HashMap<>();
    private Long count = 0L;

    public Faculty getFaculty(Long id){
        if (listFaculty.containsKey(id)){
            return listFaculty.get(id);
        }
        return null;
    }
    public Faculty createFaculty(Faculty faculty){
        faculty.setId(++count);
        listFaculty.put(faculty.getId(),faculty);
        return faculty;
    }
    public Faculty updateFaculty(Long id,Faculty faculty){
        listFaculty.put(id,faculty);
        return faculty;
    }
    public Faculty deleteFaculty(Long id){
        Faculty example = listFaculty.get(id);
        if (example != null){
            listFaculty.remove(id);
            return example;
        }
        return null;
    }
    public List<Faculty> getFacultyByColor(String color) {
        return listFaculty.values().stream().filter(e->e.getColor().equals(color)).toList();
    }
}
