let aList = [];

function loadList(){
    fetch('assets/data/shopping-list.json')
    .then((response) => {
        return response.json();
    })
    .then((data) => {
        aList = data;
        displayList();
    })
    .catch((error) => console.log(error));
}


function displayList(){
    console.log("Display List...");

    if('content' in document.createElement('template')){
        const container = document.querySelector(".shopping-list ul");
        aList.forEach((item) => {
            const tmpl = document.getElementById('shopping-list-item-template').content.cloneNode(true);
            listItem = tmpl.querySelector('li');
            listItem.firstChild.nodeValue = item.name;
           // tmpl.querySelector('li').innerText = item.name;
            if(item.completed === true){
                const element = tmpl.querySelector('li')
                element.classList.add("completed");
            }
            
            container.appendChild(tmpl);
        });
    } else {
        console.error('Your browser does not support templates');
    }
}


const button =  document.querySelector(".loadingButton");
    button.addEventListener("click", function(){
        loadList();
    });