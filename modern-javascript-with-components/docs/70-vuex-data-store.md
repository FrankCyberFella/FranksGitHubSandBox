# Using Vuex as a Central Data Store (45 Minutes)

We implemented the user management application using a Vue pattern where state is being held in the Parent that every Child will access through events and props.

That works great for small applications or a small set of components that will be used together.

There is another way though, a way where we can use a centralized data store--or stores--to hold and manage the data of the application. These stores can then be accessed and shared between the components to build the application's input and output requirements. Now, it's the central data store that defines the interface for input and output using its methods and data properties. In fact, the idea of a parent component can go away completely. Components won't be talking to each other anymore, they will be talking to the data store that they are all connected to.

The data store library we'll be using is called Vuex and is designed to be used with Vue components. The model of data store it uses is called Flux and it's very popular with newer component-based frameworks. React has a Flux-based data store called Redux and Angular uses a similar model of data flow called Observables.

We'll be using Vuex in the next example, so lets make sure it's installed in the project.

> #### Note:Creating a Copy of User Management
>
> For the following example, create a copy of the user-management-vue project that the students have already created and call it user-management-vuex. Be sure to then have them open the user-management-vuex project in VSCode.

## Installing Vuex

First, we'll want to install Vuex into our project. We'll do that by running the command line command `npm install vuex --save`.

## Creating a Data Store

We will take our completed User Management application that currently uses the parent-child approach and add on a Vuex data store to it. To create the store, go ahead and create a new folder under the `src` folder called `stores`. This is where we will keep our Vuex stores for our application.

We only need one store at the moment for this size of application--a user store--but you could have many stores that the components interact with to get their jobs done.

To create a user data store, create a new file in the `stores` directory called `user.js`. Vuex store files are not components and don't need HTML or CSS sections to them, so they will be regular old JavaScript files.

Within that `user.js` file, we'll create a Vuex store skeleton:

```JavaScript
import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

export default new Vuex.Store({
  state: {

  },
  getters: {

  },
  mutations: {

  },
  actions: {

  }
});
```

This JavaScript object looks a lot like the sections that we have in component and they can be treated the same way. Let's look at each section:

A store has four parts:

- `store` - This is like the `data` in a component. It is where read/write variables are stored.
- `getters` - Computed properties that are calculated from `store`.
- `actions` - Like `methods` in components, the behavior for the store. We can use these to fetch data from an API and commit the results. These actions should never change the actual state properties but should always go through a mutation to do so.
- `mutations` - This is how data gets into the store or changes in the store, ie by a component or from an action.

## State

How stores work is that all the data for the store is kept in the `store` section of the data store. We can move our data from our parent to our data store by setting the `data` properties as `store` properties in our user store.

``` JavaScript
  state: {
    allUsers: [],
    filterText: ''
  },
```

To use the state, we will need to explicitly call on the state portion of the data store object:

``` JavaScript
import userStore from '@/stores/user';
userStore.state.allUsers;
```

## Getters

We would move our `computed` property from the parent to the `getters` section of the data store. The `getters` are transformations that we can apply to the data that we have in the `store`, so we can use them to calculate the filter users from the `allUsers` state property.

``` JavaScript
  getters: {
    users(state) {
      return state.allUsers.filter((user) => {
        return user.firstName.includes(state.filterText) || user.lastName.includes(state.filterText);
      });
    }
  },
```

You'll see that we get a parameter in our `getters` called state. We can only access the data store's state through this parameter and not through `this` like we did for components. That's be cause the state should be handled in a special way and should *never* be changed in a `getter` method.

To call the getters, you can use them just like regular properties, but you will have to call them from the getter section of the data store.

``` JavaScript
import userStore from '@/stores/user';
userStore.getters.users;
```

## Mutators

Mutator methods are methods that change the state of the data store. Mutators should be the *only* thing that directly changes the state of the data store. That's because Vuex treats all mutator methods in a special way and knows that if a mutator is called, that means that the state is changed and it will go and notify all the components that are using its `getters` and `state` properties that something has changed and they should update. It's extremely important that you only update the state of the store inside of mutators and no where else.

We have a couple of mutators to add to our data store. There is the `addUser` method and the `changeFilter` method from the current parent component.

``` JavaScript
  mutations: {
    addUser(state, user) {
      state.allUsers.push(user);
    },
    changeFilter(state, newFilter) {
      state.filterText = newFilter;
    }
  }
```

You can see, again, that we have this special `state` object that is passed to our method and then the parameters that we will use to change the data. We'll see soon how these methods are called, but that state object is used to make these changes and notify the components about the data change. Otherwise, these methods look very much like what we saw in the parent component.

