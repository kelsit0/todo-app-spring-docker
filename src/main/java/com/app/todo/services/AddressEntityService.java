package com.app.todo.services;

import com.app.todo.dtos.AddressDTO;
import com.app.todo.persistence.entities.AddresEntity;
import com.app.todo.persistence.repositories.AddressEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressEntityService {


    @Autowired
    private AddressEntityRepository addressEntityRepository;

    @Autowired
    private UserEntityService userEntityService;

    public AddresEntity addAddress(AddresEntity addres) {
        return addressEntityRepository.save(addres);
    }

    public List<AddressDTO> getAllAddress() {
        return toDto(addressEntityRepository.findAll());
    }

    public List<AddressDTO> toDto(List<AddresEntity> lista){
        List<AddressDTO> dtos = new ArrayList<>();
        for(AddresEntity addres: lista){
            AddressDTO addressDTO = new AddressDTO();
            addressDTO.setId(addres.getId());
            addressDTO.setCity(addres.getCity());
            addressDTO.setStreet(addres.getStreet());
            addressDTO.setUser(userEntityService.userToDTO(addres.getUser()));
            dtos.add(addressDTO);
        }
        return dtos;
    }

}
