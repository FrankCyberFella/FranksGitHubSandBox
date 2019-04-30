<template>
     <table class="table">
        <thead>
            <tr>
                <td>ID</td>
                <td>Name</td>
                <td>Title</td>
                <td>Email</td>
                <td>Enabled</td>
            </tr>
        </thead>
        <tbody>
            <tr v-for="user in users" v-bind:key="user.id">
                <td>{{ user.id }}</td>
                <td>{{ user.firstName }} {{ user.lastName }}</td>
                <td>{{ user.title }}</td>
                <td>{{ user.email }}</td>
                <td>{{ user.enabled ? 'Yes' : 'No' }}</td>
            </tr>
        </tbody>
    </table>
</template>

<style>
@import url( 'https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css' ); 
</style>

<script>
import userStore from '@/stores/user';
export default {
    name: 'user-table',
    computed: {
        users() {
            return userStore.getters.users;
        }
    }
}
</script>
