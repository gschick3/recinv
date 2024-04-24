//issue with applying to all buttons
//if more than one button with ID, will only grab the first one
//if use getElementsByClassName, doesn't work
//might be good to use tags? will see 
const editButton = document.getElementById('editButton');

editButton.addEventListener('click', function handleClick() {
    editButton.innerHTML = 
    '<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-check-circle-fill" viewBox="0 0 16 16"><path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0m-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/></svg>';
});


const addButton = document.getElementById('addButton');

addButton.addEventListener('click', function handleClick(){
    //place code to add row to table
    //place code to send info to database
});

