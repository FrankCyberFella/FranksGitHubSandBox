/**************************************************************************
 * Fetch and Promises - review.js - lecture-final
 *************************************************************************/
let reviews = [];

function loadReviews() {
  console.log("Load Reviews...");

  fetch('data.json')              // go get the data from this source
    .then((response) => {         // wait until the data is retrieved
      return response.json();     // convert the data to json
    })
    .then((data) => {             // wait for the data to be converted to json
      reviews = data;             //assign the data to reviews 
      displayReviews();           // run display reviews method() to get data into the html
    })
    .catch((err) => console.error(err));
    // whatever code comes after the fetch block will run as the fetch is getting data
    // then when the fetch is done, this is interrupted, the .then()s are run and we resume where we were interrupted 
}

function displayReviews() {          
  console.log("Display Reviews...");

  if('content' in document.createElement('template')) {   // if there is a <template> in the html
    const container = document.querySelector(".reviews"); // get a reference to the element with class "reviews"
    reviews.forEach((review) => {                         // loop through each element
      const tmpl = document.getElementById('review-template').content.cloneNode(true); // get reference to review template
      tmpl.querySelector('img').setAttribute("src",review.avatar);          // assigning values
      tmpl.querySelector('.username').innerText = review.username;          //              content
      tmpl.querySelector('h2').innerText = review.title;                    //                    and
      tmpl.querySelector('.published-date').innerText = review.publishedOn; //                      whatever else
      tmpl.querySelector('.user-review').innerText = review.review;         //                            we want in the html
      container.appendChild(tmpl);                                          //  adds the element to the DOM
    });
  } else {
    console.error('Your browser does not support templates');
  }
}

const button = document.querySelector("button");
  button.addEventListener("click",function() {    // when the button is clicked
  loadReviews();                                  
  button.disabled = true;                         // disable the button
});