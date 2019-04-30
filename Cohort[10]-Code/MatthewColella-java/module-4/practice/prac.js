



function doStuff(){
  if(document.getElementById("header").style.background == 'red'){
  document.getElementById("header").style.background = 'green';
  document.getElementById("header").innerText = 'Playing...';
  document.getElementById("but").innerText = 'Pause';
  

}
  else {document.getElementById("header").style.background = 'red';
  document.getElementById("header").innerText = 'Paused...';
  document.getElementById("but").innerText = 'Play';
}
  }




// Don't worry too much about what is going on here, we will cover this when we discuss events.
document.addEventListener('DOMContentLoaded', () => {
  // When the DOM Content has loaded attach a click listener to the button
  const button = document.getElementById('but');
  button.addEventListener('click', doStuff);
});



