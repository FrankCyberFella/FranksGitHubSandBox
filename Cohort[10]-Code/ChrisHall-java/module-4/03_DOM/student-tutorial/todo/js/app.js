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
    ]
  }


// write function to add page title to the DOM
function addPageTitle() {
    const heading = document.createElement('h1')  // define element
    heading.innerText = pageTitle;                // add value to it
    todoList.appendChild(heading);                // stick it where you want it
  }


// write function to add list items 

function addTodos() {
    const newUl = document.createElement('ul'); // create a ul element
    todos.forEach(todo => {                   //  loop thru the todos array and process
      const li = document.createElement('li') // create an li tage
      li.innerText = todo.task    // assign the current array element to li tag
      newUl.appendChild(li)          // add li to the ul tag we created
    });
    todoList.appendChild(newUl);  // connect it to the DOM (to the div)
  }

// setup our page title and tasks
init();
// // add page title (the <h1>) to the DOM
addPageTitle();
// // add the task (the ul and all it's li's) to the DOM
addTodos();
