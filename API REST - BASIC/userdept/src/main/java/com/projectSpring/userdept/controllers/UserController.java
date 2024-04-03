package com.projectSpring.userdept.controllers;

import com.projectSpring.userdept.entities.User;
import com.projectSpring.userdept.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
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

    //Buscando e Retornando um Usuário pelo id
    @GetMapping(value = "/{id}")
    public User findById(@PathVariable Long id){
        User result = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));
        return result;
    }

    //Adicionando um Usuário no banco de dados
    @PostMapping
    public User insert(@RequestBody User user){
        User result = repository.save(user);
        return result;
    }

    // Atualizando um Usuário no banco de dados
    @PutMapping(value = "/{id}")
    public User update(@PathVariable Long id, @RequestBody User user) {
        User existingUser = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());

        User updatedUser = repository.save(existingUser);
        return updatedUser;
    }

}
