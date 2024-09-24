package com.app.todo.persistence.repositories;

import com.app.todo.persistence.entities.SubjectEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectEntityRepository extends CrudRepository<SubjectEntity, Long> {

    @Override
    List<SubjectEntity> findAll();

}
