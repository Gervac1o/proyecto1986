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
                        <a  href={"http://localhost:8080/docDictamen/getDoc/" + this.state.docDictamen} download="">descarga</a>
                </div>
            );
        }
    }//Fin de Render ()
}//Fin de Classs DocDictamen

export default DocDictamen;