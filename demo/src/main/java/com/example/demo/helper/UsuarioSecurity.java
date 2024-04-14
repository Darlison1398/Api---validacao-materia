package com.example.demo.helper;
import org.mindrot.jbcrypt.BCrypt;

public class UsuarioSecurity {
    public static String hashSenha(String senha) {
        String salt = BCrypt.gensalt(12);
        return BCrypt.hashpw(senha, salt); 
    }

    public static boolean verificarSenha(String senhaCandidata, String senhaHash) {
        return BCrypt.checkpw(senhaCandidata, senhaHash);
    }
}
