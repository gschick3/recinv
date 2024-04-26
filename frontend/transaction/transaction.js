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
        "service": "Etsy",
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

function popupDeposit(dataItem) {
    
    let ulItem = document.createElement("ul");
    dataItem.items.forEach((item,i) => {
        let liItem = document.createElement("li");
        liItem.setAttribute("class", "info")
        liItem.innerHTML = `${i+1}.<span class="card item fill">${item.desc}</span> <span class="card item">${item.qty}</span>`;
        ulItem.appendChild(liItem); 
    });

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
        <button id="closeDepositPopup">OK</button>
    `
    depositBody.innerHTML = bodyText;
    addRow.addEventListener("click", addToList);
    closeDepositPopup.addEventListener("click", closePopup);
}

function popupWithdraw(dataItem) {
    
    let ulItem = document.createElement("ul");
    ulItem.setAttribute("id", "InputItemsList")
    ulItem.appendChild(appendItem(1));
    ulItem.appendChild(appendAddBtn());


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
        <button id="closeWithdrawPopup">OK</button>
    `
    withdrawBody.innerHTML = bodyText;
    addRow.addEventListener("click", addToList);
    closeWithdrawPopup.addEventListener("click", closePopup); // TODO: Make this an OK button and grab all value for submission
}

function addToList() {
    let ul = document.getElementById("InputItemsList");
    let li = ul.getElementsByTagName("li");

    let lastItem = li[li.length - 1]; // because of zero index
    let newItem = appendItem(li.length);
    lastItem.innerHTML = newItem.innerHTML;

    ul.appendChild(appendAddBtn());
    addRow.addEventListener("click", addToList); 

}

function appendItem(id) {
    let liItem = document.createElement("li");
    liItem.setAttribute("class", "info")
    liItem.innerHTML = `
        <div class="withdraw-form">
            <select class="form-control dropdown" id="InputType${id}">
                <option>1</option>
                <option>2</option>
                <option>3</option>    
                <option>4</option>
                <option>5</option>  
            </select>
            <input type="number" class="form-control value" id="InputCost${id}" aria-label="Cost" placeholder="Cost">
            <input type="number" class="form-control value" id="InputAmount${id}" placeholder="Amount">
        </div>
    `;

    return liItem;
}

function appendAddBtn() {
    let liAddBtn = document.createElement("li");
    liAddBtn.setAttribute("class", "info")
    liAddBtn.innerHTML = `
        <div class="withdraw-form">
            <button class="btn btn-primary" id="addRow" type="submit">+</button>
        </div>
    `;
    return liAddBtn;
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


