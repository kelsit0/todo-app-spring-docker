package com.app.todo.persistence.repositories;

import com.app.todo.persistence.entities.AddresEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressEntityRepository extends CrudRepository<AddresEntity, Long> {

    AddresEntity findByCity(String city);

    @Override
    List<AddresEntity> findAll();

}
