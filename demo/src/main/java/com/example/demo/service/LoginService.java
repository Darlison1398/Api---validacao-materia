package com.example.demo.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.UserServiceException;
import com.example.demo.interfaceContrato.LoginInterface;
import com.example.demo.model.LoginModel;
import com.example.demo.repository.LoginRepository;

@Service
public class LoginService implements LoginInterface {

    private LoginRepository loginRepository;

    @Autowired
    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public LoginModel criarUsuario(LoginModel usuario) {
        try {
            return loginRepository.save(usuario);
        } catch (Exception e) {
            throw new UserServiceException("Erro ao tentar criar usuário", e);
        }
    }

    @Override
    public boolean fazerLogin(String email, String senha) {
        try {
            // Buscar o usuário pelo email
            LoginModel usuario = loginRepository.findByEmail(email);
    
            if (usuario != null ) {
                // Verificar se a senha fornecida coincide com a senha armazenada (considerando que a senha está em texto claro)
                if (usuario.getSenha().equals(senha)) {
                    return true; // Login bem-sucedido
                } else {
                    return false; // Senha incorreta
                }
            } else {
                return false; // Usuário não encontrado
            }
    
        } catch (Exception e) {
            throw new UserServiceException("Erro ao tentar fazer login", e);
        }
    }
    
    
    
    
    
}
