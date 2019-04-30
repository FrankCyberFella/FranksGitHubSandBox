# Converting an Existing Application to Components (90 Minutes)

> This content will be talked about as you look at the simple `user-management-vanilla` application code.

We have an existing application that manages user information. It's written in pure vanilla JavaScript and it's a mess. Everything is thrown together in one file and any changes that we might want to make to it would be a nightmare. There are no unit tests--how could you unit test this thing--and you could imagine what would need to happen to get new features added. What if we wanted to edit one of these rows? What if we wanted to only filter on last name? What if we wanted to sort the rows? Could we do these things? Yes, but it wouldn't be easy.

So we're going to convert this into components. We'll see exactly how much code this will reduce and how much easier it is to work on this stuff once we isolate the parts of the application.

## Breaking Up the Application

So the first thing we're going to do is to define what the parts of the application are. What are the components here?

### User Table Component

The user table should be the most obvious component. It's there to display the user information in a table format. That can be a component we build. We would store the users in an array and use that array with a v-for to build the table.

For an interface, it's really only receiving information at this point, a new user. In fact, all the users could be managed outside of this component because it's only really interested in showing those users. So the users array would be a props property.

### Add New User

The add new user form is another component. The form will be there to add new user information, but where should the Add User button live? It should be in this component, because it's really just a toggle for the form.

What is the interface? It won't be receiving anything, but it will be emiting a `new-user` that contains a new object for the user array.

### Filter Users

What about the filter at the top? At first glance, this might feel like it's part of the table, but it's performing a different function than the table. The table shows the users, this picks which users to show. I could see this being enhanced in the future, and adding it to the table will muddy things up.

For its interface, it won't really be taking any information, but it will emit a new-filter event when characters are typed into it. It might not be clear how that will work yet, but we could just emit what was typed in and let the table component actually do the filtering with a computed property. Let's go with that for now.

> #### What About the CSS?
>
> The CSS that is currently on this page really belongs at the page level and not the component level. An argument could be made that the form CSS should live in that component, but a lot of the body level stuff is part of the main page and should, therefore, live in the main CSS style sheet for the site.

## Building the Components

So now we should be able to build these components. Since we want all of these components working together, let's start off with a main UserManager component that will act as the parent and traffic cop between all the others. Just rename the App.vue file and change main.js to include the new component.

### UserTable Component

Now add a components folder and create a UserTable.vue component. Now, before we go too much further, let's create our unit tests for the UserTable.

First, write a test that makes sure the component is a Vue component:

``` JavaScript
  it('should be a Vue component', () => {
    wrapper.isVueInstance().should.be.true;
  });
```

This should fail at first! That's good. To get that to pass, go to the vue component and add a script section and give it a name. That should make it pass.

Write a test that tests to make sure the table is rendering properly.

``` JavaScript
it('should show users when users prop is set', () => {
    wrapper.setProps({
      users: [
        {
          id: 1,
          firstName: 'TEST',
          lastName: 'LTEST',
          title: 'SENIOR TESTER',
          email: 'TEST@TEST.TEST',
          enabled: true
        }
      ]
    });

    let cells = wrapper.findAll('table tbody tr td');
    cells.at(0).text().should.equal('1');
    cells.at(1).text().should.equal('TEST LTEST');
    cells.at(2).text().should.equal('SENIOR TESTER');
    cells.at(3).text().should.equal('TEST@TEST.TEST');
    cells.at(4).text().should.equal('Yes');
});
```

If we run this test, it should fail.

We can now implement the component.

``` JavaScript
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
```

### NewUser Component

Now let's create a NewUser component. Again, create the Vue file and create the unit test under the `tests/unit` folder.

Always start with the first test to see if it's a component:

``` JavaScript
  it('should be a Vue component', () => {
    wrapper.isVueInstance().should.be.true;
  });
```

Write a test to make sure the form is hidden to begin with:

``` JavaScript
it('should not show form at first', () => {
    wrapper.find('#edit-screen').exists().should.be.false;
});
```

That will probably pass, because that form doesn't exist at all.

Then write a test that if the button is pressed, we should now see the form.

``` JavaScript
  it('should show form when button is clicked', () => {
    wrapper.find('button#new-user-button').trigger('click');

    wrapper.find('#edit-screen').exists().should.be.true;
  });
```

