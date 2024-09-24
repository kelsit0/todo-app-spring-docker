package com.app.todo.controllers;

import com.app.todo.dtos.TeacherDTO;
import com.app.todo.persistence.entities.TeacherEntity;
import com.app.todo.services.TeacherEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/teacher")
public class TeacherEntityController {

    @Autowired
    private TeacherEntityService teacherEntityService;

    @GetMapping()
    public List<TeacherDTO> getTeachers(){
        return teacherEntityService.findAll();
    }

    @PostMapping()
    private TeacherEntity addTeacher(@RequestBody TeacherEntity myTeacher){
        return teacherEntityService.save(myTeacher);
    }
}
