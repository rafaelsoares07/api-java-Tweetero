package com.twitero.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twitero.api.dto.UserDTO;
import com.twitero.api.model.User;
import com.twitero.api.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository repository;

    public User createNewUser(UserDTO data){
        return repository.save(new User(data));
    }

}
