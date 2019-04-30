// add pageTitle
const pageTitle = 'My Shopping List';
// add groceries
const groceries = ['apples', 'oranges', 'granola', 'bananas', 'spinach',
'chips', 'chicken', 'beer', 'chocolate', 'sardines'];

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
  const listHolder = document.querySelector('.shopping-list ul');
    groceries.forEach((element) => {
      const groceryLi = document.createElement('li');
      groceryLi.innerText = element;
      listHolder.appendChild(groceryLi);
    });

}

let shoppingList = document.querySelector('.shopping-list');
let shopItems = shoppingList.childNodes;
let shopArr = Array.from(shopItems);

function showChildren(){
shopArr.forEach((element) => {
  console.log(element);
});
}

showChildren();


/**
 * This function will be called wh4en the button is clicked. You will need to get a reference
 * to every list item and add the class completed to each one
 */
function markCompleted() {
    const list = document.querySelector('.shopping-list ul');
    const listItems = Array.from(list.children);
    listItems.forEach((item) => {
        item.setAttribute('class','completed');
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




// function setPageTitle() {
//   const pageTitle = document.getElementById('page-title'); // get to the element id = 'page-title';
//   pageTitle.querySelector('.name').innerText = name; // get me to the element with the class .name and set the text to whatever is in name variable
// }

// /**
//  * Add our product description to the page.
//  */
// function setPageDescription() {
//   document.querySelector('.description').innerText = description;
// }

// /**
//  * I will display all of the reviews on the page.
//  * I will loop over the array of reviews and use some helper functions
//  * to create the elements needed for our markup and add them to the DOM
//  */
// function displayReviews() {
//   const mainDiv = document.getElementById('main');
//     reviews.forEach((element) => {
//       const reviewDiv = document.createElement('div');
//       reviewDiv.setAttribute('class', 'review');
//       const paraElement = document.createElement('p');
//       paraElement.innerText = element.review;
//       reviewDiv.appendChild(paraElement);
//       mainDiv.appendChild(reviewDiv);
//   });
// }

// /**
//  * I will creating a new h4 element with the name of the reviewer and append it to
//  * the parent element that is passed to me.
//  *
//  * @param {HTMLElement} el: The element to append the reviewer to
//  * @param {string} name The name of the reviewer
//  */
// function addReviewer(parent, name) {}

// /**
//  * I will add the rating div along with a star image for the number of ratings 1-5
//  * @param {HTMLElement} parent
//  * @param {Number} numberOfStars
//  */
// function addRating(parent, numberOfStars) {}

// /**
//  * I will add an h3 element along with the review title
//  * @param {HTMLElement} parent
//  * @param {string} title
//  */
// function addTitle(parent, title) {}

// /**
//  * I will add the product review
//  * @param {HTMLElement} parent
//  * @param {string} review
//  */
// function addReview(parent, review) {}

// // set the product reviews page title
// setPageTitle();
// // set the product reviews page description
// setPageDescription();
// // display all of the product reviews on our page
// displayReviews();
