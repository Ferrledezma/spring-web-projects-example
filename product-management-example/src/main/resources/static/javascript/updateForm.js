const form = document.forms.namedItem("form");
let resource;

let asignResourceDataToForm = () => {
    resource = recuperateData();
    Object.keys(resource).map(key => {
        if(form.elements[key]){
            form.elements[key].value = resource[key];
        }
    });
}

let recuperateData = () => {
    const queryString = window.location.search; //Obtiene la cadena de consultas actual, la cadena de consultas es la que va después del signo ? de la url
    const params = new URLSearchParams(queryString); //Crear un objeto a partir de la cadena de consulta, cuyo objeto contiene métodps para manipular los parámetros de la url
    const encodedData = params.get('data');//recupera el parámetro que fue adjuntado a la url, cuyo parámetro guarda un recurso de la base datos
    const jsonResource = JSON.parse(encodedData);//Convierte el parámetro recuperado en un objeto json para que pueda ser manipulado.

    return jsonResource;
}

let updateResource = () => {
    const updateResource = getUpdateResource();
    
    fetch(form.action + resource.id, {
        method: "PATCH",
        headers: {
            "Accept": "application/json",
            "Content-type": "application/json"
        },
        body: JSON.stringify(updateResource)
    })
    .then(response => response.json())
    .then(response => {
        console.log(response);
        redirect();
    })
    .catch(error => console.error(error));
}

let getUpdateResource = () => {
    const formData = new FormData(form); //Crea un objeto a partir del formulario.
    const params = new URLSearchParams(formData);//Crea un objeto a partir de los datos key-value del  objeto formulario
    const queryString = params.toString();//convierte los datos en una cadena de texto.
    const decodedResourceData = decodeURIComponent(queryString);//Decodifica los datos que se han ingresado.
    const jsonData = JSON.parse('{"' + decodedResourceData.replace(/&/g, '","').replace(/=/g, '":"').replace(/\+/g, ' ') + '"}');//Formatea la cadena obtenido a un formato json valido y luego parsea.

    return jsonData;
}

let redirect = () => {
    const jsonPath = form.getAttribute("data-info");
    fetch(jsonPath)
        .then(response => response.json())
        .then(mappingData => window.location.href = mappingData.tableListDocument)
        .catch(error => console.error(error));
};

window.onload = asignResourceDataToForm;
form.onsubmit = updateResource;