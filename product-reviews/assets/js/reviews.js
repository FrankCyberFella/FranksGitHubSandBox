let reviews = [];

/**
 * This function when invoked will look at an array of reviews
 * and add it to the page by cloning the #review-template
 */
function displayReviews() {
  console.log("Display Reviews...");

  // first check to make sure the browser supports content templates
  if ("content" in document.createElement("template")) {
    // query the document for .reviews and assign it to a variable called container
    const container = document.querySelector(".reviews");
    // loop over the reviews array
    reviews.forEach(review => {
      // get the template; find all the elements and add the data from our review to each element
      const tmpl = document
        .getElementById("review-template")
        .content.cloneNode(true);
      tmpl.querySelector("img").setAttribute("src", review.avatar);
      tmpl.querySelector(".username").innerText = review.username;
      tmpl.querySelector("h2").innerText = review.title;
      tmpl.querySelector(".published-date").innerText = review.publishedOn;
      tmpl.querySelector(".user-review").innerText = review.review;
      container.appendChild(tmpl);
    });
  } else {
    console.error("Your browser does not support templates");
  }
}

/**
 * Retrieves the reviews from a data source.
 */
function loadReviews() {
  console.log("Loading reviews.");

  // const fetchPromise = fetch("data.json");
  // const jsonPromise = fetchPromise.then(
  //   response => {
  //     return response.json();
  //   },
  //   error => {
  //     console.log("error");
  //   }
  // );

  // Make the request
  fetch("data.json")
    .then(response => {
      // We have received a response from the server
      // Get JSON off of the response data
      return response.json();
    })
    .then(json => {
      console.table(json);
      reviews = json;
      displayReviews();
    })
    .catch(error => {
      console.log(error);
    });

  console.log("Fetch request sent.");
}

// When the dom is loaded
document.addEventListener("DOMContentLoaded", () => {
  // Add an event listener for the button
  const button = document.querySelector("button");
  button.addEventListener("click", () => {
    // Load the reviews
    loadReviews();

    // Disable the button
    button.disabled = true;
  });
});
