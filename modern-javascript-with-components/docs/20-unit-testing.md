# Unit Testing Components (45 Minutes)

Now that we've written our first component, we're going to write our first unit tests. Unit testing a component is a little different than unit testing an object oriented class. We are still testing a component's data and functions, but since a component has a UI, we also need to test that it is working correctly as well.

A unit testing framework called Mocha was included in our project when it was created. We can find the files for that under the `tests/unit` folder. Currently, that folder should be empty, but we're going to add a new file there called `UserManagement.spec.js`. This will be the file where our unit tests for the `UserManagement.vue` component will live.

The first thing we will need to do for our unit tests is include our component:

``` JavaScript
import UserManagement from '@/components/UserManagement.vue';
```

We are then going to need to be able to run the component without mounting it onto a actual web page. We will do that using a Vue helper called `shallowMount`. Let's import that:

``` JavaScript
import { shallowMount } from '@vue/test-utils';
```

We then need to include our assertion library. If you've used jUnit or nUnit or any other xUnit like testing framework, then this will look a little different that what you're used to. We will be using assertions from a library called Chai and these assertions will be in Behavior Driven Development syntax. Namely, our assertions are going to look more like this:

``` JavaScript
wrapper.text().should.equal('Hello');
```

That `should` syntax comes from the Chai library and let's us write assertions in much more English language style. Many JavaScript libraries write their tests in this syntax, and we'll see this again when we get into integration testing with Cypress.

So let's import the Chai library as well:

```JavaScript
import chai from 'chai';
chai.should(); // This initializes our assertions
```

And now we're ready to test.

## Describing Our Tests

All of our tests will be sectioned off using the `describe` function. `describe` lets us group tests both visually in the UI that the test runs in and in our code, letting us know what component or function the tests are for. So let's create a section for our UserManagement tests:

``` JavaScript
describe('UserManagement', () => {
    // Actual unit tests go here
});
```

We can have `describe` calls inside of other `describe`s if we want to:

``` JavaScript
describe('UserManagement', () => {
    describe('Data Binding', () => {
        // Data binding unit tests go here
    });

    describe('Show User Information', () => {
        // Data display unit tests go here
    });
});
```

Let's do that for our unit tests now.

## Writing Unit Tests for Data Binding

Let's write a test to make sure that our data binding to our fields is working properly. A good unit test should test one, and only one, thing, so we're going to make sure that when text is entered into our `firstName` text box, the correct value is put into our `firstName` data attribute.

All unit tests in the Mocha testing framework will be in calls to the `it` function. We write them like this:

``` JavaScript
it('should set the firstName data attribute when text is entered into the firstName field', () => {
    //Assertions go here
});
```

The first part of that test is describing what the test is about and then we pass in an anonymous function that will contain the test code. This text that I've used might seem overly long, but if this test ever fails, I will know exactly what isn't working.

Now let's fill in that test with code. The first thing we'll need to do is to get an instance of our component. We can do that with the `shallowMount` method that we imported from the Vue utilities:

``` JavaScript
it('should set the firstName data attribute when text is entered into the firstName field', () => {
    
    const wrapper = shallowMount(UserManagement);
});
```

`wrapper` will now contain an instance of the `UserManagement` component. That wrapper will contain a number of functions that we can use to manipulate and validate the component.

The first thing that we'll want to do is get a handle on the input element for the `firstName` and set its value to `'TEST'`:

``` JavaScript
wrapper.find('input[name=firstName]').setValue('TEST');
```

Then we just need to make sure that the data attribute in the component now equals `'TEST'`. We can get the component through the wrapper's `vm` property--`vm` stands for Vue Model in this case--and we can get the component's data attributes through properties on the `vm`.

``` JavaScript
wrapper.vm.firstName.should.equal('TEST');
```

Here again, we're using the `should` syntax for the assertions. First we get the property that we want to test, then we can access `should` on that property and verify that its value equals the same value that we set on the input box.

The finished test will look something like this:

``` JavaScript
it('should set the firstName data attribute when text is entered into the firstName field', () => {
    const wrapper = shallowMount(UserManagement);

    wrapper.find('input[name=firstName]').setValue('TEST');
    wrapper.vm.firstName.should.equal('TEST');
});
```

