const todoList = document.getElementById('todos');

let todos = [];
let pageTitle = '';

function init() {
  pageTitle = 'My Morning Routine';
  todos = [
    { id: 1, task: 'Wake up', completed: false },
    { id: 2, task: 'Brush Teeth', completed: false },
    { id: 3, task: 'Shower', completed: false },
    { id: 4, task: 'Get Dressed', completed: false },
    { id: 5, task: 'Drive to work', completed: false },
    { id: 6, task: 'Work', completed: false },
    { id: 7, task: 'Drive home from work', completed: false },
    { id: 8, task: 'Dinner', completed: false },
    { id: 9, task: 'Brush Teeth', completed: false },
    { id: 10, task: 'Go to bed', completed: false }
  ];
}

function addPageTitle() {
  const heading = document.createElement('h1');
  heading.innerText = pageTitle;
  todoList.appendChild(heading);
}

function addTodos() {
  const ul = document.createElement('ul');
  todos.forEach((todo) => {
    const li = document.createElement('li');
    li.innerText = todo.task;
    const checkCircle = document.createElement('i');
    checkCircle.setAttribute('class', 'far fa-check-circle');
    li.appendChild(checkCircle);
    ul.appendChild(li);
  });
  todoList.appendChild(ul);
}

function markCompleted() {
  items = document.querySelectorAll('li').forEach((item) =>
  {
    item.classList.add('completed')
  });
}

init();
addPageTitle();
addTodos();

document.addEventListener('DOMContentLoaded', () => {

  const button = document.querySelector('.btn');
  button.addEventListener('click', markCompleted);
  // When the DOM Content has loaded attach a click listener to the button
  const button = document.querySelector('.btn');
  button.addEventListener('click', markCompleted);

  document.querySelectorAll('li').forEach((item) => {
    item.addEventListener('click', () => {
      if( !item.classList.contains('completed')){
        item.classList.add('completed');
        item.querySelector('i').classList.add('completed');
      } 
      item.addEventListener('dblclick', () => {
        if(item.classList.contains('completed')){
          item.classList.remove('completed');
          item.querySelector('i').classList.remove('completed');
        }
      })
      
    })
  })

  

});
