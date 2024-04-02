


/// create our click event listener
function openPopup(e) {
    /// fallback support for IE events
    if ( !e ){ e = window.Event };
    /// fallback support for IE .srcElement
    // alert( 'Clicked! ' + ( e.target ? e.target : e.srcElement ) );
    console.log(this)
    console.log(e)
    depositPopup.classList.add("show");
}

function closePopup() {
    depositPopup.classList.remove(
        "show"
    );
}

function closeWindow(event) {
    if (event.target == depositPopup) {
        depositPopup.classList.remove(
            "show"
        );
    }
}

function popupDeposit(dataItem) {
    
    let ulItem = document.createElement("ul");
    dataItem.items.forEach((item,i) => {
        let liItem = document.createElement("li");
        liItem.setAttribute("class", "info")
        // ulItem.appendChild = liItem;
        liItem.innerHTML = `${i+1}.<span class="card item fill">${item.desc}</span> <span class="card item">${item.qty}</span>`;
        console.log(liItem)
        ulItem.appendChild(liItem);
    })
    
    console.log(ulItem)

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
    closeDepositPopup.addEventListener("click", closePopup);

   
}


(function() {

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
                }
            ]
        },
        {
            "id": 2,
            "date": "04/20/24",
            "service": "Micheals Stores",
            "cost": 942.69,
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
            "service": "Facebook",
            "cost": 324.35,
            "items": [
                {
                    "desc": "printers print",
                    "qty": 1,
                    "cost": 23.42
                },
                {
                    "desc": "ink",
                    "qty": 9,
                    "cost": 2.42
                },
                {
                    "desc": "paper",
                    "qty": 9,
                    "cost": 33.42
                },
                {
                    "desc": "color paper",
                    "qty": 3,
                    "cost": 50.42
                }
            ]
        },
        {
            "id": 4,
            "date": "04/20/24",
            "service": "Ebay",
            "cost": 3415.69,
            "items": [
                {
                    "desc": "Gameboy",
                    "qty": 1,
                    "cost": 244.42
                },
                {
                    "desc": "Switch",
                    "qty": 2,
                    "cost": 400.00
                }
            ]
        },
        {
            "id": 3,
            "date": "04/20/24",
            "service": "Paypal",
            "cost": 4532.69,
            "items": [
                {
                    "desc": "Bitcoin",
                    "qty": 1,
                    "cost": 909832.42
                },
                {
                    "desc": "Ethereum",
                    "qty": 20,
                    "cost": 223423.42
                }
            ]
        }
        
    ]
    let depositList = document.getElementById("depositList");
    
    data.forEach((item) => {

        let liItem = document.createElement("li");
        liItem.setAttribute("class", "info")
        let dateText = `<span class="item">${item.date}</span>`
        let serviceText = `<span class="item fill">${item.service}</span>`
        let costText = `<span class="item">${item.cost}</span>`
        liItem.innerHTML = dateText + serviceText + costText;
        liItem.onclick = openPopup;
        depositList.appendChild(liItem);
    });

    data.forEach((item) => {

        let liItem = document.createElement("li");
        liItem.setAttribute("class", "info")
        let dateText = `<span class="item">${item.date}</span>`
        let serviceText = `<span class="item fill">${item.service}</span>`
        let costText = `<span class="item">${item.cost}</span>`
        liItem.innerHTML = dateText + serviceText + costText;
        liItem.onclick = openPopup;
        withdrawList.appendChild(liItem);
    });
    
    
    window.addEventListener("click",closeWindow);

    var elems = document.getElementsByTagName('li');
    Array.from(elems).forEach((v,i) => v.addEventListener('click', function() {
        popupDeposit(data[i])
    }));
    
    
    
})();