Now, if you go to the integrated terminal in VS Code and run `npm run test:unit`, this test should run and pass. Congratulations on writing your first unit test in Vue.

You can write the same code almost for `lastName` and `notes` as well.

### Using `beforeEach` to Remove Code Duplication

If we do copy and paste those three tests, we'll quickly find out that we have some code duplication, namely the `shallowMount` of our component. We want a brand new component instance per test, but is there a way to do that in one place instead of in every test?

The Mocha testing framework does have that in the form of `before`, `after`, `beforeEach` and `afterEach` hooks that we can use in our code.

Let's move the `wrapper` creation into a `beforeEach` so that it runs before each of our tests. We'll have to change the `const`, because we can't create a wrapper per test if the variable is created as a constant.

``` JavaScript
/** @type Wrapper */
let wrapper;
beforeEach( () => {
    wrapper = shallowMount(UserManagement);
});
```

We can put this inside of a nested `describe` to keep it scoped to only a certain subset of tests or put it in the `describe` for `User Management` to have it available to all of our tests.

Now that we have that, let's take a look at how to test other input elements:

### Testing Select Boxes

Select boxes will work a lot like the text boxes. We just need to get a handle on it and call `setValue` to one of the available options.

``` JavaScript
wrapper.find('select[name=role]').setValue('admin');
wrapper.vm.role.should.equal('admin');
```

Write tests for the select box.

### Testing Radio Buttons and Checkboxes

When testing radio buttons and checkboxes, we can't just set the value of the input field like we did for text boxes. Instead, we'll need to grab a specific element and then set its `checked` property like so:

``` JavaScript
wrapper.find('input[name=gender][value=m]').setChecked(true);
```

Or, in other words, find the input element with a name of `gender` and a value of `m` and check it. Once you've done that, you can then verify the change in the component's data attributes:

``` JavaScript
wrapper.vm.gender.should.equal('m');
```

An important note for checking if a data attribute equals a certain array. In order to check arrays in an assertion, you'll need to use the `deep` modifier on the assertion to get the testing framework to check each value of the array.

``` JavaScript
wrapper.vm.permissions.should.deep.equal([]);
```

For the permissions checkboxes, the data attribute is an array and could hold more than one value, if the user selects more than one checkbox. So a good test to check for that will need to use the `deep` modifier:

``` JavaScript
wrapper.find('input[name=permissions][value=x]').setChecked(true);
wrapper.find('input[name=permissions][value=d]').setChecked(true);
wrapper.vm.permissions.should.deep.equal(['x', 'd']);
```

Write tests for the other radio buttons and the checkboxes.

## Writing Unit Tests for Component Display

We tested updating input elements update the data attributes in our component. We can do the same kind of tests to make sure the table cells are updating to the proper values. To test that, we will set the data on the component and then make sure the UI is properly updating. Let's do that with firstName.

First, we will set the data attribute for firstName:

``` JavaScript
wrapper.setData({'firstName': 'TEST'});
```

Now we want to know if the table cell is properly updated. We could add an id to every table cell so that we can use `find()` to get the exact one we want, or we can use `findAll()` to get all the table cells and then select the one we want to check from the results. We'll use that here to get the first cell--using the `at(0)` function on the results--from the row in `tbody` and make sure that it contains `'TEST'`:

``` JavaScript
wrapper.findAll('table tbody tr td').at(0).text().should.equal('TEST');
```

And now you can write tests for all the various display bindings.

### Assertions for Multiple Checkboxes

The `permissions` data attribute is a bit of special case since it's an array that is being converted to text. For that case, we can use another assert called `include()` to check to make sure the values are in the cell. That let's us write an assertion like:

```JavaScript
wrapper.setData({'permissions': ['w', 'd']});
wrapper.findAll('table tbody tr td').at(5).text().should.include("w").and.include("d");
```

And with that, you should be able to write the rest of the tests for this component.

We can now see how to write unit tests for our component. We will be writing these tests for the rest of the class for all new functionality and components that we create.