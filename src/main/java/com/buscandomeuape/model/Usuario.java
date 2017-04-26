package com.buscandomeuape.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Usuario implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Long id;

    private String nome;

    private String email;
    
    private String perfil;

    @JsonIgnore
    private String senha;

    public Usuario(Long id, String nome, String email, String senha, String perfil) {
        this.id = id;
        this.nome = nome;
        this.setEmail(email);
        this.setSenha(senha);
        this.perfil = perfil;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
}
