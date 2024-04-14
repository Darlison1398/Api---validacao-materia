package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.LoginModel;
import com.example.demo.service.LoginService;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "http://localhost:5173")
public class LoginController {

    private LoginService loginService;
    
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/create")
    public LoginModel createUser(@RequestBody LoginModel loginModel) {
        return loginService.criarUsuario(loginModel);
    }

    @PostMapping("/acessar")
    public ResponseEntity<?> acessar(@RequestBody LoginModel loginModel){
        String email = loginModel.getEmail();
        String senha = loginModel.getSenha();
        
        // Verificar se o email e a senha foram fornecidos
        if (email == null || email.isEmpty() || senha == null || senha.isEmpty()) {
            return ResponseEntity.badRequest().body("Email e senha são obrigatórios.");
        }
        
        // Chamar o serviço de login
        boolean loginSuccessful = loginService.fazerLogin(email, senha);
        
        if (loginSuccessful) {
            return ResponseEntity.ok().build(); // Retornar código 200 OK se o login for bem-sucedido
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas."); // Retornar código 401 Unauthorized se as credenciais forem inválidas
        }

    }


}
