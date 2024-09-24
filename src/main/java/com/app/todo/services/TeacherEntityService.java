package com.app.todo.services;

import com.app.todo.dtos.TeacherDTO;
import com.app.todo.persistence.entities.TeacherEntity;
import com.app.todo.persistence.repositories.TeacherEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherEntityService {

    @Autowired
    private TeacherEntityRepository teacherEntityRepository;

    public TeacherEntity save(TeacherEntity teacherEntity) {
        return teacherEntityRepository.save(teacherEntity);
    }
    public List<TeacherDTO> findAll() {
        return toDTO(teacherEntityRepository.findAll());
    }

    public List<TeacherDTO> toDTO (List<TeacherEntity> lista){
        List<TeacherDTO> dtos = new ArrayList<TeacherDTO>();
        for (TeacherEntity t: lista){
            TeacherDTO dto = new TeacherDTO();
            dto.setId(t.getId());
            dto.setName(t.getName());
            dto.setEmail(t.getEmail());
            dtos.add(dto);
        }
        return dtos;
    }
}
