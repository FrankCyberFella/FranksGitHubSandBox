// add pageTitle

  const pageTitle = 'My Shopping Basket';


// add groceries
const groceries = [ 'Triscuits', 'Cheddar Cheese', 'Milk', 'Ribeye Steak', 'Butter', 'Green Beans',
                  'Spinach', 'Sponges', 'Salt', 'Spaghetti'];



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
  const groceryList = document.querySelector('.shopping-list ul');
  groceries.forEach( (aGroceryItem) => {
  const newListItem = document.createElement('li');
  newListItem.innerText = aGroceryItem;
  groceryList.appendChild(newListItem);

  })
}

/**
 * This function will be called when the button is clicked. 
 * You will need to get a reference
 * to every list item and add the class completed to each one
 */
function markCompleted() {
  const allListItems = document.querySelectorAll('li');
  allListItems.forEach( (listItem) => {
    listItem.setAttribute('class', 'completed');
  });
}

setPageTitle();

displayGroceries();

// Don't worry too much about what is going on here, we will cover this 
// when we discuss events.
document.addEventListener('DOMContentLoaded', () => {
  // When the DOM Content has loaded attach a click listener to the button
  const button = document.querySelector('.btn');
  button.addEventListener('click', markCompleted);
});
