import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';

import Cookies from 'universal-cookie';
const cookies = new Cookies();


class AlumnoLiberacion extends React.Component{



    estadoRef = React.createRef();

    state = {
        idAlumno: this.props.id,
        liberacion: {},
        alumno: {},
        usuario: {},
        statusLiberacion: null,
        cambioEstado: {},
        statusEstado: null,
    };

    changeState = () =>{
        this.setState({
            cambioEstado:{
                idAlumno:this.props.id,
                idLiberacion: this.state.liberacion.idLiberacion,
                telefono: this.state.liberacion.telefono,
                semestre: this.state.liberacion.semestre,
                egresado: this.state.liberacion.egresado,
                registroSS: this.state.liberacion.registroSS,
                prestatario: this.state.liberacion.prestatario,
                programaSS: this.state.liberacion.programaSS,
                fechaInicio: this.state.liberacion.fechaInicio,
                fechaTermino: this.state.liberacion.fechaTermino,
                estado: this.estadoRef.current.value,
                fechaRegistro: this.state.liberacion.fechaRegistro,
                revisado: cookies.get('nombre'),
            }
        })
    }//Fin de ChangeState

        componentWillMount() {
            this.getAlumno();
            this.getLiberacion();
        }

        getAlumno = () => {
            axios.get("alumno/find/"+ this.props.id)
            .then(response => {
            this.setState({
                alumno: response.data,
                status: 'success'
            });
            } );   
        }//Fin de getAlumno()
    
    getLiberacion = () => {
        axios.get("liberacionExtemporanea/findIdAlumno/"+ this.props.id)
        .then(response => {
        this.setState({
            liberacion: response.data,
            statusLiberacion: 'success'
        });
        } );   
    }//Fin de getLiberacion()

    getEmail = () => {
        axios.get("usuario/find/"+ this.state.alumno.idUsuario)
        .then(response => {
        this.setState({
            usuario: response.data,
            });
        });   
    }//Fin de getEmail()

    deleteLiberacion = () => {
        axios.delete("liberacionExtemporanea/delete/"+this.props.id)
        .then(res => {
            window.location.href = "./" + this.props.id
        })
    }//Fin de deleteLiberacion

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
        axios.patch("liberacionExtemporanea/update", this.state.cambioEstado)
        .then(res =>{
            this.getLiberacion();
        });
    }//Fin de Cambiar Estado
    
    render(){
        if(this.state.statusLiberacion === 'success'){
        return(
            <div className="center">
                <tbody>
                    <tr >
                        <th className="table_lista"> </th>
                        <th className="table_lista">Alumno</th>
                        <th className="table_lista">Boleta</th>
                        <th className="table_lista">Programa Academico</th>
                        
                        {(() => {  
                                switch (this.state.liberacion.estado){
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
                    <td className="table_lista">Tr??mite</td>
                        <td className="table_lista">{this.state.alumno.apellidoPaterno} {this.state.alumno.apellidoMaterno} {this.state.alumno.nombre}</td>
                        <td className="table_lista">{this.state.alumno.boleta}</td> 
                        <td className="table_lista">{this.state.alumno.programaAcademico}</td>
                     {/**   <td className="table_lista">{(() => {  
                                switch (this.state.liberacion.estado){
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
                                switch (this.state.liberacion.estado){
                                case "NUEVO":
                                    return(
                                        null
                                    ); 
                                    break;  
                                default:
                                    return(
                                        <th className="table_lista">{this.state.liberacion.revisado}</th>
                                    ); 
                                    break;
                                }
                             })()}  
                                <td>
                                <input type="checkbox" id="btn-modal"/>
                                <label htmlFor="btn-modal" className="btn" onClick={this.getEmail}>INFORMACI??N</label>
                                <div className="modal">
                                <div className="contenedor">
                                    <h1>Liberaci??n Extemporanea</h1>
                                    <label htmlFor="btn-modal">X</label>
                                    <div className="contenido">
                                    <div>
                                        <strong>Fecha de Registro:</strong> {this.state.liberacion.fechaRegistro}
                                    </div>
                                    <div>
                                        <strong>Semestre:</strong> {this.state.liberacion.semestre}
                                    </div>
                                    <div>
                                        <strong>Registro de Servicio Social:</strong> {this.state.liberacion.registroSS}
                                    </div>
                                    <div>
                                        <strong>Programa de Servicio Social:</strong> {this.state.liberacion.programaSS}
                                    </div>
                                    <div>
                                        <strong>Prestatario:</strong> {this.state.liberacion.prestatario}
                                    </div>
                                    <div>
                                        <strong>Fecha de Inicio:</strong> {this.state.liberacion.fechaInicio}
                                    </div>
                                    <div>
                                        <strong>Fecha de T??rmino:</strong> {this.state.liberacion.fechaTermino}
                                    </div>
                                    <div>
                                        <strong>N??mero Telef??nico:</strong> {this.state.liberacion.telefono}
                                    </div>
                                    <div>
                                        <strong>Correo electr??nico:</strong> {this.state.usuario.email}
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
                                        <button id="btn_deleteRegistro" onClick={this.deleteLiberacion}>Borrar Registro</button>
                                        </div>
                                    </div>  
                                </div>  
                            </td>*/}
                    </tr>
                </tbody>
            </div>
        );
    }else if(this.state.statusLiberacion != 'success'){
        return(
            <div className="center">
                <tbody>
                    <tr >
                    <th className="table_lista"> </th>
                        <th className="table_lista">Alumno</th>
                        <th className="table_lista">Boleta</th>
                        <th className="table_lista">Programa Academico</th>
                    </tr>
                </tbody>
                <tbody>
                    <tr>
                    <td className="table_lista">Tr??mite</td>
                            <td className="table_lista">{this.state.alumno.apellidoPaterno} {this.state.alumno.apellidoMaterno} {this.state.alumno.nombre}</td>
                            <td className="table_lista">{this.state.alumno.boleta}</td> 
                            <td className="table_lista">{this.state.alumno.programaAcademico}</td>
                        
                    </tr>
                </tbody>
            </div> 
        );   
    }
}//Fin de Render ()
}//Fin de Classs AlumnoLiberacion
export default AlumnoLiberacion;