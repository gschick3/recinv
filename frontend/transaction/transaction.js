'use strict'

const BASE_URL = `http://127.0.0.1:8080/users/${sessionStorage.getItem("userId")}`

let data = [
    {
        "id": 12,
        "date": "03/17/24",
        "service": "Etsy",
        "cost": 25.69,
        "items": [
            {
                "desc": "Nautro artwork",
                "qty": 1,
                "cost": 23.42
            },
            {
                "desc": "Nautro pins",
                "qty": 3,
                "cost": 23.42
            },
            {
                "desc": "Nautro sticker",
                "qty": 1, 
                "cost": 0
            },
            {
                "desc": "Filler",
                "qty": 1, 
                "cost": 0
            }, 
            {
                "desc": "Filler", 
                "qty": 1, 
                "cost": 0
            }
        ]
    },
    {
        "id": 13,
        "date": "04/20/24",
        "service": "Etsy",
        "cost": 36.47,
        "items": [
            {
                "desc": "Cow print",
                "qty": 1,
                "cost": 23.42
            },
            {
                "desc": "Pictures of Alfred",
                "qty": 9,
                "cost": 23.42
            }
        ]
    },
    {
        "id": 14,
        "date": "04/20/24",
        "service": "Etsy",
        "cost": 4.35,
        "items": [
            {
                "desc": "Flower bookmark",
                "qty": 8,
                "cost": 24.42
            },
            {
                "desc": "dino keychain",
                "qty": 2,
                "cost": 11.22
            }
          
        ]
    },
    {
        "id": 15,
        "date": "04/20/24",
        "service": "Etsy",
        "cost": 35.69,
        "items": [
            {
                "desc": "Heart bookmark",
                "qty": 8,
                "cost": 24.42
            },
            {
                "desc": "Chicken keychain",
                "qty": 2,
                "cost": 11.22
            }
        ]
    },
    {
        "id": 16,
        "date": "04/20/24",
        "service": "Etsy",
        "cost": 32.69,
        "items": [
            {
                "desc": "Pumpkin bookmark",
                "qty": 3,
                "cost": 20.43
            },
            {
                "desc": "worm bookmark",
                "qty": 2,
                "cost": 12.27
            }
        ]
    },
    {
        "id": 17,
        "date": "04/20/24",
        "service": "Ebay",
        "cost": 42.69,
        "items": [
            {
            "desc": "Flower bookmark",
            "qty": 8,
            "cost": 24.42
             },
             {
            "desc": "dino keychain",
            "qty": 2,
            "cost": 11.22
            }
        ]
    },
    {
        "id": 18,
        "date": "04/20/24",
        "service": "Etsy",
        "cost": 12.39,
        "items": [
            {
                "desc": "dino bookmark",
                "qty": 3,
                "cost": 20.43
            },
            {
                "desc": "worm bookmart",
                "qty": 2,
                "cost": 12.27
            }
        ]
    },
    {
        "id": 19,
        "date": "04/20/24",
        "service": "Etsy",
        "cost": 8.53,
        "items": [
            {
                "desc": "pumpkin bookmark",
                "qty": 3,
                "cost": 20.43
            },
            {
                "desc": "worm bookmart",
                "qty": 2,
                "cost": 12.27
            }
        ]
    },
    {
        "id": 20,
        "date": "04/20/24",
        "service": "Etsy",
        "cost": 23.65,
        "items": [
            {
                "desc": "heart bookmark",
                "qty": 3,
                "cost": 20.43
            },
            {
                "desc": "worm bookmart",
                "qty": 2,
                "cost": 12.27
            }
        ]
    },
    {
        "id": 21,
        "date": "04/20/24",
        "service": "Etsy",
        "cost": 4.69,
        "items": [
            {
                "desc": "heart bookmark",
                "qty": 3,
                "cost": 20.43
            },
            {
                "desc": "worm bookmart",
                "qty": 2,
                "cost": 12.27
            }
        ]
    },
    {
        "id": 22,
        "date": "04/20/24",
        "service": "Etsy",
        "cost": 42.69,
        "items": [
            {
                "desc": "heart bookmark",
                "qty": 3,
                "cost": 20.43
            },
            {
                "desc": "worm bookmart",
                "qty": 2,
                "cost": 12.27
            }
        ]
    },
    {
        "id": 23,
        "date": "04/20/24",
        "service": "PEtsy",
        "cost": 45.89,
        "items": [
            {
                "desc": "heart bookmark",
                "qty": 3,
                "cost": 20.43
            },
            {
                "desc": "worm bookmart",
                "qty": 2,
                "cost": 12.27
            }
        ]
    }
    
];

