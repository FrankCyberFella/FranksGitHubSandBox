<template>
    <div class="shopping-list">
        <div>
            <h2>{{title}}
            <button class="add" v-on:click.prevent="showInput = !showInput">+</button>
            </h2>
            <div class="itemInput" v-show="showInput">    
                <input type="text" id="addNew" name="addNew" placeholder="New Item.." v-model="itemName"/>
                <button v-on:click.prevent="addItem">add</button>
            </div>
        </div>
        <ul>
            <li v-for="item in filteredList" 
                v-bind:key="item.id" 
                v-bind:class="{ completed: item.completed }" 
                v-on:click="changeStatus(item.id,$event)">
                <input type="checkbox"/>
                {{item.name}} 
                <i class="far fa-check-circle" v-bind:class="{ completed: item.completed }"></i>
            </li>
        </ul>
    </div>
</template>
 
<script>
export default {
    name: 'shopping-list',
    props: {
        title: String,
        data: Array,
        filterText: String
    },
    data() {
        return {
            newItem: '',
            itemName: '',
            showInput: false
        }
    },
    computed: {
       filteredList(vm) {
           const list = vm.data.filter((item) => {
                const itemLower = item.name.toLowerCase();
                const filterLower = vm.filterText.toLowerCase();
                return itemLower.startsWith(filterLower);
           });
            
            return list;            
       }

    },
    methods: {
        changeStatus(id,event) {
            const arrIndex = this.filteredList.findIndex((item) => item.id == id);
            this.filteredList[arrIndex].completed = !this.filteredList[arrIndex].completed;
            
            // the checkbox might not have been target of the click event
            if( event.target.type != 'checkbox' ) {
                const checkbox = event.target.querySelector('input[type="checkbox"]');
                checkbox.checked = !checkbox.checked;
            }
        },
        addItem() {     
            if(this.itemName != ''){
                const nextNumber = this.filteredList.length+1;
                this.newItem = {
                    id : nextNumber,
                    name : this.itemName,
                    completed : false
                } 
                if(this.newItem != ''){                         
                this.filteredList.push(this.newItem); 
                }
            }
            
            this.showInput = false;

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
h2{
    background:#f2f2f2;
    color:#5c8578;
    padding:10px;
    font-size:24px;
    text-transform: uppercase;
    text-align: center;
    margin: 0px;
    border-top-left-radius: 10px;
    border-top-right-radius: 10px;
}

.itemInput {
    min-width: 100%;
    text-align: center;
    padding: 10px;
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
    cursor: pointer;
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
