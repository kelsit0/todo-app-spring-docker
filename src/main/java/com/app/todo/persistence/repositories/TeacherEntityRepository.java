package com.app.todo.persistence.repositories;

import com.app.todo.persistence.entities.TeacherEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherEntityRepository extends CrudRepository<TeacherEntity, Long> {
    @Override
    List<TeacherEntity> findAll();
}
