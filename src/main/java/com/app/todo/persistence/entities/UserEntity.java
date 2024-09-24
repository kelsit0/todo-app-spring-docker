package com.app.todo.persistence.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    private String email;

    @Column(nullable = false)
    
    private String password;

    ///define la columna que sera la clave foranea
    @OneToOne(cascade = CascadeType.ALL)
    ///Al ser propietario crea la column
    @JoinColumn(name="addres_id", nullable = false)
    private AddresEntity addres;


    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private TeacherEntity teacher;

    @ManyToMany(mappedBy = "users")
    private List<SubjectEntity> subjects = new ArrayList<>(); ;

    public void addSubject(SubjectEntity subject) {
        this.subjects.add(subject); ///this propio es una list.add
        subject.getUsers().add(this); /// subject.getUsers retorna una list
    }
}

