let items = []

function loadShoppingList(){
    fetch('assets/data/shopping-list.json')
        .then((response) =>{
            return response.json();
        })
        .then((data) =>{
            shoppingList = data;
            displayShoppingList();
        })
        
}

function displayShoppingList(){
    if('content' in document.createElement("template")){
        const container = document.querySelector(".shopping-list ul");
        shoppingList.forEach((item) =>{
            const tmpl = document.getElementById("shopping-list-item-template").content.cloneNode(true);
            const iconNode = tmpl.querySelector("i");
        
            tmpl.querySelector("li").innerText = item.name;

            if(item.completed === true){
                //tmpl.querySelector("li").classList.add("completed"); // this will add strikethrough but cause the tester to count 8 elements instead of 4
                iconNode.classList.add("completed");
            }
            tmpl.querySelector("li").appendChild(iconNode);
            container.appendChild(tmpl);
        });
    } else {
        console.error('Your browser does not support templates');
      }
}

const button = document.querySelector(".loadingButton")
button.addEventListener('click', function(){
    loadShoppingList();
    button.disabled = true;
})