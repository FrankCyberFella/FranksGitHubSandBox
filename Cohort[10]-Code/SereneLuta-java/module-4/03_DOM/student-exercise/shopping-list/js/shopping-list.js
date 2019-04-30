// add pageTitle
const pageTitle = 'My Shopping List';
// add groceries
let groceries = ['bread','almond milk', 
                 'eggs', 'water', 
                 'cashewgurt', 'Rebl drinks', 
                 'ice cream', 'fruit',
                 'veggies', 'hummus'];
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
  const mainDiv = document.querySelector('html body div.shopping-list ul')
  groceries.forEach((anItem) => {
  const liItem = document.createElement('li');
  liItem.innerText = anItem;
  mainDiv.appendChild(liItem);

  });
}

/**
 * This function will be called when the button is clicked. You will need to get a reference
 * to every list item and add the class completed to each one
 */
function markCompleted() {
  const liSelectAll = document.querySelectorAll('li');
  liSelectAll.forEach((anItem) => {
    anItem.setAttribute('class','completed')
  });
}

setPageTitle();

displayGroceries();

// Don't worry too much about what is going on here, we will cover this when we discuss events.
document.addEventListener('DOMContentLoaded', () => {
  // When the DOM Content has loaded attach a click listener to the button
  const button = document.querySelector('.btn');
  button.addEventListener('click', markCompleted);
});