let withdrawData = [
    {
        "id": 1,
        "date": "03/17/24",
        "service": "JOANN",
        "cost":74.69,
        "items": [
            {
                "desc": "Blanket Yarn - Pink",
                "qty": 10,
                "cost": 12.42
            },
            {
                "desc": "Blanket Yarn - Blue",
                "qty": 1,
                "cost": 14.69
            }
        ]
    },
    
    {
        "id": 2,
        "date": "03/17/24",
        "service": "Michaels Store",
        "cost":54.69,
        "items": [
            {
                "desc": "Blanket Yarn - Blue",
                "qty": 1,
                "cost": 14.69
            },
            {
                "desc": "Blanket Yarn - Pink",
                "qty": 1,
                "cost": 14.69
            },
            {
                "desc": "Blanket Yarn - Stripe",
                "qty": 1,
                "cost": 14.69
            }
            
            
        ]
    },
    {
        "id": 3,
        "date": "03/17/24",
        "service": "JOANN",
        "cost":33.45,
        "items": [
            {
                "desc": "Blanket Yarn - Pink",
                "qty": 1,
                "cost": 12.42
            },
            {
                "desc": "Blanket Yarn - Blue",
                "qty": 1,
                "cost": 14.69
            }
        ]
    },
    {
        "id": 4,
        "date": "03/17/24",
        "service": "Michaels Store",
        "cost": 14.69,
        "items": [
            {
                "desc": "Blanket Yarn - Blue",
                "qty": 1,
                "cost": 14.69
            }
            
        ]
    },
    {
        "id": 5,
        "date": "03/17/24",
        "service": "Michaels Store",
        "cost": 14.69,
        "items": [
            {
                "desc": "Blanket Yarn - Blue",
                "qty": 1,
                "cost": 14.69
            }
            
        ]
    },
    {
        "id": 6,
        "date": "03/17/24",
        "service": "Premier Yarn",
        "cost": 19.35,
        "items": [
            {
                "desc": "Blanket Yarn - Blue",
                "qty": 1,
                "cost": 14.69
            },
            {
                "desc": "Blanket Yarn - Blue",
                "qty": 1,
                "cost": 14.69
            }
            
        ]
    },
    {
        "id": 7,
        "date": "03/17/24",
        "service": "Premier Yarn",
        "cost": 44.69,
        "items": [
            {
                "desc": "Blanket Yarn - Blue",
                "qty": 1,
                "cost": 14.69
            },
            {
                "desc": "Blanket Yarn - Blue",
                "qty": 1,
                "cost": 14.69
            },
            {
                "desc": "Blanket Yarn - Blue",
                "qty": 1,
                "cost": 14.69
            }
            
        ]
    },
    {
        "id": 8,
        "date": "03/17/24",
        "service": "Premier Yarn",
        "cost": 45.67,
        "items": [
            {
                "desc": "Blanket Yarn - Blue",
                "qty": 1,
                "cost": 1.69
            }
            
        ]
    },
    {
        "id": 9,
        "date": "03/17/24",
        "service": "JOANN",
        "cost":13.45,
        "items": [
            {
                "desc": "Blanket Yarn - Pink",
                "qty": 1,
                "cost": 12.42
            },
            {
                "desc": "Blanket Yarn - Blue",
                "qty": 1,
                "cost": 14.69
            }
        ]
    },
    {
        "id": 10,
        "date": "03/17/24",
        "service": "JOANN",
        "cost":13.45,
        "items": [
            {
                "desc": "Blanket Yarn - Pink",
                "qty": 1,
                "cost": 12.42
            },
            {
                "desc": "Blanket Yarn - Blue",
                "qty": 1,
                "cost": 19.45
            }
        ]
    },
    {
        "id": 11,
        "date": "03/17/24",
        "service": "JOANN",
        "cost":13.45,
        "items": [
            {
                "desc": "Blanket Yarn - Pink",
                "qty": 1,
                "cost": 12.42
            },
            {
                "desc": "Blanket Yarn - Blue",
                "qty": 1,
                "cost": 14.69
            }
        ]
    }

];

