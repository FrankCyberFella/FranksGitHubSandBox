import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    allUsers: [],
    filterText: ''
  },
  getters: {
    users(state) {
      return state.allUsers.filter((user) => {
        return user.firstName.includes(state.filterText) || user.lastName.includes(state.filterText);
      });
    }
  },
  mutations: {
    addUser(state, user) {
      state.allUsers.push(user);
    },
    changeFilter(state, newFilter) {
      state.filterText = newFilter;
    },
    clear(state) {
      state.allUsers = [];
      state.filterText = '';
    }
  }
});