Now take the code from the old component and add it in to the template and add some methods to handle the event:

``` JavaScript
<template>
    <div class="new-user-component">
    <button id="new-user-button" v-on:click="enableForm">New User</button>
    <div id="edit-screen" v-if="enabled">
        <form>
            <div class="form-group">
                <label for="firstName">
                    First Name
                </label>
                <input type="text" id="firstName" name="firstName">
            </div>
            <div class="form-group">
                <label for="lastName">
                    Last Name
                </label>
                <input type="text" id="lastName" name="lastName">
            </div>
            <div class="form-group">
                <label for="title">
                    Title
                </label>
                <input type="text" id="title" name="title">
            </div>
            <div class="form-group">
                <label for="email">
                    Email Address
                </label>
                <input type="email" id="email" name="email">
            </div>
            <div class="form-group">
                <label for="enabled">
                    Enabled
                </label>
                <input type="checkbox" id="enabled" name="enabled">
            </div>
            <button type="submit">Save</button>
            <button id="cancel-save">Cancel</button>
        </form>
    </div>
    </div>
</template>

<script>
export default {
    name: 'new-user',
    data() {
        return {
            enabled: false
        }
    },
    methods: {
        enableForm() {
            this.enabled = true;
        }
    }
}
</script>
```

This component will also need to handle user data, so write a test to make sure the fields are linked to a user object.

``` JavaScript
   it('should save user information in data when entered into form', () => {
    // Need to click that button first or none of these are here
    wrapper.find('button#new-user-button').trigger('click');

    wrapper.find('input#firstName').setValue('TEST');
    wrapper.find('input#lastName').setValue('LTEST');
    wrapper.find('input#title').setValue('SENIOR TESTER');
    wrapper.find('input#email').setValue('TEST@TEST.TEST');
    wrapper.find('input#enabled').setChecked(true);

    wrapper.vm.user.should.deep.include({
      firstName: 'TEST',
      lastName: 'LTEST',
      title: 'SENIOR TESTER',
      email: 'TEST@TEST.TEST',
      enabled: true
    });
  });
```

Now add the v-model binding to all the input fields:

``` HTML
<input type="text" id="firstName" name="firstName" v-model="user.firstName">
etc.
```

And the user data property:

``` JavaScript
data() {
    return {
        enabled: false,
        user: {
            id: 0,
            firstName: '',
            lastName: '',
            title: '',
            email: '',
            enabled: false
        }
    }
},
```

Now, when this form is submitted, it should emit an event with the new user's information. We can write a test for that.

``` JavaScript
  it('should send new-user event with user information', () => {
    let userData = {
      firstName: 'TEST',
      lastName: 'LTEST',
      title: 'SENIOR TESTER',
      email: 'TEST@TEST.TEST',
      enabled: true
    };
    wrapper.setData({
      user: userData
    });

    wrapper.vm.performSubmit();
    wrapper.emitted('new-user')[0][0].should.deep.include(userData);
  });
```

And when that fails, write a method and set it up to make sure the event is sent:

``` JavaScript
performSubmit() {
    this.enabled = false;
    this.$emit('new-user', this.user);
    this.user = {
        id: 0,
        firstName: '',
        lastName: '',
        title: '',
        email: '',
        enabled: false
    };
}
```

``` HTML
<form v-on:submit.prevent="performSubmit">
```

There are a couple of other pieces that we'll want to take a look at too, there should be a random id being generated and the cancel button should cancel the adding of a new student.

#### Generate ID on Save

We can write a test to make sure an id that is not zero is being generated:

``` JavaScript
  it('should set a random id on user when user information is submitted', () => {
    let userData = {
      firstName: 'TEST',
      lastName: 'LTEST',
      title: 'SENIOR TESTER',
      email: 'TEST@TEST.TEST',
      enabled: true
    };
    wrapper.setData({
      user: userData
    });

    wrapper.vm.performSubmit();
    let generatedId = wrapper.emitted('new-user')[0][0].id;
    generatedId.should.be.a('Number');
    generatedId.should.not.equal(0);
  });
```

And then add that step into the `performSubmit()` method:

``` JavaScript
this.user.id = Math.floor(Math.random() * 1000);
this.$emit('new-user', this.user);
```

