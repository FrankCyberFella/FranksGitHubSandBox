# Using `v-on` for Event Handling (45 Minutes)

A JavaScript UI wouldn't be useful if it wasn't able to handle events from the user. As we talked about yesterday, these front-end frameworks are designed to handle DOM manipulation--as we saw with the `v-bind` and `{{ ... }}` syntax--and make event handling easier. Vue does that with the `v-on` attribute.

## Adding Behavior to Our Components

Before we dive too far into event handling, we need to talk about how we add behavior to our components. Much like classes in an OOP language has methods to encapsulate a class's behavior, Vue also lets us add methods to our components.

We already saw that we can add a function to the `computed` section, but that is just to filter or calculate information from existing data. What about making an AJAX call or any complex logic to transform or change data?

For these more complex operations, we have the `methods` section of the component.

Let's add a method to our component that will take all the form data and submit it to a back-end api call. This method will take all the data attributes in the component--the values coming from the data bound input fields--and send them to a back-end api.

### Structuring Our Data for an API

The first thing we're going to do is refactor how we're handling our data in our component. Mainly, we're going to put all of the data that we want to send to the back-end into its own object. We'll call that object the `order` object.

By sectioning this data off, we can more easily handle it when the time comes to send it off to the back-end. So let's first restructure the `data` section of our component to include an `order` object with all the properties from the form:

``` JavaScript
data() {
    return {
        order: {
            firstName: '',
            lastName: '',
            shippingAddressOne: '',
            shippingAddressTwo: '',
            shippingCity: '',
            shippingState: '',
            shippingZip: '',
            billingAddressOne: '',
            billingAddressTwo: '',
            billingCity: '',
            billingState: '',
            billingZip:'',
            creditCardNumber: '',
            creditCardType: '',
            expDate: ''
        },
        sameAddress: false,
        creditLogoSrc: '../assets/credit.png',
...
```

Now we need to restructure how we use `v-model` in our UI. Instead of linking the first name field to `firstName`, we now just need to link it to `order.firstName`. The same is true for every other field in that interface.

Now we have an object that contains everything we need to make API calls to our back-end just by reengineering how that data is laid out. If we run our unit tests, we'll see that some of the fail, but those can be fixed now by restructuring how the data is save there as well. For example, in the firstName tests, we just need to set the data like so:

``` JavaScript
wrapper.setData({'order': {'firstName': 'TEST'}});
```

### Using `fetch` for API Calls

We're going to use `fetch` to perform our API calls. `fetch` is a newer way to make API calls that uses Promises to handle the information. We can pass all form information to the POST call using a `FormData` object.

``` JavaScript
methods: {
    saveOrder() {
        let url = 'https://httpbin.org/anything';

        let form = new FormData();
        for(let name in this.order) {
            form.append(name, this.order[name]);
        }

        return fetch(url, {
            method: 'POST',
            body: form
        }).then((response) => {
            return response.json();
        }).then((returnedData) => {
            this.message = 'Successfully Saved.';
        }).catch(() => {
            this.message = 'An Error Occurred';
        });
    }
}
```

There are quite a few new concepts here that you may be seeing for the first time if you've never used `fetch` before. The first thing to understand is, you don't need to use `fetch`. Vue is agnostic when it comes to how network calls are made. You could use the XMLHTTPRequest object or jQuery if you wanted to. I find that `fetch` makes all of this easier to unit test and know that I could use a polyfill to support any browser that doesn't support `fetch` directly.

`FormData` is another object that `fetch` uses to send data to a back-end. It represents the POST data from a form and what we are doing with it above is creating a new FormData object and filling it with everything from the `order` object from our data. Since that `order` object is being filled in with its bound form fields, all of that information will be put into the `FormData` object and send off to the back-end as POST data.

As you can see, we are also adding in a new data attribute, a `message` that we can use at the top of our form to show a message to the user about this API call. Let's add that data property to the `data()` function and add a `div` at the top of the form to show the message, if it's available.

``` HTML
<form class="order-form">
    <div class="message" v-if="message != ''">{{ message }}</div>
    <div class="form-group">
```

## Using `v-on:submit` to Listen for Submit Events

Now, we want this method to be called when the form is submitted. Normally this would entail getting the form from the DOM and calling a `addEventListener` to it for a `submit` event. But we can use the `v-on` syntax instead to attach the methods to that element:

``` HTML
<form class="order-form" v-on:submit="saveOrder">
```

If we save this and try it, we see that the form still submits. We need to `preventDefault`. But Vue gives us a short cut for this. We can attach the event handler with a special `.prevent` modifier.

``` HTML
<form class="order-form" v-on:submit.prevent="saveOrder">
```

This is all we need to do to make the form submission happen over an API call rather than a round trip request.

There are a couple of other modifiers we can use on event handlers using `v-on`:

- `.stop` - Will call stopPropagation() on the event.
- `.once` - The handler will only be called once and then deregistered.
- `.passive` - Which will act just like adding the passive flag to addEventListener.

## Unit Testing Methods

In components, you don't really need to test the event handling at the unit test level. We can assume that the framework already has that handled for us. But we do need to test the methods. And we also want to make sure we *don't* unit test our APIs. Unit testing should all be about the code that we have in our component and not about the dependencies that our code relies on.

Looking at our method, what we really want to test is that, when the method is called, it will take all the form data, send it to the API, and then display an appropriate message back to the front-end. To do that, we'll want to mock out our `fetch` call.

### Installing `fetch-mock`

There are a couple of things that we'll want to install via NPM to allow testing of methods with `fetch` calls. To install new libraries that we might need in our projects, we will be editing the `package.json` file. `package.json` file acts as our project's dependency list. Much like Maven or NuGet, NPM is our dependency manager in JavaScript and we can install new packages easily by adding them to the `package.json` file and running `npm install`. We can find new libraries by searching for them on npmjs.com.

