let items = [];

function gatherItems() {
    fetch('./assets/data/shopping-list.json')
    .then((response) => {
        return response.json();
    })
    .then((data) => {
     items=data
     displayItems();  
    });
}
function displayItems() {
    console.log("Display Reviews...");

if('content' in document.createElement('template')) {    // if there is a template in the HTML
    const container = document.querySelector(".shopping-list");  // get a reference to the element with class "reviews"
    items.forEach((item) => {                          // loop through each element 
      const tmpl = document.getElementById('shopping-list-item-template').content.cloneNode(true); // get a reference to the review-template
      tmpl.querySelector('li').innerText = item.name;
      
      if(item.completed == true){
        tmpl.querySelector('li').classList.add('completed');
      }else{
        tmpl.querySelector('li').classList.add('incomplete');
      }
      container.appendChild(tmpl);                         // add the element to the DOM
    });
  } else {
    console.error('Your browser does not support templates');
  }
}


const button = document.querySelector("a");
  button.addEventListener("click",function() {
   if(items.length == 0) {
       gatherItems();
       button.disabled = true; 
   }    
                    
});