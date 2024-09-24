package com.app.todo.persistence.repositories;

import com.app.todo.persistence.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserEntityRepository extends CrudRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
    @Override
    List<UserEntity> findAll();
}
