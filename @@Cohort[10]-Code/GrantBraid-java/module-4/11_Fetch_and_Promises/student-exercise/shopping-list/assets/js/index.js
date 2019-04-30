
let items = [];

function gatherItems() {
    console.log('in gatherItems()')
    fetch('./assets/data/shopping-list.json')
    .then((response) => {
        return response.json();
    }).then((data) => {
        items = data
        displayItems();
    });
}

function displayItems() {
    if('content' in document.createElement('template')) {   // if there is a <template> in the html
        const container = document.querySelector(".shopping-list"); // get a reference to the element with class reviews
        items.forEach((item) => {                           // loop through each element
            const tmpl = document.getElementById('shopping-list-item-template').content.cloneNode(true);
            tmpl.querySelector('li').innerText = item.name;

            if (item.completed == true){
                tmpl.querySelector('li').classList.add('completed');
            } else {
                tmpl.querySelector('li').classList.add('incomplete');
            }
            
            container.appendChild(tmpl);
        })
                                    
    }
}


const button = document.querySelector("a");
  button.addEventListener("click",function() {  //When the button is clicked..
    if (items.length == 0) {
        gatherItems();                                // run the loadReviews() method
        button.disabled = true; 
    } 
});