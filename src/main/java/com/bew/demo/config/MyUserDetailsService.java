package com.bew.demo.config;

import com.bew.demo.dto.UsuarioDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) {
        UsuarioDTO user = new UsuarioDTO();
        user.setEmail(userName);
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("USER"));
        return buildUserForAuthentication(user, authorities);
    }

    private UserDetails buildUserForAuthentication(UsuarioDTO user, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getContraseña(),
                true, true, true, true, authorities);
    }
}