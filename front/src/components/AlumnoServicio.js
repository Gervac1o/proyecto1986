import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';

import Cookies from 'universal-cookie';

const cookies = new Cookies();

class AlumnoServicio extends React.Component{



    estadoRef = React.createRef();

    state = {
        idAlumno: this.props.id,
        servicio: {},
        alumno: {},
        usuario: {},
        statusServicio: null,
        cambioEstado: {},
        statusEstado: null,
    };

    changeState = () =>{
        this.setState({
            cambioEstado:{
                idAlumno:this.props.id,
                idServicio: this.state.servicio.idServicio,
                semestre: this.state.servicio.semestre,
                responsableDirecto: this.state.servicio.responsableDirecto,
                estado: this.estadoRef.current.value,
                fechaRegistro: this.state.servicio.fechaRegistro,
                revisado: cookies.get('nombre'),
            }
        })
    }//Fin de ChangeState

     componentWillMount=()=> {
            this.getServicio();
            this.getAlumno();           
        }

        getAlumno = () => {
            axios.get("alumno/find/"+ this.props.id)
            .then(response => {
            this.setState({
                alumno: response.data,
                status: 'success'
            });
            });   
        }//Fin de getAlumno()
    
    getServicio = () => {
        axios.get("servicioSocial/findIdAlumno/"+ this.props.id)
        .then(response => {
        this.setState({
            servicio: response.data,
            statusServicio: 'success'
        });
    });   
    }//Fin de getservicio()

    getEmail = () => {
        axios.get("usuario/find/"+ this.state.alumno.idUsuario)
        .then(response => {
        this.setState({
            usuario: response.data,
            });
        });   
    }//Fin de getEmail()

    deleteServicio = () => {
        axios.delete("servicioSocial/delete/"+this.props.id)
        .then(res => {
            window.location.href = "./" + this.props.id
        })
    }//Fin de deleteServicio

    estado = () => {
        this.setState({
            statusEstado: "true"
        });
    }//Fin de estado

    cancelEstado = () => {
        this.setState({
            statusEstado: "false"
        });
    }//Fin de estado

    cambiarEstado = () => {
        this.changeState();
        axios.patch("servicioSocial/update", this.state.cambioEstado)
        .then(res =>{
            this.getServicio();
        });
    }//Fin de Cambiar Estado
    
