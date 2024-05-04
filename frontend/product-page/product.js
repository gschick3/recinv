let costMake = 0; 

let materials = new Map([
    [1, "Base Thread"],
    [2, "Black Thread"],
    [3, "White Thread"],
    [4, "Pink Thread"],
    [5, "Brown Thread"],
    [6, "Green Thread"],
    [7, "Orange Thread"],
    [8, "Dark Orange Thread"],
    [9, "Light Purple Thread"],
    [10, "Dark Purple Thread"],
    [11, "Light Pink Thread"],
    [12, "Dark Pink Thread"]
]);

let materialCosts = new Map([
    ["Base Thread", 0.50], 
    ["Black Thread", 0.50], 
    ["White Thread", 0.50], 
    ["Pink Thread", 0.50], 
    ["Brown Thread", 0.50], 
    ["Green Thread", 0.50], 
    ["Orange Thread", 0.50], 
    ["Dark Orange Thread", 0.50], 
    ["Light Purple Thread", 0.50],
    ["Dark Purle Thread", 0.50], 
    ["Light Pink Thread", 0.50], 
    ["Dark Pink Thread", 0.50]
]);

function loadMod(event, form, num) {
    item = form.description.value;
    cost = form.sellingPrice.value;

    formInfo = $('#newProductForm').serializeArray();

    var placement = document.getElementById('recipeMods');

    var modTemplate = document.querySelector('#productRecipeTemplate');
    var modClone = modTemplate.content.cloneNode(true);

    modClone.getElementById('productInfo').setAttribute('id', num);

    tbody = modClone.getElementById('myTable');

    var rowTemplate = document.querySelector('#recipeRowTemplate');

    for (let j = 2; j < formInfo.length; j+=2) {
        var material = materials.get(parseInt(formInfo[j].value));
        var amount = formInfo[j+1].value;
        var costMaterial = amount * materialCosts.get(material);
        costMake += costMaterial; 
        var rowClone = rowTemplate.content.cloneNode(true);
        var td = rowClone.querySelectorAll("td");
        td[0].innerHTML = material;
        td[1].innerHTML = `<input type='text' class='form-control-sm' name='description' value='${amount}'  readonly disabled='disabled'></input>`;
        td[2].textContent = '$' + costMaterial;
        td[3].innerHTML = `<button class="editButton" data-open="0" id="edit${num}"><svg class="editIcon" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-fill" viewBox="0 0 16 16"><path d="M12.854.146a.5.5 0 0 0-.707 0L10.5 1.793 14.207 5.5l1.647-1.646a.5.5 0 0 0 0-.708zm.646 6.061L9.793 2.5 3.293 9H3.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.207zm-7.468 7.468A.5.5 0 0 1 6 13.5V13h-.5a.5.5 0 0 1-.5-.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.5-.5V10h-.5a.5.5 0 0 1-.175-.032l-.179.178a.5.5 0 0 0-.11.168l-2 5a.5.5 0 0 0 .65.65l5-2a.5.5 0 0 0 .168-.11z" /></svg></button>`;
        tbody.appendChild(rowClone);
    }

    var h5 = modClone.querySelectorAll("h5");
    h5[0].textContent = item;
    h5[1].textContent = 'Selling Price: $' + cost;
    h5[2].tetContent = 'Cost to Make: $' + costMake;

    placement.appendChild(modClone);
    addEditButtonListeners();
}

function setupMaterialModal(event) {
    var model = document.getElementById('newProductModal');
    var template = document.getElementById('materialFormRowTemplate');
    var rowContent = template.content.cloneNode(true);
    model.querySelector('#materialForm').appendChild(rowContent);
}

function addMaterialRow() {
    var model = document.getElementById('newProductModal');
    var template = document.getElementById('materialFormRowTemplate');
    var rowContent = template.content.cloneNode(true);
    model.querySelector('#materialForm').appendChild(rowContent)
}

