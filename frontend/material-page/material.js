const addButton = document.getElementById('addButton');
const checkInfo = document.getElementById('checkInfo');

const BASE_URL = `http://127.0.0.1:8080/users/${sessionStorage.getItem("userId")}/materials`;

function clearMaterialTable() {
    var tbody = document.getElementById('myTable');
    tbody.innerHTML = '';
}

function addMaterialRow(materialId, description, brand, currentCost, currentQuantity = 0.0, totalSpent = 0.00) {
    var tbody = document.getElementById('myTable');

    var spacer = document.querySelector('#spacerRow');
    var spacerclone = spacer.content.cloneNode(true);
    tbody.appendChild(spacerclone);

    var template = document.querySelector('#materialRowTemplate');
    var clone = template.content.cloneNode(true);
    var td = clone.querySelectorAll("td");
    var button = document.createElement("button");
    button.setAttribute("class", "editButton");
    button.setAttribute("data-open", "0");
    button.addEventListener('click', createRowEditClickHandler(materialId));
    button.innerHTML = '<svg class="editIcon" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-fill" viewBox="0 0 16 16"><path d="M12.854.146a.5.5 0 0 0-.707 0L10.5 1.793 14.207 5.5l1.647-1.646a.5.5 0 0 0 0-.708zm.646 6.061L9.793 2.5 3.293 9H3.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.207zm-7.468 7.468A.5.5 0 0 1 6 13.5V13h-.5a.5.5 0 0 1-.5-.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.5-.5V10h-.5a.5.5 0 0 1-.175-.032l-.179.178a.5.5 0 0 0-.11.168l-2 5a.5.5 0 0 0 .65.65l5-2a.5.5 0 0 0 .168-.11z" /></svg>'
    
    td[0].innerHTML = "<input type='text' class='form-control-sm' name='description' value='" + description + "' readonly disabled='disabled'></input>";
    td[1].innerHTML = '<input type="text" class="form-control-sm" name="brand" value="' + brand + '" readonly disabled="disabled">';
    td[2].innerHTML = '<input type="text" class="form-control-sm" name="currentCost" value="$' + currentCost +  '" readonly disabled="disabled">';
    td[3].textContent = `${currentQuantity}`;
    td[4].textContent = `$${totalSpent}`;
    td[5].appendChild(button);

    tbody.appendChild(clone);
}

async function newMaterialFormSubmit(event, form) {
    event.preventDefault();

    let description = form.description.value;
    let brand = form.brand.value;
    let currentCost = form.currentCost.value;

    if (description.length == 0 || brand.length == 0 || currentCost <= 0) {
        return;
    }

    let body = JSON.stringify({
		description: form.description.value, 
		brand: form.brand.value,
        unit: "",
        currentCost: parseFloat(form.currentCost.value)
	});

    let response = await fetch(`${BASE_URL}/new`, {
        method: "POST",
        headers: {
            "Authorization": `Bearer ${sessionStorage.getItem("token")}`,
            "Accept": "application/json",
            "Content-Type": "application/json"
        },
        body: body
    });

    getAllMaterials();

    $('#newMaterialModal').modal('hide')
};

function createRowEditClickHandler(materialId) {
    return function rowEditClickHandler(event) {
        event.preventDefault;
        var button = event.target.closest('button');

        var row = button.closest('tr');
        var formElements = row.getElementsByTagName('input');
        button.innerHTML =
            '<svg class="checkMark" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-check-circle-fill" viewBox="0 0 16 16">\
        <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0m-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>\
        </svg>';
        Array.from(formElements).forEach((input) => {
            input.readOnly = false;
            input.disabled = false;
        });
        formElements.description.focus();

        button.addEventListener('click', createRowSubmitClickHandler(materialId));
        button.removeEventListener('click', rowEditClickHandler);
    }
}

function createRowSubmitClickHandler(materialId) {
    return function rowSubmitClickHandler(event) {
        event.preventDefault;
        var button = event.target.closest('button');

        var row = button.closest('tr');
        var formElements = row.getElementsByTagName('input');
        button.innerHTML =
            '<svg class="editIcon" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-fill" viewBox="0 0 16 16">\
        <path d="M12.854.146a.5.5 0 0 0-.707 0L10.5 1.793 14.207 5.5l1.647-1.646a.5.5 0 0 0 0-.708zm.646 6.061L9.793 2.5 3.293 9H3.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.207zm-7.468 7.468A.5.5 0 0 1 6 13.5V13h-.5a.5.5 0 0 1-.5-.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.5-.5V10h-.5a.5.5 0 0 1-.175-.032l-.179.178a.5.5 0 0 0-.11.168l-2 5a.5.5 0 0 0 .65.65l5-2a.5.5 0 0 0 .168-.11z"/>\
        </svg>';
        Array.from(formElements).forEach((input) => {
            input.disabled = true;
            input.readOnly = true;
        });
        
        button.addEventListener('click', createRowEditClickHandler(materialId));
        button.removeEventListener('click', rowSubmitClickHandler);
    }
}

function materialUpdateHandler(event) {
    // get the row
    var row = event.target.closest('tr');
    // build the FormData object
    var formData = new FormData();
    // set the things in the thing

    // get the material id
    var materialId = row.dataset.materialId;
    var url = BASE_URL + "?materialId=" + materialId;
    // do the ajax put
    // $.ajax({
    //     type: "PUT",
    //     url: url,
    //     data: form.serialize(),
    //     success: function(data) {
    //         // Ajax call completed successfully
    //         alert('Materia saved sucwfhjskahsdhkf');
    form.reset();
    //     },
    //     error: function(data) {
    //         // Some error in ajax call
    //         alert("some Error");
    //     }
    // });
}

async function getAllMaterials() {
    let response = await fetch(BASE_URL, {
        method: "GET",
        headers: {
            "Authorization": `Bearer ${sessionStorage.getItem("token")}`,
            "Accept": "application/json"
        }
    });

    let data = await response.json();

    clearMaterialTable();

    if (!data._embedded) {
        return;
    }
    
    data._embedded.materialList.forEach((material) => {
        addMaterialRow(material.materialId, material.description, material.brand, material.currentCost, material.currentQuantity, material.totalSpent);
    });
}