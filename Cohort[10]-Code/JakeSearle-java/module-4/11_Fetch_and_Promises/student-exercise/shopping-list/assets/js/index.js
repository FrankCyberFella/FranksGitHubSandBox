
let items = [];

function gatherItems() {
    fetch('./assets/data/shopping-list.json')
    .then((response) => {
        return response.json();
    }).then((data) => {
        items = data;
        displayItems()
    });
}

function displayItems() {
    if('content' in document.createElement('template')) {
      const container = document.querySelector(".shopping-list");
      items.forEach((item) => {
          const tmpl = document.getElementById('shopping-list-item-template').content.cloneNode(true);
          tmpl.querySelector('li').innerText = item.name;

          if(item.completed == true) {
          tmpl.querySelector('li').classList.add('completed');
          } else {
              tmpl.querySelector('li').classList.add('incomplete');
          }
          container.appendChild(tmpl);
      })
    }
}

const button = document.querySelector("a");
  button.addEventListener("click",function() {
    if (items.length == 0) {
        gatherItems();
        button.disabled = true;
    }
});