function newProductFormSubmit(event, form) {
    event.preventDefault();

    var item = form.description.value;
    var cost = form.sellingPrice.value;

    var tbody = document.getElementById('myTable');
    var rowCount = ++tbody.dataset.count;

    var spacer = document.querySelector('#spacerRow');
    var spacerclone = spacer.content.cloneNode(true);
    tbody.appendChild(spacerclone);

    tbody.dataset.count = rowCount;
    loadMod(event, form, rowCount);

    console.log(document.getElementById(rowCount));

    var template = document.querySelector('#productRowTemplate');
    var clone = template.content.cloneNode(true);
    var td = clone.querySelectorAll("td");
    td[0].innerHTML = `<input type="text" class="form-control-sm" name="brand" value="${item}" readonly disabled="disabled">`;
    td[1].textContent = '$' + costMake;
    td[2].innerHTML = `<input type="text" class="form-control-sm" name="brand" value="$${cost}" readonly disabled="disabled">`;
    td[3].textContent = "0";
    td[4].textContent = "0";
    td[5].innerHTML = `<button class="infoButton" data-toggle="modal" data-target="#${rowCount}"><svg id="info-${rowCount}" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-info-circle-fill" viewBox="0 0 16 16"> <path d="M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16m.93-9.412-1 4.705c-.07.34.029.533.304.533.194 0 .487-.07.686-.246l-.088.416c-.287.346-.92.598-1.465.598-.703 0-1.002-.422-.808-1.319l.738-3.468c.064-.293.006-.399-.287-.47l-.451-.081.082-.381 2.29-.287zM8 5.5a1 1 0 1 1 0-2 1 1 0 0 1 0 2" /></svg></button>`;
    td[6].innerHTML = `<button class="editButton" data-open="0" id="edit-${rowCount}"><svg class="editIcon" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-fill" viewBox="0 0 16 16"><path d="M12.854.146a.5.5 0 0 0-.707 0L10.5 1.793 14.207 5.5l1.647-1.646a.5.5 0 0 0 0-.708zm.646 6.061L9.793 2.5 3.293 9H3.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.207zm-7.468 7.468A.5.5 0 0 1 6 13.5V13h-.5a.5.5 0 0 1-.5-.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.5-.5V10h-.5a.5.5 0 0 1-.175-.032l-.179.178a.5.5 0 0 0-.11.168l-2 5a.5.5 0 0 0 .65.65l5-2a.5.5 0 0 0 .168-.11z" /></svg></button>`;

    costMake = 0; 

    //don't move >:(
    addEditButtonListeners();

    tbody.appendChild(clone);

    //don't move >:(
    addEditButtonListeners();

    $('#newProductModal').modal('hide');

    form.reset();
};

function rowEditClickHandler(event) {

    event.preventDefault;
    var button = event.target.closest('button');

    var row = button.closest('tr');
    var formElements = row.getElementsByTagName('input');
    if (button.dataset.open == 1) {
        button.innerHTML =
            '<svg class="editIcon" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-fill" viewBox="0 0 16 16">\
         <path d="M12.854.146a.5.5 0 0 0-.707 0L10.5 1.793 14.207 5.5l1.647-1.646a.5.5 0 0 0 0-.708zm.646 6.061L9.793 2.5 3.293 9H3.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.207zm-7.468 7.468A.5.5 0 0 1 6 13.5V13h-.5a.5.5 0 0 1-.5-.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.5-.5V10h-.5a.5.5 0 0 1-.175-.032l-.179.178a.5.5 0 0 0-.11.168l-2 5a.5.5 0 0 0 .65.65l5-2a.5.5 0 0 0 .168-.11z"/>\
         </svg>';
        Array.from(formElements).forEach((input) => {
            input.disabled = true;
            input.readOnly = true;
        });

        button.dataset.open = 0;
        addEditButtonListeners();
    } else {
        button.innerHTML =
            '<svg class="checkMark" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-check-circle-fill" viewBox="0 0 16 16">\
         <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0m-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>\
         </svg>';
        Array.from(formElements).forEach((input) => {
            input.readOnly = false;
            input.disabled = false;
        });
        button.dataset.open = 1;
        removeEditButtonListeners(button);
    }
}

function addEditButtonListeners() {
    Array.from(document.getElementsByClassName('editButton')).forEach((button) => {
        button.addEventListener('click', rowEditClickHandler);
    });
}

function removeEditButtonListeners(currentButton) {
    Array.from(document.getElementsByClassName('editButton')).forEach((button) => {
        if (button !== currentButton) {
            button.removeEventListener('click', rowEditClickHandler);
        };
    });
}

window.onload = function () {
    setupMaterialModal();
    document.querySelector('#addMaterial').addEventListener('click', addMaterialRow);
}

