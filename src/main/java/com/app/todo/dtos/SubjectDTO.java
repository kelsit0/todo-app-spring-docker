package com.app.todo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubjectDTO {
    private String name;
    private String description;
    private List<Long> users_id=new ArrayList<>();
}
