package com.app.todo.controllers;

import com.app.todo.dtos.UserDTO;
import com.app.todo.persistence.entities.StudentEntity;
import com.app.todo.persistence.entities.SubjectEntity;
import com.app.todo.persistence.entities.TeacherEntity;
import com.app.todo.persistence.entities.UserEntity;
import com.app.todo.services.UserEntityService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.Subject;
import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserEntityController {

    @Autowired
    private  UserEntityService userEntityService;

    @GetMapping()
    public List<UserDTO> getUsers(){
        return userEntityService.getUsers();
    }

    @PostMapping()
    public UserDTO createUser(@RequestBody UserEntity user){
        return userEntityService.addUser(user);
    }

    @GetMapping("/{username}")
    public UserDTO getUser(@PathVariable String username){
        return userEntityService.getUserByUsername(username);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userEntityService.deleteUser(id);
    }

    @PutMapping("/{userId}/subjects/{subjectId}")
    public UserDTO addSubject(@PathVariable Long userId, @PathVariable Long subjectId){
        return userEntityService.addSubject(userId, subjectId);
    }


}