The first library we're going to install is called `node-fetch`. This is a library that adds the fetch function into node. Modern browsers already have fetch defined on them, but node is still missing that function. This library will add it in for us. To install it, we will run:

``` shell
npm install node-fetch --save-dev
```

We're using `--save-dev` above because we want it added to the package.json file for us, but only as a development dependency. We won't be running our unit tests in production and don't want these libraries installed there either.

We also want to mock our fetch calls, so that it won't actually go over the network but will just return test data that we define. For that, we'll need to install `fetch-mock`.

``` shell
npm install fetch-mock --save-dev
```

We also need to set up a new configuration file. `node-fetch` is written using a new `mjs` format. Babel can handle this, but we need to tell it to do just that. To do that we'll make a new `vue.config.js` file in the project root to tell it about `.mjs` files. That is already included, but you'll need to add it to any new project you might create.

### Testing an API Call

With these tools installed, we can now fake a call to a back-end API and have fetch return whatever data we want it to when the method is called.

So let's write a unit test that will test the `saveOrder` method. The first thing we will need to do it load the `fetch-mock` library in our imports:

``` JavaScript
import fetchMock from 'fetch-mock';
```

We also want to set up a `before` hook that will allow us to reset `fetchMock` after each test so that we can set up the fetch calls to return exactly what we want after each test run.

``` JavaScript
before( () => {
    // Allow each test to overwrite the mocked calls
    fetchMock.config.overwriteRoutes = true;
});
```

We can now fake a `fetch` call with the following code in our actual unit test:

``` JavaScript
fetchMock.post('https://httpbin.org/anything',
    { status: 200, body: '{"success":true}'});
```

This will configure our `fetch` call so that when a POST is made to 'https://httpbin.org/anything', it will return a 200 status and the JSON:

``` JSON
{
    "success": true
}
```

Now we just need to check to make sure that when we call `saveOrder()` that the message updates appropriately, right? Well, not quite.

### Testing Asynchronous Calls with Promises

One thing to remember when testing any kind of network call is that network calls in JavaScript are always asynchronous. This asynchronous nature can cause problems in testing the code. While we may have mocked the `fetch` call, we will still need to wait for the asynchronous call do finish before we can verify that the `saveOrder()` methods has done what it is supposed to do.

There are two ways of doing this in our unit tests. The first one we'll look at uses async/await.

#### Using Async/Await

Let's write a unit test that will test to make sure a successful call to the API sets the success message in the data's `message` property. Normally, if we forgot about the asynchronous call in the `saveOrder()` method, we might write that like this:

``` JavaScript
it('should set the success message when API is called successfully', () => {
    // When a POST is made to 'https://httpbin.org/anything', return a 200 status
    fetchMock.post('https://httpbin.org/anything', { status: 200, body: '{"success":true}'});

    wrapper.vm.saveOrder();
    wrapper.vm.message.should.equal('Successfully Saved.');
});
```

But if we run this unit test, it doesn't work. It tells us that the message is empty. That's because the `saveOrder()` method is creating a Promise and then immediately ending. That Promise is running in the background and only finishes running after our test is complete. So we need to wait for that Promise to completely finish before we can run our assertions.

To do that, we'll need to do a couple of things. First, we need to return the Promise that `fetch` is creating in the `saveOrder()` method. To do that, we just need to add `return` before the `fetch` call. We can now use that in our test.

Next, we need to add the keyword `async` before the anonymous function for the test, telling JavaScript that there will be an asynchronous call inside this function, and `await` before the call to `saveOrder()`, telling JavaScript to wait on this Promise to finish before proceeding. That will look like this:

``` JavaScript
it('should set the success message when API is called successfully', async () => {
    // When a POST is made to 'https://httpbin.org/anything', return a 200 status
    fetchMock.post('https://httpbin.org/anything', { status: 200, body: '{"success":true}'});

    await wrapper.vm.saveOrder();
    wrapper.vm.message.should.equal('Successfully Saved.');
});
```

Now, when `saveOrder()` is called, JavaScript will wait here until that API is completely finished before moving on to the next line of code. That means that the `then()`s that we added to the `fetch` call will have all the time they need to complete before we go looking for what the component's message property is set to.

#### Using Promises

We can also just use the Promises built in functionality to do this also. With Promises, you can always add another `then()` function to be run once the Promises fulfills what it needs to do.

We'll still need to have the Promise returned from the `saveOrder()` method just as before, but instead of using `async/await`, we are going to add another `then()` call that holds our assertions so that they run once the Promise is fulfilled.

One thing that we'll need to do for this is to use a mechanic that Mocha has set up to alert it that our test is finished. It will give a parameter to our function defined in the `it()` call that we will need to call once we are all done. We always need to do this when our test code calls an asynchronous function.

Let's write a test that makes sure a bad response, an undefined value in the body, sets the message to our error message.

First, we'll set up our fetch to return a 400 with no defined body:

``` JavaScript
it('should set the failure message when API fails',
    // Mocha gives us a `done` function that we must call once we are finished
    (done) => {
        // When a POST is made to 'https://httpbin.org/anything', return a 400 status and no body
        fetchMock.post('https://httpbin.org/anything', 400);
```

Then we will make our call to `saveOrder()` and attach a `then()` to it that will run our assertions:

``` JavaScript
    wrapper.vm.saveOrder().then(() => {
        wrapper.vm.message.should.equal('An Error Occurred');

        // Tell Mocha we're finished
        done();
    });
});
```

Calling the `done()` function is important. Otherwise, Mocha will just wait on us to be finished and will time out and fail after 3 seconds.

Either way you want to test asynchronous code will work. They are both considered to be best practice. Pick the one that makes the most sense to you.