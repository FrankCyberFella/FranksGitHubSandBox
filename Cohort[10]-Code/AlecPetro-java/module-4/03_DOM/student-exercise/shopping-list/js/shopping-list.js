// add pageTitle
let pageTitle = 'My Shopping List'
// add groceries
let groceries = ['Soy Milk', 'Oats', 'Butter', 'Bananas', '50/50 Salad',
                'Peanut Butter', 'Eggs', 'BBQ Sauce', 'Coffee', ' Cucumbers'];
/**
 * This function will get a reference to the title and set its text to the value
 * of the pageTitle variable that was set above.
 */
function setPageTitle() {
  const heading = document.getElementById('title');
  heading.innerText = pageTitle;
}

/**
 * This function will loop over the array of groceries that was set above and add them to the DOM.
 */
function displayGroceries() {
  groceries.forEach(item => {
    let newListItem = document.createElement('li');
    document.querySelector('.shopping-list ul').appendChild(newListItem);
    newListItem.innerText = item;
  });

}

/**
 * This function will be called wh4en the button is clicked. You will need to get a reference
 * to every list item and add the class completed to each one
 */
function markCompleted() {
  let ul = document.querySelector('.shopping-list ul');
  let itemsArray = Array.from(ul.children);
   itemsArray.forEach(item => {
    item.setAttribute('class', 'completed');
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
