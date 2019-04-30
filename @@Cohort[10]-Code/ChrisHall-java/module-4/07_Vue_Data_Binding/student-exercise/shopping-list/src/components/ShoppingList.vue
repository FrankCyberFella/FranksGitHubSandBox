<template>
    <div class="shopping-list">
        <h1>My Shopping List</h1>
         <ul>
            <li  v-for="thing in shoppingListArray" v-bind:key="thing" v-bind:class= "{completed:thing.completed}">{{thing.item}}</li>
        </ul> 
        
    </div>
   
</template>

<script>
export default {
    data() {
        return {
        shoppingListArray: [
            {
                item: "Milk",
                completed: false
            },
            {
                item: "T-bone steak",
                completed: true
            },
            {
                item: "Flour",
                completed: false
            },
            {
                item: "Multigrain bread",
                completed: true
            },
            {
                item: "Parmesan cheese",
                completed: false
            },
            {
                item: "hot sauce",
                completed: true
            },
            {
                item: "Paprika",
                completed: false
            },
            {
                item: "peaches",
                completed: false
            },
            {
                item: "cookies",
                completed: false
            }

        ]
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
</style>