    render(){
        if(this.state.statusServicio == 'success'){
        return(
            <div className="center">
                <tbody>
                    <tr >
                        <th className="table_lista">Alumno</th>
                        <th className="table_lista">Boleta</th>
                        <th className="table_lista">Programa Academico</th>
                        <th className="table_lista">Estado de la Solicitud</th>
                        {(() => {  
                                switch (this.state.servicio.estado){
                                case "NUEVO":
                                    return(
                                        null
                                    ); 
                                    break;  
                                default:
                                    return(
                                        <th className="table_lista">Revisado por</th>
                                    ); 
                                    break;
                                }
                        })()}  
                    </tr>
                </tbody>
                <tbody>
                    <tr>
                        <td className="table_lista">{this.state.alumno.apellidoPaterno} {this.state.alumno.apellidoMaterno} {this.state.alumno.nombre}</td>
                        <td className="table_lista">{this.state.alumno.boleta}</td> 
                        <td className="table_lista">{this.state.alumno.programaAcademico}</td>
                        <td className="table_lista">{(() => {  
                                switch (this.state.servicio.estado){
                                case "NUEVO":
                                    return (
                                        <a id="state_new">NO REVISADO</a>
                                    );
                                break;
                                case "PROCESANDO":
                                    return(
                                        <a id="state_processing">EN PROCESO</a>
                                    ); 
                                    break;  
                                case "FINALIZADO":
                                    return(
                                        <a id="state_finished">FINALIZADO</a>   
                                    );
                                case "RECHAZADO":
                                    return(
                                        <a id="state_rejected">RECHAZADO</a>
                                    )
                                default: 
                                    break;
                                }
                                })()}</td>
                            {(() => {  
                                switch (this.state.servicio.estado){
                                case "NUEVO":
                                    return(
                                        null
                                    ); 
                                    break;  
                                default:
                                    return(
                                        <th className="table_lista">{this.state.servicio.revisado}</th>
                                    ); 
                                    break;
                                }
                                })()}
                                <td>
                                <input type="checkbox" id="btn-modal"/>
                                <label htmlFor="btn-modal" className="btn" onClick={this.getEmail}>INFORMACI??N</label>
                                <div className="modal">
                                <div className="contenedor">
                                    <h1>Servicio Social</h1>
                                    <label htmlFor="btn-modal">X</label>
                                    <div className="contenido">
                                    <div>
                                        <strong>Fecha de Registro:</strong> {this.state.servicio.fechaRegistro}
                                    </div>
                                    <div>
                                        <strong>Semestre:</strong> {this.state.servicio.semestre}
                                    </div>
                                    <div>
                                        <strong>Correo elect??nico:</strong> {this.state.usuario.email}
                                    </div>
                                    <br/>
                                    <button className="btn_join" onClick={this.estado}>Cambiar Estado</button>
                                    <br/><br/>
                                {(() => {  
                                    switch (this.state.statusEstado){
                                    case "true":
                                    return (
                                        <div className="center">
                                                <select name="estado" ref={this.estadoRef} onChange={this.changeState}>
                                                    <option value="NUEVO">NO REVISADO</option>
                                                    <option value="PROCESANDO">EN PROCESO</option>
                                                    <option value="FINALIZADO">FINALIZADO</option>
                                                    <option value="RECHAZADO">RECHAZADO</option>
                                                    </select>
                                                <br/><br/>
                                                <button className="btn_join" onClick={this.cambiarEstado}>Actualizar</button>
                                                <button id="btn_delete" onClick={this.cancelEstado}>Cancelar</button>
                                                <br/>
                                                </div>
                                                    );
                                                break;
                                                default: break;
                                                }
                                            })()}
                                            <br/>
                                            <button id="btn_deleteRegistro" onClick={this.deleteServicio}>Borrar Registro</button>
                                        </div>
                                    </div>
                                </div>
                            </td>
                    </tr>
                </tbody>             
            </div>
        );
    }else if(this.state.statusServicio != 'success'){
        return(
            <div className="center">
                <tbody>
                    <tr >
                        <th className="table_lista">Alumno</th>
                        <th className="table_lista">Boleta</th>
                        <th className="table_lista">Programa Academico</th>
                        <th className="table_lista">Estado de la Solicitud</th>  
                    </tr>
                </tbody>
                <tbody>
                    <tr>
                        <td className="table_lista">{this.state.alumno.apellidoPaterno} {this.state.alumno.apellidoMaterno} {this.state.alumno.nombre}</td>
                        <td className="table_lista">{this.state.alumno.boleta}</td> 
                        <td className="table_lista">{this.state.alumno.programaAcademico}</td>
                        <td className="table_lista">SIN REGISTRO</td>
                    </tr>
                </tbody>
            </div>
        );
    }else{
        return(
            <div className="center">
                <tbody>
                    <tr >
                        <th className="table_lista">Alumno</th>
                        <th className="table_lista">Boleta</th>
                        <th className="table_lista">Programa Academico</th>
                        <th className="table_lista">Estado de la Solicitud</th>  
                    </tr>
                </tbody>
                <tbody>
                    <tr>
                        <td className="table_lista">{this.state.alumno.apellidoPaterno} {this.state.alumno.apellidoMaterno} {this.state.alumno.nombre}</td>
                        <td className="table_lista">{this.state.alumno.boleta}</td> 
                        <td className="table_lista">{this.state.alumno.programaAcademico}</td>
                        <td className="table_lista">Cargando...</td>
                    </tr>
                </tbody>
            </div>
        );
    }
}//Fin de Render ()
}//Fin de Classs AlumnoServicio
export default AlumnoServicio;