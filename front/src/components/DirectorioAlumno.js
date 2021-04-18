import React, {Component} from 'react';
import Slider from './Slider';
import { Link, Switch } from 'react-router-dom';
import Cookies from 'universal-cookie';
const cookies = new Cookies();

class DirectorioAlumno extends Component{
    


    usuraioRef=React.createRef();
    usuraioRef=cookies.remove('tipoUsuario', {path:"/"});

	state = {
        email: cookies.get('email'),
        tipoUsuario: cookies.get('tipoUsuario')
    }

	cerrarSesion = () => {
        cookies.remove('idUsuario', {path:"/"});
        cookies.remove('email', {path:"/"});
        cookies.remove('contraseña', {path:"/"});
        cookies.remove('tipoUsuario', {path:"/"});
        cookies.remove('idAlumno', {path:"/"});
        cookies.remove('boleta', {path:"/"});
        window.location.href = '/auth/logout';
    }//Fin de Cerrar SesiON 
    
    render(){
            return(
                <div className="center">
                <tbody>
                    <tr>
                        <th className="table"><Link to='/user/CrearDictamen' className = "active">Dictamen de 70%</Link></th>
                        <th className="table"><Link to='/user/CrearLiberacion' className = "active">Liberacion Extemporanea</Link></th>
                        <th className="table"> <Link to='/user/CrearBaja' className = "active">Baja de Servicio Social</Link></th>
                        <th className="table"><Link to='/user/CrearServicio' className = "active">Documentacion de Servicio Social</Link></th>
{/**FALTA PONER CONTEXTO USER */}<th className="table"><Link to='/MisDatosAlumno' className = "active">Datos Personales</Link></th>
                        <th className="table " > <button id ="table-btn" onClick={this.cerrarSesion}>cerrar sesion</button></th>
                    </tr>
                </tbody>
                </div>
            )//Fin de Return
    };

}//Fin de Class DirectorioAlumno
export default DirectorioAlumno;