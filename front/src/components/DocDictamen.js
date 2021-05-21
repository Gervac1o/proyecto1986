import React, { Component } from 'react';
import axios from 'axios';


class DocDictamen extends React.Component{



    state = {
        docDictamen: "",
        status: null
    };
        componentWillMount = () => {
            const { match: { params } } = this.props;
            var doc = params.doc;
            this.setState({
                    docDictamen: doc,
                    status: "true"
            })
        }
    render() {
        if(this.state.status == "true"){
            return(
                <div>
                    <a>descarga completa</a>
                        <iframe  src={"https://proyectofinal1986.herokuapp.com/docDictamen/getDoc/" + this.state.docDictamen}></iframe>
                </div>
            );
        }
    }//Fin de Render ()
}//Fin de Classs DocDictamen

export default DocDictamen;