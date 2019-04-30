<template>
    <div class="shopping-list">
        <h1>My Shopping List</h1>
        <ul>
            <li v-for="item in groceries" v-bind:key="item.id" v-bind:class="{ completed: item.completed }" v-on:click="changeCompleted(item, $event)">
                <input type = 'checkbox'/>
                {{item.name}} 
                <i class="far fa-check-circle" v-bind:class="{ completed: item.completed }"></i>
            </li>
        </ul>
    </div>
</template>

<script>
export default {
    data() {
        return {
            groceries: [
                { name : 'Oatmeal', id : 1, completed: false },
                { name: 'Milk', id : 2, completed: false },
                { name: 'Banana', id : 3, completed: false },
                { name: 'Strawberries', id : 4, completed: false },
                { name: 'Lunch Meat', id : 5, completed: false },
                { name: 'Bread', id : 6, completed: false },
                { name: 'Grapes', id : 7, completed: false },
                { name: 'Steak', id : 8, completed: false },
                { name: 'Salad', id : 9, completed: false }
            ]
        }
    },
    methods: {
changeCompleted(item, event) {
    item.completed = !item.completed;

    if( event.target.type != 'checkbox') {
        const checkbox = event.target.querySelector('input[type="checkbox"]');
        checkbox.checked = !checkbox.checked;
    }
}
    }
}
</script>

<style>
.shopping-list {
    width:450px;
    background: #fff;
    margin: 50px auto;
    font-family: 'Roboto Condensed', sans-serif;
    border-radius: 10px;
}
h1 {
    background:#f2f2f2;
    color:#5c8578;
    padding:10px;
    font-size:24px;
    text-transform: uppercase;
    text-align: center;
    margin-bottom: 0px;
    border-top-left-radius: 10px;
    border-top-right-radius: 10px;
}
ul {
    list-style-type: none;
    margin:0px;
    padding:0px;
}
li {
    font-size: 24px;
    border-bottom:1px solid #f2f2f2;
    padding:10px 20px;
}
li:last-child{
    border:0px;
}
li.completed {
    text-decoration: line-through;
    color:darkgrey;
}
i.far.fa-check-circle { 
    float:right;
    color: darkgray;
}

i.far.fa-check-circle.completed {
    color:green;
}
input[type="checkbox"] {
    font-size:40px;
    vertical-align: middle;
    margin-top:0px;
}
</style>
