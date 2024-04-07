package com.example.demo.interfaceContrato;

import java.util.List;

import com.example.demo.model.UserModel;



public interface UserInterface {

    List<UserModel> getAllUsers();
    UserModel getUserById(Long id);
    UserModel saveUser(UserModel user);
    UserModel updateUser(Long id, UserModel newUser);
    UserModel deleteUser(Long id);
    
}
