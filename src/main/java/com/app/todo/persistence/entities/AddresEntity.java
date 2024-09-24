package com.app.todo.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "addres")
public class AddresEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String street;

    @Column(nullable=false)
    private String city;

    ///relacion
    ///@OneToOne: Define una relación uno a uno.
    // no es propietario, solo especifica que su _id sera usada con mapped
    @OneToOne(mappedBy = "addres")
    @JsonIgnore
    private  UserEntity user;
}
