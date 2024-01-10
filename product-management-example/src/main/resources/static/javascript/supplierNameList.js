const select = document.getElementsByName("supplier_name")[0];

let getSupplierName = () => {
    fetch("/resources/SupplierManagement.json")
    .then(response => response.json())
    .then(mappingData => {
        fetch(mappingData.findAllPath)
        .then(response => response.json())
        .then(resourceList => resourceList.forEach(resource => generateElements(resource.name)))
    })
    .catch(error => console.log(error));
}

let generateElements = name => {
    const option = document.createElement("option");
    option.textContent = name;
    option.setAttribute("value", name);
    
    select.append(option);
}

window.onload = getSupplierName;