/// create our click event listener
function openPopup(e) {
    /// fallback support for IE events
    if ( !e ){ e = window.Event };
    /// fallback support for IE .srcElement
    // alert( 'Clicked! ' + ( e.target ? e.target : e.srcElement ) );
    popupDeposit(getDataById(data, this.id))
    depositPopup.classList.add("show");
}

function openWithdrawPopup(e) {
    /// fallback support for IE events
    if ( !e ){ e = window.Event };
    /// fallback support for IE .srcElement
    // alert( 'Clicked! ' + ( e.target ? e.target : e.srcElement ) );
    popupWithdraw(getDataById(withdrawData, this.id))
    withdrawPopup.classList.add("show");
}

function getDataById(dataItem, id) {
    var foundData = dataItem.filter(
        // Note: id is itemId<id> I.e., itemId1
        function(dataItem){ return "itemId" + dataItem.id == id }
    );
    //console.log(foundData, id, dataItem)
    return foundData[0]
}

function closePopup() {
    depositPopup.classList.remove(
        "show"
    );

    withdrawPopup.classList.remove(
        "show"
    );
}

function closeWindow(event) {
    if (event.target == depositPopup) {
        depositPopup.classList.remove(
            "show"
        );
    } else if (event.target == withdrawPopup) {
        withdrawPopup.classList.remove(
            "show"
        );
    }
}

// ======= Deposit List ========================
var allProducts = [];

async function popupDeposit(dataItem) {
    let allSales = await getAllSales(dataItem.id);
    allProducts = await getAllProducts();

    let ulItem = document.createElement("ul");
    ulItem.setAttribute("id", "InputItemsList");
    let itemCount = 0;

    allSales.forEach(saleItem => {
        ulItem.appendChild(newDepositSoldItem(++itemCount, saleItem.product.description, saleItem.quantitySold));
    });

    ulItem.appendChild(appendDepositAddBtn());

    depositBody.innerHTML = `
        <h3>Sale Information</h3>
        <div class="info">
            <div class="info-data">${dataItem.date}</div>
            <div class="info-data">${dataItem.service}</div>
            <div class="info-data">${dataItem.cost}</div>
        </div>
        <h5>Item(s) Sold</h5>
        <div class="card item-info item-box">
            <ul id="itemList"></ul>
            <!-- append ulItem here -->
        </div>
        <button id="submitDepositBtn" class="btn btn-primary px-3" style="margin-top: 15px;">Submit</button>
    `;

    document.getElementById("itemList").parentElement.appendChild(ulItem);
    document.getElementById("submitDepositBtn").addEventListener("click", createSubmitDepositList(dataItem.id, dataItem.date));
}

function addToDepositList() {
    let ul = document.getElementById("InputItemsList");
    let li = ul.getElementsByTagName("li");

    let lastItem = li[li.length - 1]; // because of zero index
    let newItem = newDepositSoldItem(li.length, "", "", );
    lastItem.innerHTML = newItem.innerHTML;

    ul.appendChild(appendDepositAddBtn());
}

function newDepositSoldItem(listNum, description, quantity) {
    let itemListHtml = "";

    allProducts.forEach(i => {
        itemListHtml += `<option prodId="${i.productId}" ${i.description == description ? "selected" : ""}>${i.description}</option>`;
    });

    let liItem = document.createElement("li");
    liItem.setAttribute("id", `${listNum}`)
    liItem.setAttribute("class", "info withdraw-form")
    liItem.innerHTML = `
        <div style="padding: 3px 15px 0 0;">${listNum}.</div>
        <select class="form-control dropdown" id="InputType${listNum}" value="${description}">
            ${itemListHtml}
        </select>
        <input type="number" class="form-control value" id="InputAmount${listNum}" placeholder="Amount" value="${quantity}">
    `;
    return liItem;
}

function appendDepositAddBtn() {
    let liAddBtn = document.createElement("li");
    let div = document.createElement("div");
    let button = document.createElement("button");

    liAddBtn.setAttribute("class", "info withdraw-form");
    div.setAttribute("class", "withdraw-form");
    button.setAttribute("class", "btn btn-primary");
    button.setAttribute("id", "addDepositRow");
    button.setAttribute("type", "submit");
    button.innerHTML = "+";
    button.addEventListener('click', addToDepositList);

    div.appendChild(button);
    liAddBtn.appendChild(div);

    return liAddBtn;
}

