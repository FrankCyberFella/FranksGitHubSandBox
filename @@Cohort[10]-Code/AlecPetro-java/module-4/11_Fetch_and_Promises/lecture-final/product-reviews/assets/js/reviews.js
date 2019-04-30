/**************************************************************************
 * Fetch and Promises - review.js - lecture-final
 *************************************************************************/
let reviews = [];

function loadReviews() {
  console.log("Load Reviews...");

  fetch('data.json')          // go get the data from this source
    .then((response) => {     // wait until the data is retrieved 
      return response.json(); // convert data to JSON and return it
    })
    .then((data) => {         // wait for the data to be converted
      reviews = data;         // assign the data to reviews
      displayReviews();       // run the displayReviews() method to get the data into the html
    })
    .catch((err) => console.error(err));
    // whatever code comes after the fetch is run as the fetch is getting the data
    // when the fetch is done, this is interrupted, the .then(s) are run and we resume where we were 
}

function displayReviews() {
  console.log("Display Reviews...");

  if('content' in document.createElement('template')) {   // if there is a template in the html
    const container = document.querySelector(".reviews"); // get a reference to the element with class ".reviews"
    reviews.forEach((review) => {                         // loop through each element
      const tmpl = document.getElementById('review-template').content.cloneNode(true);  // get a reference to review-template
      tmpl.querySelector('img').setAttribute("src",review.avatar); // assigning values 
      tmpl.querySelector('.username').innerText = review.username; //
      tmpl.querySelector('h2').innerText = review.title;           //
      tmpl.querySelector('.published-date').innerText = review.publishedOn; //
      tmpl.querySelector('.user-review').innerText = review.review; // and whatever else we want in the html template
      container.appendChild(tmpl);                // add the element to DOM
    });
  } else {
    console.error('Your browser does not support templates');
  }
}

const button = document.querySelector("button");
  button.addEventListener("click",function() {  // When the button is clicked...
  loadReviews();                                // run the loadReviews() method
  button.disabled = true;                       // disable button
});