// add pageTitle
let pageName = 'My Shopping List';
// add groceries
let groceries = ['chicken','broccoli', 'napkins','ground beef', 'peanut butter', 'grapes', 'green beans', 'carrots','sausage','eggs'];

/**
 * This function will get a reference to the title and set its text to the value
 * of the pageTitle variable that was set above.
 */
function setPageTitle() {
  const pageTitle = document.getElementById('title');
  pageTitle.innerText = pageName;
}

/**
 * This function will loop over the array of groceries that was set above and add them to the DOM.
 */
function displayGroceries() {
const shoppingList = document.querySelector('.shopping-list ul');
groceries.forEach((grocery) =>{
  let itemName = grocery.replace(' ','');
  const groceryLi = document.createElement('li');
  groceryLi.setAttribute('id',itemName);                    // each grocery will have an li class with its name? issue with spaces in class name
  groceryLi.innerText = grocery;
  shoppingList.appendChild(groceryLi);
});
}

/**
 * This function will be called wh4en the button is clicked. You will need to get a reference
 * to every list item and add the class completed to each one
 */
function markCompleted() {
  groceries.forEach((grocery) =>{
    let itemName = grocery.replace(' ', '');
    document.getElementById(itemName).classList.add('completed');
    //document.getElementById(itemName).setAttribute('class','completed');
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
