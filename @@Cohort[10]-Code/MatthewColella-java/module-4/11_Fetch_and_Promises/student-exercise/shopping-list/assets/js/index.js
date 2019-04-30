let items = [];

function loadItems() {
  console.log("Load Items...");

  fetch('./assets/data/shopping-list.json') //giving it a data source
    .then((response) => { //once the data is loaded
      return response.json();
    })
    .then((data) => {
      items = data;
      displayItems();
    })
    .catch((err) => console.error(err));
}


function displayItems() {
    console.log("Display Items...");
    if('content' in document.createElement('template')) { //if there is indeed a template in the html
        const container = document.querySelector(".shopping-list");
        items.forEach((item) => {
          const tmpl = document.getElementById('shopping-list-item-template').content.cloneNode(true);
          if(item.completed == true){
            tmpl.querySelector('li').setAttribute("class", "completed");
          }
          tmpl.querySelector('li').innerText = item.name;
          container.appendChild(tmpl);
        });
      } else {
        console.error('Your browser does not support templates');
      }
}

const button = document.querySelector('a');
button.addEventListener("click", function() {
    if(items.length == 0){
    loadItems();
    button.disabled = true;
}
});