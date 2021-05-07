import React from 'react';
import axios from 'axios';
import { Redirect,Link } from 'react-router-dom';
import md5 from 'md5';

class RecuperacionContraseña extends React.Component{

    cambioRef = React.createRef();



    state = {
        usuario:{},
        recuperar:{},
        contraseña: null,
        statusContraseña: null,
        status: null,
        email: "",
        clase:this.props.className
    }

    changeState = () =>{
        this.setState({
            recuperar:{
                idUsuario: this.props.id,
                email: this.state.usuario.email,
                password: md5("p4SS"+this.props.id+"dEYAe"),
                tipoUsuario: "false"
            }
        });
        
    }//Fin de changeState
  componentWillMount = () =>{
    this.getUsuario();
    this.setState({
        contraseña: "true"
    });
    console.log(this.props.className)
  }
    getUsuario = () =>{
        axios.get("usuario/find/"+this.props.id)
        .then(res =>{
            this.setState({
                usuario: res.data,
            });
        });
    }//Fin de getUsuario()
    
    updateContraseña = () =>{
        this.changeState();
        console.log("update contraseña ")
        if(this.cambioRef.current.value === "SI"){
            axios.patch("usuario/update", this.state.recuperar)
            .then(res =>{
                this.setState({
                    status: "true"
                });
            });
            window.location.reload(false);
        }else{
            this.setState({
                statusContraseña: "false"
            })
        }
    }//Fin de updateContraseña

    render() {
            return (
                <div className="center">
                <div id="sidebar" className={ this.props.className}>
                
                <br/>
                                                <strong>CAMBIAR CONTRASEÑA</strong>
                                                <br/>  
                                                <select name="actualizar" ref={this.cambioRef} onChange={this.changeState}>
                                                    <option value="NO">NO</option>
                                                    <option value="SI">SI</option>
                                                    </select>
                                                <br/> 
                                                                                                {(() => {
                                                switch(this.state.statusContraseña){   
                                                    case "false":
                                                    return (
                                                    <a className="warning_search">¡Seleccione "SI" para restablecer la contraseña!</a>
                                                    );
                                                    break;
                                                    default:
                                                        break;
                                                }
                                                })()}<br/>
                                                <strong>Email:</strong> {this.state.usuario.email}
                                                <br/> <br/>
                                                <strong>Nueva Contraseña:</strong> p4SS{this.props.id}dEYAe

                                                <br/><br/>
                                                <button className="btn_join" onClick={this.updateContraseña}>Actualizar</button>
                                                
                                                
                                                
                                                
                </div>
                </div>
                
            );
    }//Fin de Render
}//Fin de Class Recuperacion Contraseña
export default RecuperacionContraseña;