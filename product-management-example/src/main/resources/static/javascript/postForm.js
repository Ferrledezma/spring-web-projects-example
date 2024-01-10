const form = document.forms.namedItem("form");

let validated = evt => {
    for(var i = 0; i < form.elements.length - 1; i++){
        if(form.elements[i].value.trim() == ''){
            evt.preventDefault();
        }
    }
    submit(evt);
}

let getFormData = () => {
    const formData = new FormData(form);
    const params = new URLSearchParams(formData);
    const queryString = params.toString();
    const decodedParams = decodeURIComponent(queryString);
    const formDataAsJson = JSON.parse('{"' + decodedParams.replace(/&/g, '","').replace(/=/g, '":"').replace(/\+/g, ' ') + '"}');

    return JSON.stringify(formDataAsJson);
}

let submit = evt => {
    const requestBody = getFormData();
    if(!evt.defaultPrevented) {
        evt.preventDefault();
        fetch(form.action, {
            method: form.method,
            headers: {
                "Accept": "application/json",
                "Content-type": "application/json"
            },
            body: requestBody
        })
        .then(response => response.json())
        .then(response => console.log(response))
        .catch(error => console.log(error));

        form.reset();
    } else {
        console.warn("rejected");
    }
}

form.onsubmit = validated;