// ======= Withdrawal List ========================

let allMaterials = [];

async function popupWithdraw(dataItem) {
    let allPurchases = await getAllPurchases(dataItem.id);
    allMaterials = await getAllMaterials();

    let ulItem = document.createElement("ul");
    ulItem.setAttribute("id", "InputItemsList")
    let itemCount = 0;

    allPurchases.forEach(purchaseItem => {
        ulItem.appendChild(newWithdrawalPurchasedItem(++itemCount, purchaseItem.material.brand, 
            purchaseItem.material.description, purchaseItem.unitCost, purchaseItem.quantityPurchased));
    });

    ulItem.appendChild(appendWithdrawalAddBtn());


    withdrawBody.innerHTML = `
        <h3>Purchase Information</h3>
        <div class="info">
            <div class="info-data">${dataItem.date}</div>
            <div class="info-data">${dataItem.service}</div>
        </div>
        <h5>Item(s) Sold</h5>
        <div class="card item-info item-box">
            <ul id="itemList"></ul>
            <!-- append ulItem here -->
        </div>
        <button id="submitWithdrawalBtn" class="btn btn-primary px-3" style="margin-top: 15px;">Submit</button>
    `;

    document.getElementById("itemList").parentElement.appendChild(ulItem);
    document.getElementById("submitWithdrawalBtn").addEventListener("click", createSubmitWithdrawalList(dataItem.id, dataItem.date));
}

function addToWithdrawalList() {
    let ul = document.getElementById("InputItemsList");
    let li = ul.getElementsByTagName("li");


    let lastItem = li[li.length - 1]; // because of zero index
    lastItem.setAttribute("id", li.length)
    let newItem = newWithdrawalPurchasedItem(li.length, "", "", );
    lastItem.innerHTML = newItem.innerHTML;

    ul.appendChild(appendWithdrawalAddBtn());
}

function appendWithdrawalAddBtn() {
    let liAddBtn = document.createElement("li");
    let button = document.createElement("button");
    let div = document.createElement("div");

    liAddBtn.setAttribute("id", "InputLiTemp")
    liAddBtn.setAttribute("class", "info withdraw-form")
    div.setAttribute("class", "withdraw-form");
    button.setAttribute("class", "btn btn-primary");
    button.setAttribute("id", "addWithdrawalRow");
    button.setAttribute("type", "submit");
    button.innerHTML = "+";
    button.addEventListener('click', addToWithdrawalList);

    div.appendChild(button);
    liAddBtn.appendChild(div);

    return liAddBtn;
}

function newWithdrawalPurchasedItem(listNum, brand, description, cost, quantity) {
    let itemListHtml = ""

    allMaterials.forEach(i => {
        itemListHtml += `<option matId="${i.materialId}" ${i.brand == brand && i.description == description ? "selected" : ""}>${i.brand} - ${i.description}</option>`
    });

    let liItem = document.createElement("li");
    liItem.setAttribute("id", `${listNum}`)
    liItem.setAttribute("class", "info withdraw-form")
    liItem.innerHTML = `
        <select class="form-control dropdown" id="InputType${listNum}" value="${brand} - ${description}">
            ${itemListHtml}
        </select>
        <input type="number" step="0.01" class="form-control value" id="InputCost${listNum}" aria-label="Cost" placeholder="Cost" value="${cost}">
        <input type="number" step="0.01" class="form-control value" id="InputAmount${listNum}" placeholder="Amount" value="${quantity}"> 
    `;

    return liItem;
}


// ===============+ API calls ====================

function convertDepositToJSON(element) {
    var output = [];
    let ul = element.childNodes
    
    for (var i = 0; i < ul.length-1; i++) {
        let filteredInput = jQuery(ul[i].childNodes).filter('*') // Removes text nodes
        //console.log("I is filtered", filteredInput)
        output.push({
            "prodId": filteredInput[1].options[filteredInput[1].selectedIndex].getAttribute('prodId'),
            "qty": filteredInput[2].value,
        });
    }
    return output;    
}

function convertWithdrawalsToJSON(element) {
    var output = [];
    let ul = element.childNodes
    
    for (var i = 0; i < ul.length-1; i++) {
        let filteredInput = jQuery(ul[i].childNodes).filter('*') // Removes text nodes
        output.push({
            "matId": filteredInput[0].options[filteredInput[0].selectedIndex].getAttribute('matId'),
            "cost": filteredInput[1].value,
            "qty": filteredInput[2].value,
        });
    }
    return output;    
}

