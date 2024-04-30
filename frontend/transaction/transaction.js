'use strict'

let data = [
    {
        "id": 1,
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
        "id": 2,
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
        "id": 3,
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
        "id": 4,
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
        "id": 5,
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
        "id": 3,
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
        "id": 3,
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
        "id": 3,
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
        "id": 3,
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
        "id": 12.39,
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
        "id": 8.47,
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
        "id": 3,
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
        "id": 9,
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
        "id": 7,
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
        "id": 9,
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
        "id": 7,
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
        "id": 7,
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
        "id": 7,
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
        "id": 7,
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
                "cost": 19.45
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
    console.log(foundData, id, dataItem)
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

let currentDepositData = {}

function popupDeposit(dataItem) {
    currentDepositData = dataItem // override data everytime the popup opens
    let ulItem = document.createElement("ul");
    ulItem.setAttribute("id", "InputItemsList")
    ulItem.appendChild(appendDepositItem(1, dataItem.items));
    ulItem.appendChild(appendDepositAddBtn());

    let bodyText = `
        <h3>Sale Information</h3>
        <div class="info">
            <div class="info-data">${dataItem.date}</div>
            <div class="info-data">${dataItem.service}</div>
            <div class="info-data">${dataItem.cost}</div>
        </div>
        <h5>Item(s) Sold</h5>
        <div class="card item-info item-box">
            <ul id="itemList"></ul>
            ${ulItem.outerHTML}
        </div>
        <button id="submitDepositBtn" class="btn btn-primary px-3" style="margin-top: 15px;">Submit</button>
    `
    depositBody.innerHTML = bodyText;
    addDepositRow.addEventListener("click", addToDepositList);
    submitDepositBtn.addEventListener("click", submitDepositList);
}

function addToDepositList() {
    let ul = document.getElementById("InputItemsList");
    let li = ul.getElementsByTagName("li");

    let lastItem = li[li.length - 1]; // because of zero index
    let newItem = appendDepositItem(li.length, currentDepositData.items);
    lastItem.innerHTML = newItem.innerHTML;

    ul.appendChild(appendDepositAddBtn());
    addDepositRow.addEventListener("click", addToDepositList); 
}

function appendDepositItem(id, itemList) {
    let itemListHtml = "";
    itemList.forEach(i => { itemListHtml += `<option>${i.desc}</option>`});

    let liItem = document.createElement("li");
    liItem.setAttribute("id", `${id}`)
    liItem.setAttribute("class", "info withdraw-form")
    liItem.innerHTML = `
        <div style="padding: 3px 15px 0 0;">${id}.</div>
        <select class="form-control dropdown" id="InputType${id}">
            ${itemListHtml}
        </select>
        <input type="number" class="form-control value" id="InputAmount${id}" placeholder="Amount"> 
    `;
    return liItem;
}

function appendDepositAddBtn() {
    let liAddBtn = document.createElement("li");
    liAddBtn.setAttribute("class", "info withdraw-form")
    liAddBtn.innerHTML = `
        <div class="withdraw-form">
            <button class="btn btn-primary" id="addDepositRow" type="submit">+</button>
        </div>
    `;
    return liAddBtn;
}

// ======= Withdrawl List ========================

let currentWithdrawlData = [];

function popupWithdraw(dataItem) {
    currentWithdrawlData = dataItem.items; // Overwrite data everytime popup opens
    let ulItem = document.createElement("ul");
    ulItem.setAttribute("id", "InputItemsList")
    ulItem.appendChild(appendWithdrawlItem(1, dataItem.items));
    ulItem.appendChild(appendWithdrawlAddBtn());


    let bodyText = `
        <h3>Purchase Information</h3>
        <div class="info">
            <div class="info-data">${dataItem.date}</div>
            <div class="info-data">${dataItem.service}</div>
        </div>
        <h5>Item(s) Sold</h5>
        <div class="card item-info item-box">
            <ul id="itemList"></ul>
            ${ulItem.outerHTML}
        </div>
        <button id="submitWithdrawlBtn" class="btn btn-primary px-3" style="margin-top: 15px;">Submit</button>
    `
    withdrawBody.innerHTML = bodyText;
    addWithdrawlRow.addEventListener("click", addToWithdrawlList);
    submitWithdrawlBtn.addEventListener("click", submitWithdrawList);
}

function addToWithdrawlList() {
    let ul = document.getElementById("InputItemsList");
    let li = ul.getElementsByTagName("li");


    let lastItem = li[li.length - 1]; // because of zero index
    lastItem.setAttribute("id", li.length)
    let newItem = appendWithdrawlItem(li.length, currentWithdrawlData.items);
    lastItem.innerHTML = newItem.innerHTML;

    ul.appendChild(appendWithdrawlAddBtn());
    addWithdrawlRow.addEventListener("click", addToWithdrawlList);

}

function appendWithdrawlAddBtn() {
    let liAddBtn = document.createElement("li");
    liAddBtn.setAttribute("id", "InputLiTemp")
    liAddBtn.setAttribute("class", "info withdraw-form")
    liAddBtn.innerHTML = `<button class="btn btn-primary" id="addWithdrawlRow" type="submit">+</button>`;
    return liAddBtn;
}

function appendWithdrawlItem(id, itemList) {
    let itemListHtml = ""
    itemList.forEach(i => {
        console.log(i);
        itemListHtml += `<option>${i.desc}</option>`
    })

    let liItem = document.createElement("li");
    liItem.setAttribute("id", `${id}`)
    liItem.setAttribute("class", "info withdraw-form")
    liItem.innerHTML = `
        <select class="form-control dropdown" id="InputType${id}">
            ${itemListHtml}
        </select>
        <input type="number" class="form-control value" id="InputCost${id}" aria-label="Cost" placeholder="Cost">
        <input type="number" class="form-control value" id="InputAmount${id}" placeholder="Amount"> 
    `;

    return liItem;
}


// ===============+ API calls ====================

function convertDepositToJSON(element) {
    var output = [];
    let ul = element.childNodes
    console.log("meee", element)
    
    for (var i = 0; i < ul.length-1; i++) {
        let filteredInput = jQuery(ul[i].childNodes).filter('*') // Removes text nodes
        console.log("I is filtered", filteredInput)
        output.push({
            "desc": filteredInput[1].value,
            "qty": filteredInput[2].value,
        });
    }
    return output;    
}

function convertWithdrawlsToJSON(element) {
    var output = [];
    let ul = element.childNodes
    
    for (var i = 0; i < ul.length-1; i++) {
        let filteredInput = jQuery(ul[i].childNodes).filter('*') // Removes text nodes
        output.push({
            "type": filteredInput[0].value,
            "cost": filteredInput[1].value,
            "amount": filteredInput[2].value,
        });
    }
    return output;    
}

function submitDepositList() {
    let root = document.getElementById("InputItemsList");
    let depositOutput = convertDepositToJSON(root)
    console.log(depositOutput);

    // FIXME: Implement API route here
    // NOTE: need to build the json payload
    // {
    //     "id": 1,
    //     "orderInfo": [
    //         {
    //             "desc": 'Flower bookmark', 
    //             "qty": '3
    //         },
    //         {
    //             "desc": 'Enchanted bookmark', 
    //             "qty": '5'
    //         },
    //     ]
    // }

    let data = {
        "id": currentDepositData.id,
        "orderInfo": depositOutput
    }

    closePopup()
}

function submitWithdrawList() {
    let root = document.getElementById("InputItemsList");
    let withdrawalOutput = convertWithdrawalToJSON(root)
    console.log(withdrawalOutput);

    // FIXME: Implement API route here
    // NOTE: need to build the json payload
    // {
    //     "id": 1,
    //     "orderInfo": [
    //         {
    //             "desc": 'Black yarn', 
    //             "qty": '2'
    //             "cost": '24.55'
    //         },
    //         {
    //             "desc": 'Pink yarn', 
    //             "qty": '4'
    //             "cost": '32.44'
    //         },
    //     ]
    // }

    let data = {
        "id": currentWithdrawlData,
        "orderInfo": withdrawalOutput
    }
    closePopup()
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


