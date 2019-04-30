// add pageTitle
const title = 'My Shopping List';
// add groceries
const groceries = [
   'Bananas','Cereal','Steak','Bread','Chicken','Lettuce',
   'Cherries','Ketchup','Mustard','Carrots'
  ];

/**
 * This function will get a reference to the title and set its text to the value
 * of the pageTitle variable that was set above.
 */
function setPageTitle() {
const pageTitle = document.getElementById('title');
pageTitle.innerText = title;
}

/**
 * This function will loop over the array of groceries that was set above and add them to the DOM.
 */
function displayGroceries() {
const groceryList = document.querySelector('.shopping-list ul');
groceries.forEach((item) => {
const listItem = document.createElement('li');
listItem.innerText = item;
groceryList.appendChild(listItem);
});

}

/**
 * This function will be called wh4en the button is clicked. You will need to get a reference
 * to every list item and add the class completed to each one
 */
function markCompleted() {
const list = document.querySelector('.shopping-list ul');
const listItem = Array.from(list.children);

listItem.forEach((list)=> {
list.setAttribute('class','completed');

})



}

setPageTitle();

displayGroceries();

// Don't worry too much about what is going on here, we will cover this when we discuss events.
document.addEventListener('DOMContentLoaded', () => {
  // When the DOM Content has loaded attach a click listener to the button
  const button = document.querySelector('.btn');
  button.addEventListener('click', markCompleted);
});
