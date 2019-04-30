// add pageTitle
const pageTitle = 'My Shopping List';
// add groceries
let groceries = [
 'beans',
 'bread',
 'bagels',
 'bacon',
 'beer',
 'bananas',
 'brine',
 'boar',
 'beets',
 'butter'
]
/**
 * This function will get a reference to the title and set its text to the value
 * of the pageTitle variable that was set above.
 */
function setPageTitle() {
 document.getElementById('title').innerText = pageTitle;
}

/**
 * This function will loop over the array of groceries that was set above and add them to the DOM.
 */
function displayGroceries() {
groceries.forEach((item) => {
const listElement = document.createElement('li');
listElement.innerText = item;
document.querySelector('ul').appendChild(listElement);


});
}
/**
 * This function will be called wh4en the button is clicked. You will need to get a reference
 * to every list item and add the class completed to each one
 */
function markCompleted() {
  items = document.querySelectorAll('li').forEach((item) =>
  {
    item.classList.add('completed')
  });
}

setPageTitle();

displayGroceries();

// Don't worry too much about what is going on here, we will cover this when we discuss events.
document.addEventListener('DOMContentLoaded', () => {
  // When the DOM Content has loaded attach a click listener to the button
  const button = document.querySelector('.btn');
  button.addEventListener('click', markCompleted);

  document.querySelectorAll('li').forEach((item) => {
    item.addEventListener('click', () => {
      if( !item.classList.contains('completed')){
        item.classList.add('completed');
      } 
      item.addEventListener('dblclick', () => {
        if(item.classList.contains('completed')){
          item.classList.remove('completed');
      }
      
    })
  })

})});
