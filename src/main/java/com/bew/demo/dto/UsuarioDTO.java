package com.bew.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
public class UsuarioDTO implements Serializable {

    private static final long serialVersionUID = 321L;
    private Integer idUsuario;
    private String email;
    private String password;
    private Boolean tipoUsuario;
    private Boolean status;

}
