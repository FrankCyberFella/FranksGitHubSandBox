

document.addEventListener('DOMContentLoaded', () => {
  const keys = document.getElementById('keyboard').querySelectorAll('button');
    
    keys.forEach((note) => {
      note.addEventListener('click', () => {
        let noteName = note.getAttribute('id');
        if(note.style.background != 'green') {
        note.style.background = 'green';
        note.querySelector('audio').play;
        }
        else note.style.background = 'red';
        note.querySelector('audio').play;
      })
      
      
    })
    
  });
  const keys = document.getElementById('keyboard').querySelectorAll('button');

  let background = true;
  keys.forEach((note) => {
    if(note.style.background == 'red'){
      document.querySelector('body').style.background = 'red';
      background = false;
    }
  })


  
  function playNote(key){
    let noteName = key.getAttribute('id');
    key.innerText = 'noteName'
  }