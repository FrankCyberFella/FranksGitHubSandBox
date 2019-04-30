const name = 'Cigar Parties for Dummies';
const description = 'Host and plan the perfect cigar party for all of your squirrelly friends.';
const reviews = [
  {
    reviewer: 'Malcolm Gladwell',
    title: 'What a book!',
    review:
      "It certainly is a book. I mean, I can see that. Pages kept together with glue (I hope that's glue) and there's writing on it, in some language.",
    rating: 3
  }
];

/**
 * Add our product name to the page title
 * Get our page page title by the id and the query the .name selector
 * once you have the element you can add the product name to the span.
 */
function setPageTitle() {
  const pageTitle = document.getElementById('page-title');
  pageTitle.querySelector('.name').innerHTML = name;
}

/**
 * Add our product description to the page.
 */
function setPageDescription() {
  document.querySelector('.description').innerHTML = description;
}

/**
 * I will display all of the reviews in the reviews array
 */
function displayReviews() {
  if ('content' in document.createElement('template')) {
    reviews.forEach((review) => {
      displayReview(review);
    });
  } else {
    console.error('Your browser does not support templates');
  }
}

/**
 *
 * @param {Object} review The review to display
 */
function displayReview(review) {
  const main = document.getElementById('main');
  const tmpl = document.getElementById('review-template').content.cloneNode(true);
  tmpl.querySelector('h4').innerHTML = review.reviewer;
  tmpl.querySelector('h3').innerHTML = review.title;
  tmpl.querySelector('p').innerHTML = review.review;
  // there will always be 1 star because it is a part of the template
  for (let i = 1; i < review.rating; ++i) {
    const img = tmpl.querySelector('img').cloneNode();
    tmpl.querySelector('.rating').appendChild(img);
  }
  main.appendChild(tmpl);
}

document.addEventListener('DOMContentLoaded',() => {
  setPageTitle();           // set the product page title
  setPageDescription();     // set the product review page description
  displayReviews();          // display all of the product reviews on our page
})

//when the user clicks the description they can change it
//show an input box when they click it

// get a reference to the element to manipulate 
// getElementById() ---> uses Id or querySelector() ---> uses css selector

const reviewDescription = document.querySelector('.description');
reviewDescription.addEventListener('click', (event) => { //addEventListner takes an event and a function (pref named function for testing)
  changeDescription(event.target)                        // call our function passing it the element that experienced the event
})


function changeDescription(reviewDescriptionTarget){ 
  // unhide the input box --> get the data from the input box --> set the description element to the data
  
  
  const textBox = reviewDescriptionTarget.nextElementSibling;     // get a reference for the element to change
  textBox.classList.remove('d-none');                             //remove  the do not display
  reviewDescriptionTarget.innerText = textBox.value;
  reviewDescriptionTarget.classList.add('d-none')
  textBox.focus();
  
}