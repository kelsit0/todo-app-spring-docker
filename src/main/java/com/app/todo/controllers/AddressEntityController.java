package com.app.todo.controllers;

import com.app.todo.dtos.AddressDTO;
import com.app.todo.persistence.entities.AddresEntity;
import com.app.todo.services.AddressEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/address")
public class AddressEntityController {

    @Autowired
    private AddressEntityService addressEntityService;

    @PostMapping()
    public AddresEntity addAddress(@RequestBody AddresEntity myAddress) {
        return addressEntityService.addAddress(myAddress);
    }

    @GetMapping()
    public List<AddressDTO> getAllAddresses() {
        return addressEntityService.getAllAddress();
    }
}
