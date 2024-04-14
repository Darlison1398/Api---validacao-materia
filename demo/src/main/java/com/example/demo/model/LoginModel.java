package com.example.demo.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="usuario")
public class LoginModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String nome;

    @Column(length = 150)
    private String sobrenome;

    @Column(length = 200)
    private String email;

    @Column(length = 150)
    private String senha;

    public LoginModel(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    

    

    /*public void setSenha(String senha) {
        try {
            // Gerar um salt aleatório
            SecureRandom random = new SecureRandom();
            byte[] salt = new byte[16];
            random.nextBytes(salt);
            
            // Adicionar o salt à senha e gerar o hash
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] hashedPassword = md.digest(senha.getBytes());
            
            // Concatenar o salt com o hash e codificar em Base64
            byte[] combined = new byte[salt.length + hashedPassword.length];
            System.arraycopy(salt, 0, combined, 0, salt.length);
            System.arraycopy(hashedPassword, 0, combined, salt.length, hashedPassword.length);
            String hashedPasswordBase64 = Base64.getEncoder().encodeToString(combined);
            
            this.senha = hashedPasswordBase64;
        } catch (NoSuchAlgorithmException ex) {
            // Trate exceções aqui, se necessário
            ex.printStackTrace();
        }
    }*/

    /*protected boolean verificarSenha(String senha, String hashedPassword) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(senha.getBytes());
            String hashedInputPassword = Base64.getEncoder().encodeToString(hash);
            return hashedInputPassword.equals(hashedPassword);
        } catch (NoSuchAlgorithmException ex) {
            // Trate exceções aqui, se necessário
            ex.printStackTrace();
            return false;
        }
    }*/
    

    
    
    
}
