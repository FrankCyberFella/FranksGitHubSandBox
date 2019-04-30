let items=[];

function loadList(){
    fetch('assets/data/shopping-list.json').then((response)=>{
        console.log(response.json);
        return response.json();
        
    }).then((response)=>{
        items=response;
        updateList();

        //make it so that on success (reaching the second .then) the event listener is removed and cannot be called again
        document.querySelector('.loadingButton').removeEventListener('click',loadList);
        });
    
}

function updateList(){
    if('content' in document.createElement('template')){
        const container = document.querySelector('.shopping-list ul');
        items.forEach((item)=>{
            const theNode = document.getElementById('shopping-list-item-template').content.cloneNode(true);
            const textNode = document.createTextNode(item.name);
            theNode.querySelector('li').appendChild(textNode);
            if(item.completed)theNode.querySelector('li').classList.add('completed');
            container.appendChild(theNode);
        })
    } else{
        console.log('This browser does not support templates')
    }
}

document.querySelector('.loadingButton').addEventListener('click',loadList);
