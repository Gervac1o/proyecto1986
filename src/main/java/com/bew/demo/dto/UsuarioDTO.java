package com.bew.demo.dto;

import java.io.Serializable;

public class UsuarioDTO implements Serializable {

    private static final long serialVersionUID = 321L;
    private Integer idUsuario;
    private String email;
    private String password;
    private Boolean tipoUsuario;
    private Boolean status;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(Boolean tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
