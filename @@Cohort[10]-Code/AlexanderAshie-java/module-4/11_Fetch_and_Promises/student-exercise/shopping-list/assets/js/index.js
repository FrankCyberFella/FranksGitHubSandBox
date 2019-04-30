let shoppingList = [];

function loadReviews() {
    fetch('assets/data/shopping-list.json')
        .then((response) => {
            return response.json();
        })
        .then((data) => {
            shoppingList = data;
            displayReviews();
        });
}

function displayReviews() {

    shoppingList.forEach((item) => {
        console.log(item.name);
    });


    if('content' in document.createElement('template')) {

        const container = document.querySelector('.shopping-list ul')

        shoppingList.forEach((item) => {
            const tmpl = document.getElementById('shopping-list-item-template').content.cloneNode(true);
            const iNode = tmpl.querySelector('i');

            tmpl.querySelector('li').innerText = item.name;

            if (item.completed === true) {
                iNode.classList.add('completed');
            }
            
            tmpl.querySelector('li').appendChild(iNode);
            container.appendChild(tmpl);

        });
    } else {
      console.error('Your browser does not support templates');
    }
  }

  const loadButton = document.querySelector('.loadingButton')

  loadButton.addEventListener('click', () => {
    loadReviews();
  });