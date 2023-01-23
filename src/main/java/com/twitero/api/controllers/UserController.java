package com.twitero.api.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twitero.api.dto.UserDTO;
import com.twitero.api.model.User;
import com.twitero.api.services.UserService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/auth") //pode ter um caminho de rota ou não!

public class UserController {

    @Autowired 
    UserService service;

    @PostMapping("/sign-up")
    public User createUser(@RequestBody UserDTO data){
        return service.createNewUser(data);
    }


}