async function getAllSales(transactionId) {
    let response = await fetch(`${BASE_URL}/sales?transactionId=${transactionId}`, {
        method: "GET",
        headers: {
            "Authorization": `Bearer ${sessionStorage.getItem("token")}`,
            "Accept": "application/json"
        }
    });

    let data = await response.json();

    if (!data._embedded) {
        return [];
    }

    return data._embedded.saleList;
}

async function getAllPurchases(transactionId) {
    let response = await fetch(`${BASE_URL}/purchases?transactionId=${transactionId}`, {
        method: "GET",
        headers: {
            "Authorization": `Bearer ${sessionStorage.getItem("token")}`,
            "Accept": "application/json"
        }
    });

    let data = await response.json();

    if (!data._embedded) {
        return [];
    }

    return data._embedded.purchaseList;
}

async function getAllProducts() {
    let response = await fetch(`${BASE_URL}/products`, {
        method: "GET",
        headers: {
            "Authorization": `Bearer ${sessionStorage.getItem("token")}`,
            "Accept": "application/json"
        }
    });

    let data = await response.json();

    if (!data._embedded) {
        return [];
    }

    return data._embedded.productList;
}

async function getAllMaterials() {
    let response = await fetch(`${BASE_URL}/materials`, {
        method: "GET",
        headers: {
            "Authorization": `Bearer ${sessionStorage.getItem("token")}`,
            "Accept": "application/json"
        }
    });

    let data = await response.json();

    if (!data._embedded) {
        return [];
    }

    return data._embedded.materialList;
}

function createSubmitDepositList(transactionId, date) {
    return function submitDepositList(event) {
        event.preventDefault;

        let root = document.getElementById("InputItemsList");
        let data = convertDepositToJSON(root);

        data.forEach(sale => {
            let body = JSON.stringify({
                transactionId: transactionId,
                date: Date.parse(date),
                quantitySold: sale["qty"]
            });

            fetch(`${BASE_URL}/sales/new?productId=${sale["prodId"]}`, {
                method: "POST",
                headers: {
                    "Authorization": `Bearer ${sessionStorage.getItem("token")}`,
                    "Accept": "application/json",
                    "Content-Type": "application/json"
                },
                body: body
            });
        });

        closePopup();
    }
}

function createSubmitWithdrawalList(transactionId, date) {
    return function submitWithdrawList(event) {
        event.preventDefault;

        let root = document.getElementById("InputItemsList");
        let data = convertWithdrawalsToJSON(root);

        data.forEach(purchase => {
            let body = JSON.stringify({
                transactionId: transactionId,
                date: Date.parse(date),
                quantityPurchased: purchase["qty"],
                unitCost: purchase["cost"]
            });

            fetch(`${BASE_URL}/purchases/new?materialId=${purchase["matId"]}`, {
                method: "POST",
                headers: {
                    "Authorization": `Bearer ${sessionStorage.getItem("token")}`,
                    "Accept": "application/json",
                    "Content-Type": "application/json"
                },
                body: body
            });
        });

        closePopup();
    }
}


(function() {

    let depositList = document.getElementById("depositList");
    
    data.forEach((item) => {
        let liItem = document.createElement("li");
        liItem.setAttribute("class", "info")
        liItem.setAttribute("id", `itemId${item.id}`)
        let dateText = `<span class="item">${item.date}</span>`
        let serviceText = `<span class="item fill">${item.service}</span>`
        let costText = `<span class="item">${item.cost}</span>`
        liItem.innerHTML = dateText + serviceText + costText;
        liItem.onclick = openPopup;
        depositList.appendChild(liItem);
    });

    withdrawData.forEach((item) => {
        let liItem = document.createElement("li");
        liItem.setAttribute("class", "info")
        liItem.setAttribute("id", `itemId${item.id}`)
        let dateText = `<span class="item">${item.date}</span>`
        let serviceText = `<span class="item fill">${item.service}</span>`
        let costText = `<span class="item">${item.cost}</span>`
        liItem.innerHTML = dateText + serviceText + costText;
        liItem.onclick = openWithdrawPopup;
        withdrawList.appendChild(liItem);
    });
    
    
    window.addEventListener("click",closeWindow);
      
})();


