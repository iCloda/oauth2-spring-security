package com.buscandomeuape.service;

import java.util.HashSet;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.buscandomeuape.model.Usuario;
import com.buscandomeuape.model.UsuarioSistema;
import com.buscandomeuape.repository.Usuarios;
import com.buscandomeuape.service.exception.UsuarioNaoEncontradoException;

@Service
public class AppUserDetailsService implements UserDetailsService {
    
    @Autowired
    private Usuarios usuarios;
    
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Usuario> usuarioOptional = usuarios.findByEmail(email);
        Usuario usuario = usuarioOptional.orElseThrow(() -> new UsuarioNaoEncontradoException());
        return new UsuarioSistema(usuario, new HashSet<>());
    }

}
