<template>
    <div class="shopping-list">
        <h1>My Shopping List</h1>
        <ul>
            <li v-bind:class="{'completed': anItem.completed}" v-for="anItem in items" v-bind:key="anItem.id" >{{anItem.name}}</li>
        
        </ul>
    </div>
</template>

<script>
export default {
    name: "shopping-list",
    data(){
        return{
            items:[
                {   id: '1',
                    name: 'Tide Pods',
                    completed: true },
                {   id: '2',
                    name: 'Diet Mountain Dew',
                    completed: true },
                {   id: '3',   
                    name: 'Tacos',
                    completed: false },
                {   id: '4',
                    name: 'Bananas',
                    completed: false },
                {   id: '5',
                    name: 'Protein Powder',
                    completed: true },
                {   id: '6',
                    name: 'Eggs',
                    completed: false },
                {   id: '7',
                    name: 'Croutons',
                    completed: false },
                {   id: '8',
                    name: 'Cat Food',
                    completed: false },
                {   id: '9',
                    name: 'Peanut Butter',
                    completed: false }
            ]
        };
    },

    computed:{
        someSortOfFunction(vm){

        },
    },

    methods:{
        someNumberOfMethods(things, toTake){

        },
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
</style>
