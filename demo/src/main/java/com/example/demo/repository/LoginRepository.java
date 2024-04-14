package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.LoginModel;

public interface LoginRepository extends JpaRepository <LoginModel, Long>{
    LoginModel findByEmail(String email);
}
