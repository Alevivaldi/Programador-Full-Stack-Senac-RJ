package br.com.aplrm.aplrm.dto;

import br.com.aplrm.aplrm.entities.User;
import jakarta.persistence.Column;

import java.time.LocalDate;

public class UserDTO {

    private Integer id;
    private String nome;


    private String email;

    private String telefone;
    private LocalDate dataNascimento;
    private String senha;

    public UserDTO(User x) {
    }


    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getSenha() {
        return senha;
    }
}
