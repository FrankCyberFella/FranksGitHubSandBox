// add pageTitle
const title = 'My Shopping List';
const groceries = [
  'milk',
  'bread',
  'butter',
  'eggs',
  'cereal',
  'cookies',
  'coffee',
  'beef',
  'chicken',
  'fruit',
];
// add groceries
 
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
  const list = document.querySelector('.shopping-list ul');
  groceries.forEach((item) => {
    const li = document.createElement('li');
    li.innerText = item;
    list.appendChild(li);
  });
}

/**
 * This function will be called when the button is clicked. You will need to get a reference
 * to every list item and add the class completed to each one
 */
function markCompleted() {
  const list = document.querySelector('.shopping-list ul');
  const listItems = Array.from(list.children);

  listItems.forEach((item) => {
    item.setAttribute('class', 'completed');
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