There is another mutation we will add here in order to help us unit test so that we can set the data store back to its original state:

``` JavaScript
mutations: {
  ...
  clear(state) {
    state.allUsers = [];
    state.filterText = '';
  }
}
```

In order to call these mutators, you will be *committing* changes to the data store. They should be called like this:

``` JavaScript
import userStore from '@/stores/user';
userStore.commit('changeFilter', 'new filter text');
userStore.commit('clear');
```

The extra arguments passed to `commit` are given to the mutation after the state parameter.

## Unit Testing

Before we change our components to use our new data store, let's build some unit tests around the data store.

Create a new file in the `tests/unit` directory and call it `UserStore.spec.js`. There are a number of tests that we can write for this, including making sure our mutations work and making sure the getters are set up correctly to return the correct data. Write the following tests with the students to demonstrate this:

``` JavaScript
import userStore from '@/stores/user';

import chai from 'chai';
chai.should();

describe('UserStore', () => {
  beforeEach( () => {
    userStore.commit('clear');
  });

  describe('state', () => {
    it('should save filter when filter is set', () => {
      userStore.commit('changeFilter', 'TEST');
      userStore.state.filterText.should.equal('TEST');
    });

    it('should add user to array when added', () => {
      let testUser = {
        firstName: 'FTEST',
        lastName: 'LTEST'
      };
      userStore.commit('addUser', testUser);
      userStore.state.allUsers.length.should.equal(1);
      userStore.state.allUsers[0].should.deep.equal(testUser);
    });
  });

  describe('getters', () => {
    let passedUser, blockedUser;
    beforeEach( () => {
      passedUser = {
        firstName: 'FTEST',
        lastName: 'LTEST'
      };

      blockedUser = {
        firstName: 'FWORST',
        lastName: 'LWORST'
      };

      userStore.commit('addUser', passedUser);
      userStore.commit('addUser', blockedUser);
      userStore.commit('changeFilter', 'TEST');
    });

    it('should show only users matching functions when filter set', () => {
      userStore.getters.users.should.deep.contain(passedUser);
    });

    it('should not contain non matching user', () => {
      userStore.getters.users.should.not.deep.contain(blockedUser);
    });
  });
});
```

## Hooking Up a Data Store to Components

Now we have a data store that we can use in our components. This will be the central clearing house for all of this data, just like our Parent component was. But instead of being stuck under a single component, our components can now be much more independent of each other and--as long as they're on the same page--be distributed throughout the content of a site and not all stuck together inside of a parent component.

In order to use the data store in components, we need to import the data store. We will do that in the JavaScript section of the component. Let's tackle the UserFilter component first:

``` JavaScript
<script>
import userStore from '@/stores/user';
export default {
```

Instead of emit events, our UserFilter will now commit changes to the data store whenever the filter changes:

``` JavaScript
methods: {
    filterChange() {
        userStore.commit('changeFilter', this.filter);
    }
}
```

For the NewUser component, we will be doing something very similar:

``` JavaScript
<script>
import userStore from '@/stores/user';
export default {
```

Again, all output is now handled as commits to the data store:

``` JavaScript
performSubmit() {
    this.user.id = Math.floor(Math.random() * 1000);
    userStore.commit('addUser', this.user);
    this.closeForm();
},
```

For the UserTable component, we will now watch the `users` getter for changes. When one of the other components updates the data store, the UserTable will be automatically updated with the new data.

``` JavaScript
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
```

After making these changes, you'll also need to update the unit tests. We're no longer listening to the events and setting props, we are now testing the component's interactions with the user data store.

## Mounting the Components

Now that the components are talking to the user data store and no longer need the Parent component, we now mount the components directly onto the page themselves and get rid of the Parent component entirely.

Change the `index.html` file to add the components' HTML custom tags:

``` HTML
    <user-filter></user-filter>
    <user-table></user-table>
    <new-user></new-user>
```

And change the `main.js` to mount these components directly:

```JavaScript
import Vue from 'vue'
import NewUser from './components/NewUser.vue'
import UserFilter from './components/UserFilter.vue'
import UserTable from './components/UserTable.vue'

Vue.config.productionTip = false

new Vue({
  render: h => h(NewUser)
}).$mount('new-user');

new Vue({
  render: h => h(UserFilter)
}).$mount('user-filter');

new Vue({
  render: h => h(UserTable)
}).$mount('user-table');
```

You can rearrange these components any way you want now in the HTML page. You are no longer tied to a Parent component, but you still have the components separated from each other and only interacting via messages going through the data store. As long as the data store is available, these components can interact in any combination and any location on the page.