let list = [];

function loadList() {
    console.log("Load List...");

    fetch('assets/data/shopping-list.json')
    .then((response) => {
        return response.json();
    })
    .then((data) => {
        list = data;
        displayList();
    })
    .catch((err) => console.error(err));
}

function displayList() {
    console.log("Display List...");

    if('content' in document.createElement('template')) {
        const container = document.querySelector(".shopping-list ul");
        list.forEach((item) => {
            const tmpl = document.getElementById('shopping-list-item-template').content.cloneNode(true);
            const listItem = tmpl.querySelector('li');
            listItem.firstChild.nodeValue = item.name;
            if(item.completed === true){
                const element = tmpl.querySelector('li')
                element.classList.add("completed");
            }
            container.appendChild(tmpl);
        });
    } else {
        console.error('Your browser does not support templates')
    }

}

const button = document.querySelector(".loadingButton");
  button.addEventListener("click",function() {  // When the button is clicked...
  loadList();                                // run the loadReviews() method
  
});