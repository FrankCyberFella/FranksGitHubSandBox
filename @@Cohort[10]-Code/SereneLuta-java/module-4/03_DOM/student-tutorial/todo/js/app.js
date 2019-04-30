const todoList = document.getElementById('todos');

let todos =  [];
let pageTile = '';

//creating an array of objects via function init()
function init() {
    pageTitle = 'My Daily Routine';
    todos = [{
        id: 1,
        task: 'Wake up',
        completed: false
    },
{
    id: 2,
    task: 'Brush Teeth',
    completed: false
},
{
    id: 3,
    task: 'Shower',
    completed: false
},
{
    id: 4,
    task: 'Get Dressed',
    complete: false
},
{
    id: 5,
    task: 'Drive to work',
    completed: false
},
{
    id: 6,
    task: 'Work',
    completed: 'false'
},
{
    id: 7,
    task: 'Drive home from work',
    completed: false
},
{
    id: 8,
    task: 'Dinner',
    completed: false
},
{
    id: 9,
    task: 'Brush Teeth',
    completed: false
},
{
    id: 10,
    task: 'Go to bed',
    completed: false
    }
  ];
}

//create the element and stick it in the child element of the div todos(getElementById)
function addPageTitle() {
    const heading = document.createElement('h1');
    heading.innerText = pageTitle;
    todoList.appendChild(heading);
}

//on the forEach loop through the todos array - call the current element todo
function addTodos() {
    const newUl = document.createElement('ul');
    todos.forEach((anElement) => {
        const li = document.createElement('li');//create a li tag
        li.innerText = anElement.task;          // assign the current array element to li tag
        newUl.appendChild(li);                  // add li to ul tag we created
    });
    todoList.appendChild(newUl);                // add to the DOM  
}
//Setup page and tasks
init();
//add page title to the DOM
addPageTitle();             //add the <h1> to the DOM
//add the task to the DOM
addTodos();                 //ad the ul and all it's li's to DOM

