let mappingData;
const form = document.forms.namedItem("form");

let getData = () => {
    const jsonDataPath = document.getElementById("table").getAttribute("data-info");

    fetch(jsonDataPath)
        .then(response => {
            if (response.status == "204")
                throw new Error("Empty list");
            return response.json();
        })
        .then(response => {
            mappingData = response;
            tableList(mappingData.findAllPath);
        })
        .catch(error => console.error(error));
}

let tableList = path => {
    fetch(path)
        .then(response => {
            if (response.status == "204")
                throw new Error("Empty list");
            document.querySelector("tbody").innerHTML = "";
            return response.json();
        })
        .then(response => response.forEach(resource => generateRow(resource)))
        .catch(error => console.error(error));
}

let generateRow = resource => {
    const row = document.createElement("tr");

    rowColumnsData(row, resource);
    rowDetails(row, resource);

    document.querySelector("tbody").appendChild(row);
}

let rowColumnsData = (row, resource) => {
    let dataContainer = [];
    Object.keys(resource).forEach(key => dataContainer.push(resource[key]));

    dataContainer.forEach(data => {
        const column = document.createElement("td");
        column.textContent = data;
        row.appendChild(column);
    });
}

let rowDetails = (row, resource) => {
    const resourceAsJson = JSON.stringify(resource);
    const encodedResource = encodeURIComponent(resourceAsJson);

    const update = document.createElement("a");
    update.setAttribute("href", mappingData.updateDocument + `?data=${encodedResource}`);
    update.classList.add("material-icons", "aElement");
    update.textContent = "mode_edit_outline";

    const remove = document.createElement("a");
    remove.setAttribute("onclick", `deleteResource(${resource.id})`);
    remove.classList.add("material-icons", "aElement");
    remove.textContent = "delete";
    
    const column = document.createElement("td");
    column.classList.add("action");
    column.append(update, remove);

    row.append(column);
}

let deleteResource = async id => {
    try {
        await fetch(mappingData.deletePath + id, {
            method: "DELETE"
        });
        document.querySelector("tbody").innerHTML = "";
        tableList(mappingData.findAllPath);
    } catch (error) {
        console.log(error);
    }
}

let search = () => {
    const value = form.elements["match"].value;
    if(value.trim() != ""){
        const path = mappingData.findMatchPath + "?value=" + value;
        tableList(path);
    } else {
        tableList(mappingData.findAllPath);
    }
}

window.onload = getData;
form.onsubmit = search;