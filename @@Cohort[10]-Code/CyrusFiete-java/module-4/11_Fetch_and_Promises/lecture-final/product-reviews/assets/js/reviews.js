/**************************************************************************
 * Fetch and Promises - review.js - lecture-final
 *************************************************************************/
let reviews = [];

function loadReviews() {
  console.log("Load Reviews...");

  fetch('data.json') 
    .then((response) => {
      return response.json();
    })
    .then((data) => { //wait for data to be converted to json
      reviews = data; //assign the data to reviews
      displayReviews(); //run the displayReviews() method to get the date into the html
    })
    .catch((err) => console.error(err));
}

function displayReviews() {
  console.log("Display Reviews...");

  if('content' in document.createElement('template')) {   //if there is a <template> in the html
    const container = document.querySelector(".reviews"); //get a reference to the element with class "reviews"
    reviews.forEach((review) => {                         //loop through each element
      const tmpl = document.getElementById('review-template').content.cloneNode(true); //get a reference to review-template
      tmpl.querySelector('img').setAttribute("src",review.avatar);  //assigning values, content, whatever we want in html template
      tmpl.querySelector('.username').innerText = review.username; 
      tmpl.querySelector('h2').innerText = review.title;            
      tmpl.querySelector('.published-date').innerText = review.publishedOn;
      tmpl.querySelector('.user-review').innerText = review.review;
      container.appendChild(tmpl);
    });
  } else {
    console.error('Your browser does not support templates');
  }
}

const button = document.querySelector("button");
  button.addEventListener("click",function() { 
  loadReviews();
  button.disabled = true;
});