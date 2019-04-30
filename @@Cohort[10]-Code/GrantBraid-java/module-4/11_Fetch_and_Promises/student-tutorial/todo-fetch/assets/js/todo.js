if ('content' in document.createElement('template')) {
    // OK, lets do some work
  } else {
  // Find another way to add list items to your list
  // the HTML template element is not supported. console.error('Your browser does not support templates');
  }

fetch('data.json')
  .then((response) => {
    // get the JSON from the response
    return response.json();
  })
  .then((todos) => {
    // when the JSON data is returned log the result
    console.log(todos);
  })
  .catch((err) => {console.error(err)});

