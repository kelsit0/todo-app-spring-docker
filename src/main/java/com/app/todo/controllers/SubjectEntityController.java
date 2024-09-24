package com.app.todo.controllers;

import com.app.todo.dtos.SubjectDTO;
import com.app.todo.persistence.entities.SubjectEntity;
import com.app.todo.services.SubjectEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/subject")
public class SubjectEntityController {

    @Autowired
    private SubjectEntityService service;

    @GetMapping()
    public List<SubjectDTO> getAll() {
        return service.findAll();
    }
    @PostMapping()
    public SubjectDTO create(@RequestBody SubjectEntity entity) {
        return service.save(entity);
    }

}
