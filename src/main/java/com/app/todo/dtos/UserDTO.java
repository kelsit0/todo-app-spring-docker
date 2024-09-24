package com.app.todo.dtos;


import com.app.todo.persistence.entities.TeacherEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private TeacherDTO teacher;
    private List<Long> subjectIds;
}
