package com.projectSpring.userdept.controllers;

import com.projectSpring.userdept.entities.User;
import com.projectSpring.userdept.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserRepository repository;

    //Buscando e retornando todos os Usuarios do banco de dados
    @GetMapping
    public List<User> findAll(){
        List<User> result = repository.findAll();
        return result;
    }

    //Buscando e Retornando um Usuario pelo id
    @GetMapping(value = "/{id}")
    public User findById(@PathVariable Long id){
        User result = repository.findById(id).get();
        return result;
    }

    //Adicionando um Usuário no banco de dados
    @PostMapping
    public User insert(@RequestBody User user){
        User result = repository.save(user);
        return result;
    }

}
