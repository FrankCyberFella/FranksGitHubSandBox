let items = [];

function gatherItems() {

    console.log('Items Gathered!');

    fetch('./assets/data/shopping-list.json')
    .then((response) => {
        return response.json();
    })
    .then((data) => {
        items = data;
        displayItems();
    })
}

function displayItems() {
    console.log('Items Displayed!');

if('content' in document.createElement('template')) {   
    const container = document.querySelector('.shopping-list'); 
    items.forEach((item) => {
        const template = document.getElementById('shopping-list-item-template').content.cloneNode(true);
        template.querySelector('li').innerText = item.name;
        if(item.completed == true){
            template.querySelector('li').classList.add('completed');
        }
        template.querySelector('li').classList.add(item.completed);
        container.appendChild(template);
    })
    }
}

const button = document.querySelector("a");
  button.addEventListener("click",function() { 
      if(items.length == 0) {
        gatherItems();
        button.disabled = true;
      }
});