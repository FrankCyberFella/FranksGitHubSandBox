<template>
<div id="shopping-list">
<h1>My Shopping List</h1>
<ul>
    <li>Bread</li>
    <li class="completed">Bread</li>
    <li>Bread</li>
    <li>Bread</li>
    <li class="completed">Bread</li>
    <li>Bread</li>
    <li>Bread</li>
</ul>
</div>
</template>

<script>
export default {

}
</script>

<style>

#shopping-list {
    width:450px;
    background: #fff;
    margin: 50px auto;
    font-family: 'Roboto Condensed', sans-serif;
    border-radius: 10px;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
}
h1 {
color:#5c8578;
padding:10px;
font-size:24px;
text-transform: uppercase;
text-align: center;
margin-bottom: 0px;
border-top-left-radius: 10px;
  border-top-right-radius: 10px;
    border-bottom-style: solid;

}
ul {
    list-style-type: none;
    margin:0px;
    padding:0px;
    background: white;
    text-align: center;
    width: 50%;
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
