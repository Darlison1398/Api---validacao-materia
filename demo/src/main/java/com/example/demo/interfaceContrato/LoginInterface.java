package com.example.demo.interfaceContrato;

import com.example.demo.model.LoginModel;

public interface LoginInterface {
    LoginModel criarUsuario(LoginModel usuario);
    boolean fazerLogin(String email, String senha);
}
