
let items = [];
loadList();
function loadList() {
  fetch('./assets/data/shopping-list.json') 
    .then((response) => {
      return response.json();
    })
.then((data) => {
    items = data;
    const button = document.querySelector('.loadingButton');
    button.addEventListener("click",function() {
    displayList();  
    button.disabled = true;
})
.catch((err) => console.error(err));
});

}
function displayList() {
    if('content' in document.createElement('template')) {
      const list = document.querySelector("ul");
      items.forEach((item) => {
        const tmpl = document.getElementById('shopping-list-item-template').content.cloneNode(true);
        tmpl.querySelector("li").insertAdjacentHTML('afterbegin',item.name);
        console.log(item.name);
        if( item.completed ) {
          const circleCheck = tmpl.querySelector('.fa-check-circle');
          circleCheck.className += " completed";
        }
        list.appendChild(tmpl);
      });
    } else {
      console.error('Your browser does not support templates');
    }
  }




// fetch('./assets/data/shopping-list.json')
//   .then((response) => {
//     return response.json();
//   })
//  .then( (items) => {
//       const list = document.querySelector("ul");
//       items.forEach( (item) => {
//         const tmpl = document.getElementById('shopping-list-item-template').content.cloneNode(true);
//         tmpl.querySelector("li").insertAdjacentHTML('afterbegin',item.name);
//           node.appendChild(document.createTextNode(item.name));
//           if(item.completed) {
//               node.classname = "completed";
//           } else {
//               node.classname = "incomplete";
//           }
//           list.appendChild(tmpl);
//       });
//   });
  



