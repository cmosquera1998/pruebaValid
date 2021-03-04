var texto = document.getElementById("texto");
var parrafo = document.getElementById("parrafo");
var enviar = document.getElementById("enviar");
    

enviar.addEventListener('click',function(){
	parrafo.innerHTML = texto.value;
});