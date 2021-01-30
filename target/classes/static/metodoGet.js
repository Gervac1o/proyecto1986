

console.log("metodo get")

//document.getElementById('myBtn');




function showAlert(){
	alert("luis");
}

function displayDate() {
    document.getElementById("demo").innerHTML = Date();
  }

function traerDatos(){
	//document.addEventListener('dblclick', traerDatos());
	 console.log("dentro de la funcion");
	  const xhttp = new XMLHttpRequest();
    xhttp.open('GET', 'http://localhost:8080/cliente/findAll' );
    xhttp.send();
    xhttp.onreadystatechange = function(){
        if(this.readyState ==4 && this.status == 200){
           console.log(this.responseText);
           let datos = JSON.parse(this.responseText);
           console.log(datos);
           let res =document.querySelector('.boton');
           res.innerHTML="";
           for(let item of datos){

            console.log(item.nombre);

            res.innerHTML += `
                <tr>
                <td> ${item.idCliente}</td>
                <td>${item.nombre}</td>
                </tr>
            	`
            
           }
        }
       
    }
    
 

}







