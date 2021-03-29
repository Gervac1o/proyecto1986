package com.bew.demo.restController.auth;

import com.bew.demo.dto.UsuarioDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/auth/")
public class AuthController {

    @PostMapping(path = "/home", consumes = "application/json")
    ResponseEntity<?> login(@RequestBody UsuarioDTO user) {
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/login")
    public void welcome(HttpServletResponse servletResponse) throws IOException {
        servletResponse.sendRedirect("/login.html");

    }

    @PostMapping(path = "/registration")
    @ResponseBody
    public ResponseEntity<UsuarioDTO> insert(@RequestBody UsuarioDTO user) {

        return ResponseEntity.ok(user);
    }

    @PostMapping(path = "/logout")
    @ResponseBody
    public void logout() {

       String n = "sdasd";
    }
    /*@GetMapping(value="/admin/home")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByUserName(auth.getName());
        modelAndView.addObject("userName", "Welcome " + user.getUserName() + "/" + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
        modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
        modelAndView.setViewName("admin/home");
        return modelAndView;
    }*/
}