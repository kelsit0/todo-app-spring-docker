package com.app.todo.services;

import com.app.todo.dtos.SubjectDTO;
import com.app.todo.dtos.UserDTO;
import com.app.todo.persistence.entities.SubjectEntity;
import com.app.todo.persistence.entities.UserEntity;
import com.app.todo.persistence.repositories.SubjectEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectEntityService {


    @Autowired
    private SubjectEntityRepository subjectEntityRepository;


    public SubjectDTO save(SubjectEntity subjectEntity) {
        return toSubjectDTO(subjectEntityRepository.save(subjectEntity));
    }

    public List<SubjectDTO> findAll() {
        List<SubjectEntity> mylista=subjectEntityRepository.findAll();
        List<SubjectDTO> DTOs=new ArrayList<SubjectDTO>();
        for(SubjectEntity s:mylista) {
            DTOs.add(toSubjectDTO(s));
        }
        return DTOs;
    }

    ///Pendiente
    ///toca iterar la lista de usuarios y transformarlos a UserDTO
    ///PERO CON PROGRAMACION FUNCIONAL
    public SubjectDTO toSubjectDTO(SubjectEntity subject){
        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setName(subject.getName());
        subjectDTO.setDescription(subject.getDescription());
        if(subject.getUsers() !=null){
            for(UserEntity user : subject.getUsers()){
                subjectDTO.getUsers_id().add(user.getId());
            }
        }

        return subjectDTO;
    }


}
