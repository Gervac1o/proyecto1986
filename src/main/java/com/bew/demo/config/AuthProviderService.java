package com.bew.demo.config;

import com.bew.demo.dao.UsuarioRepository;
import com.bew.demo.exception.EmptyResultException;
import com.bew.demo.model.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import java.util.ArrayList;
import java.util.Collection;

@Component
public class AuthProviderService implements AuthenticationProvider {

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        String login = auth.getName();
        String password = DigestUtils.md5DigestAsHex(auth.getCredentials().toString().getBytes());


        Usuario usuario = null;
        try {
            usuario = usuarioRepository.findByEmail(login).orElseThrow(() -> new EmptyResultException("Sin Resultados"));
        } catch (EmptyResultException e) {
            e.printStackTrace();
            throw new UsernameNotFoundException("Invalid user or password.");
        }

        if (usuario.getContraseña().equals(password)) {
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("USER"));
            return new UsernamePasswordAuthenticationToken(usuario, password, authorities);

        } else {


            throw new UsernameNotFoundException("Invalid user or password.");
        }
    }

    @Override
    public boolean supports(Class<?> auth) {
         return auth.equals(UsernamePasswordAuthenticationToken.class);
    }
}