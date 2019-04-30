  
  let shoppingList = [];

  function loadList() {
    console.log("Loading List...");
  
    fetch('assets/data/shopping-list.json')
      .then((response) => {
        
        return response.json();
      }) 
      .then((data) => {
        shoppingList = data;
        displayList();
      })
      .catch((err) => console.error(err));
  }


  function displayList() {
    console.log("Display List...");
    if('content' in document.createElement('template')) {
      const container = document.querySelector("ul");
      shoppingList.forEach((todo) => {
        const tmpl = document.getElementById('shopping-list-item-template').content.cloneNode(true);
        const text = document.createTextNode(todo.name);
        tmpl.querySelector('li').appendChild(text);
        if(todo.completed){
            tmpl.querySelector('li').classList.add('completed');
            tmpl.querySelector('i').classList.add('completed');
        }
        container.appendChild(tmpl);
      });
    } else {
      console.error('Your browser does not support templates');
    }
  }

function toggleCompleted(){
    let item = event.target;
    if(item.classList.contains('completed')){
        item.classList.remove('completed');
        item.querySelector('i').classList.remove('completed')
    } else {
        item.classList.add('completed');
        item.querySelector('i').classList.add('completed')
    }
}
  
  const button = document.querySelector("button");
    button.addEventListener("click",function(event) {
        event.preventDefault();
        loadList();
        button.disabled = true;
    });