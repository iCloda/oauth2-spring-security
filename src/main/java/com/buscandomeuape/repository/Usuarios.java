package com.buscandomeuape.repository;

import java.sql.ResultSet;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.buscandomeuape.model.Usuario;

@Repository
public class Usuarios {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Transactional(readOnly=true)
    public Optional<Usuario> findByEmail(String email) {
        return jdbcTemplate.query("SELECT id, nome, email, senha, perfil FROM usuario WHERE email = ?", new Object[] { email }, 
                (ResultSet rs) -> { 
                    return rs.next() ? Optional.ofNullable(new Usuario(rs.getLong("id"), rs.getString("nome"), 
                                                                        rs.getString("email"), rs.getString("senha"), 
                                                                         rs.getString("perfil"))) 
                                      : Optional.empty();
                });
    }
}
