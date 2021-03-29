package com.bew.demo.restController.auth;

import com.bew.demo.dto.UsuarioDTO;
import com.bew.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping(path = "/login")
    public void welcome(HttpServletResponse servletResponse) throws IOException {
        servletResponse.sendRedirect("/login.html");

    }

    @PostMapping(path = "/registration", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insert(@RequestBody UsuarioDTO user, HttpServletResponse servletResponse) throws IOException {
        usuarioService.saveUsuario (user);
        servletResponse.sendRedirect("/login.html");
    }
}