package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.example.demo.exception.UserServiceException;
import com.example.demo.interfaceContrato.UserInterface;
import com.example.demo.model.UserModel;
import com.example.demo.repository.UserRepository;



@Service
public class UserService implements UserInterface {

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserModel> getAllUsers() {
        try {
            return userRepository.findAll();
        } catch (Exception e) {
            throw new UserServiceException("Erro ao tentar buscar todos os usuários", e);
        }
    }

    @Override
    public UserModel getUserById(Long id) {
        try {
            return userRepository.findById(id).orElse(null);
        } catch (Exception e) {
            throw new UserServiceException("Erro ao tentar buscar usuário pelo id", e);
        }
    }

    @Override
    public UserModel saveUser(UserModel user) {
        try {
            return userRepository.save(user);
        } catch (DataAccessException e) {
            throw new UserServiceException("Erro ao tentar salvar usuário no banco" ,e);

        }
    }

    @Override
    public UserModel updateUser(Long id, UserModel newUser) {
        if (userRepository.existsById(id)) { // Corrigido para usar o parâmetro id
            UserModel user = userRepository.findById(id).get();
            user.setName(newUser.getName());
            user.setOrdem(newUser.getOrdem());
            user.setDescricao(newUser.getDescricao());;
            user.setNivelimportancia(newUser.getNivelimportancia());
            return userRepository.save(user);
        } else {
            throw new UserServiceException("Erro ao tentar editar usuário");
        }
        
    }

    @Override
    public UserModel deleteUser(Long id) {
        if (userRepository.existsById(id)){
            UserModel user = userRepository.findById(id).get();
            userRepository.delete(user);
            return user;
        } else {
            throw new UserServiceException("Erro ao tentar apagar usuário");
        }
    }

}
