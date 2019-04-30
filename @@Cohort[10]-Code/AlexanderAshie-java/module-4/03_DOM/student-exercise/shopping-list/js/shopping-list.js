// add pageTitle
pageTitle = "My Shopping List";

// add groceries
groceries = ["Apple", "Orange", "Banana", "Pear", "Kiwi", "Tomato", "Onion", "Carrot", "Celery", "Pepper"];

/**
 * This function will get a reference to the title and set its text to the value
 * of the pageTitle variable that was set above.
 */
function setPageTitle() {
  const docPageTitle = document.getElementById("title");
  docPageTitle.innerText = pageTitle;
}

/**
 * This function will loop over the array of groceries that was set above and add them to the DOM.
 */
function displayGroceries() {
  const groceryUlHolder = document.querySelector(".shopping-list ul");
  groceries.forEach((item) => {
    const newListItem = document.createElement("li");
      newListItem.innerText = item;
      groceryUlHolder.appendChild(newListItem);
  });
}

/**
 * This function will be called wh4en the button is clicked. You will need to get a reference
 * to every list item and add the class completed to each one
 */

function markCompleted() {
  const listItems = document.querySelectorAll("li");

  listItems.forEach((item) => {
    item.setAttribute("class", "completed");
  })

}

setPageTitle();

displayGroceries();

// Don't worry too much about what is going on here, we will cover this when we discuss events.
document.addEventListener('DOMContentLoaded', () => {
  // When the DOM Content has loaded attach a click listener to the button
  const button = document.querySelector('.btn');
  button.addEventListener('click', (event) => {
    markCompleted();
  });
});
