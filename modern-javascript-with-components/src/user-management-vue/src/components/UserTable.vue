<template>
     <table>
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

<script>
export default {
    name: 'user-table',
    props: {
        users: Array
    }
}
</script>