#### Enable Cancel Button to Clear and Hide New User Form

Once the cancel button is clicked, we would like to clear and hide the New User form. This should be a simple copy and paste from the `performSubmit()` method. That means we need a refactor.

First, let's write a new test for the cancel button:

``` JavaScript
  it('should blank out the user information when the cancel button is pressed', () => {
    wrapper.find('button#new-user-button').trigger('click');

    wrapper.find('input#firstName').setValue('TEST');
    wrapper.find('input#lastName').setValue('LTEST');
    wrapper.find('input#title').setValue('SENIOR TESTER');
    wrapper.find('input#email').setValue('TEST@TEST.TEST');
    wrapper.find('input#enabled').setChecked(true);

    wrapper.find('button#cancel-save').trigger('click');

    wrapper.vm.user.firstName.should.equal('');
    wrapper.vm.user.lastName.should.equal('');
    wrapper.vm.user.title.should.equal('');
    wrapper.vm.user.email.should.equal('');
    wrapper.vm.user.enabled.should.equal(false);
    wrapper.vm.user.id.should.equal(0);
  });
```

Now that we have a failing test, let's take the form clearing and hiding code out of the `performSubmit()` and put it in it's own method. These two methods will now look like this:

``` JavaScript
performSubmit() {
    this.user.id = Math.floor(Math.random() * 1000);
    this.$emit('new-user', this.user);
    this.closeForm();
},
closeForm() {
    this.enabled = false;
    this.user = {
        id: 0,
        firstName: '',
        lastName: '',
        title: '',
        email: '',
        enabled: false
    };
}
```

Now we can hook up the cancel button to the `closeForm()` method like so:

``` HTML
<button id="cancel-save" v-on:click.stop.prevent="closeForm">Cancel</button>
```

Running your tests now, you should have none that are failing. If your submit button test fails, check to make sure that you are calling the `closeForm()` method inside of the `performSubmit()` method.

### UserFilter Component

The user filter is another component. Create the component file and the first unit test.

Then write a unit test to make sure that the filter component is emitting a new-filter event when it is changed.

``` JavaScript
data() {
    return {
        filter: ''
    }
},
methods: {
    filterChange() {
        this.$emit('new-filter', this.filter);
    }
}
```

``` HTML
<input type="text" name="filter" id="filter" placeholder="Filter Users"
    v-model="filter" v-on:input="filterChange"/>
```

## Connecting the Components

Now we need to connect the components together. Go back into the UserManager component and import all of these components into it.

``` JavaScript
<script>
import UserTable from './components/UserTable.vue';
import NewUser from './components/NewUser.vue';
import UserFilter from './components/UserFilter.vue';

export default {
  components: {
    UserTable,
    UserFilter,
    NewUser
  }
}
</script>
```

Now we can add there HTML tags to the interface.

``` HTML
<template>
  <div id="app">
    <user-filter></user-filter>
    <user-table></user-table>
    <new-user></new-user>
  </div>
</template>
```

First, let's set up a data attribute that we can hand to the user-table as a prop for its users.

``` HTML
    <user-table v-bind:users="users"></user-table>
```

```JavaScript
  data() {
    return {
      users: []
    }
  }
```

Now let's catch those new users coming from the NewUser component and add them to that array.

``` JavaScript
  methods: {
    saveUser(user) {
      this.users.push(user);
    }
  }
```

``` HTML
<new-user v-on:new-user="saveUser"></new-user>
```

And what about the filter? Well, we didn't really deal with that. The filter is emitting an event, but we have nothing that actually filters the users. That could be something that we put on the UserTable component, but we could also let the UserManager component handle that too.

We can do that by changing the users property in the UserManager component to be called allUsers and then create a users computed property to pass to the UserTable component instead.

First, let's save the filter text so we have something to filter on.

``` JavaScript
    saveFilter(filter) {
      this.filterText = filter;
    }
```

``` HTML
<user-filter v-on:new-filter="saveFilter"></user-filter>
```

Then we can reengineer the data so that we keep all the users but just pass on a computed value to the UserTable component:

``` JavaScript
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
```

We've now mimicked the original application, with less code and fully tested. And it's obvious how we could add on to this. We have actual data objects and every component only worries about its specific responsibility and that's it.