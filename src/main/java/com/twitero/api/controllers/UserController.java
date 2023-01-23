package com.twitero.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twitero.api.dto.UserDTO;
import com.twitero.api.model.User;
import com.twitero.api.services.UserService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api") //pode ter um caminho de rota ou não!

public class UserController {

}
