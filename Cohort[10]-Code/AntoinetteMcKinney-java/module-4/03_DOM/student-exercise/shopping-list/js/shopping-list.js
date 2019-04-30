// add pageTitle
let pageTitle = 'My Shopping List'
// add groceries
let groceries = [apples, carrots, pickles, quiona, flaxSeeds, goji, rice, almond, corn, shrimp]; 

/**
 * This function will get a reference to the title and set its text to the value
 * of the pageTitle variable that was set above.
 */
function setPageTitle() {
  // const pageTitle = document.getElementById('page-title');
  pageTitle.querySelector('title').innerHTML = pageTitle;
}
/**
 * This function will loop over the array of groceries that was set above and add them to the DOM.
 */
function displayGroceries() {}
if ('content' in document.createElement('template')) {
  const main = document.getElementById('shopping-list');
  
  groceries.forEach((item) => {
    const tmpl = document.getElementById('shopping-template').content.cloneNode(true);
    const li = document.createElement('li');
    li.innerText = item;
    tmpl.querySelector('li').innerHTML = item;
  
    main.appendChild(tmpl);
  });
} else {
  console.error('Your browser does not support templates');
}
/**
 * This function will be called wh4en the button is clicked. You will need to get a reference
 * to every list item and add the class completed to each one
 */
function markCompleted() {}

setPageTitle();

displayGroceries();

// Don't worry too much about what is going on here, we will cover this when we discuss events.
document.addEventListener('DOMContentLoaded', () => {
  // When the DOM Content has loaded attach a click listener to the button
  const button = document.querySelector('.btn');
  button.addEventListener('click', markCompleted);
});
