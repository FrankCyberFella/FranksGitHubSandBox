<template>
  <div id="app">
    <user-filter v-on:new-filter="saveFilter"></user-filter>
    <user-table v-bind:users="users"></user-table>
    <new-user v-on:new-user="saveUser"></new-user>
  </div>
</template>

<script>
import UserTable from './components/UserTable.vue';
import NewUser from './components/NewUser.vue';
import UserFilter from './components/UserFilter.vue';

export default {
  components: {
    UserTable,
    UserFilter,
    NewUser
  },
  data() {
    return {
      allUsers: [],
      filterText: ''
    }
  },
  computed: {
    users() {
      return this.allUsers.filter((user) => {
        return user.firstName.includes(this.filterText) || user.lastName.includes(this.filterText);
      });
    }
  },
  methods: {
    saveUser(user) {
      this.allUsers.push(user);
    },
    saveFilter(filter) {
      this.filterText = filter;
    }
  }
}
</script>
