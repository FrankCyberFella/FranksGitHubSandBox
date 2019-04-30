# How to Design a Component-Based Application (90 Minutes)

We've now stepped through how to write and test Vue components. You now learned everything that you need to know to create components but how should be think about designing these components? What makes a good component? What are the best practices we can use to make sure components are well-built, reusable, and maintainable?

At the beginning of the first day, we talked about what components are and the fact that we wanted to move away from a monolithic structure of building all the code for a page's functionality as one giant JavaScript file. We want to start thinking of our application as pieces working together.

A popular definition of components is:

> Components are stand-alone, independent parts of the application which are responsible for handling only one job and don’t know about each other.

Let's look at the pieces of this definition and start to formulate a plan on how to think about designing components.

## Stand-Alone and Independent

Components should be built in such a way that they are stand-alone and independent, both from other components and from other things that might not be components running on the site. A component is able to contain all of the data, behavior, UI, and general layout needed to run itself and should need to rely on anything outside of itself to get its own job done.

This independence makes unit testing simple and makes future changes and refactoring much simpler than if the component had to worry about every other piece of functionality on the site. This doesn't mean that the component will never interact with other components on the page, but that those interactions are required for the component to function normally. In fact, by not requiring any other component explicitly, we open up the possibility for a component to be used in different contexts to be used for different purposes.

## Parts of the Application

What makes components powerful is that it is only one small part of an application. An application or a web page should be made up of many components, all working together to create a complete whole. Much like a car is made up of lots of replaceable and independent pieces, an application made of components should act the same way.

## Responsible for Handling Only One Job

Each component in the application should only be handling one job. If a component isn't trying to handle an entire dashboard but is instead focused on just one graph on that dashboard, that component is going to be easier to test, easier to maintain and easier to reuse in another context. We should be trying, when looking at our application, to specify components in as limited a functional context as we can. We can then look at how to make these components work together to build a larger application.

## Don't Know About Each Other

Our components shouldn't know about or rely on other components that might be on the same page or application. That may sound strange at first. How can components work together if they don't know that other components exist?

But this is just the same concept of an application that handles printing. When the application is built, does it know what printers are available? No. In fact, new printers are created all the time that it will have to interact with. But the programmers of that application build an interface and tell the printer manufactures that if they build their printer drivers to support that interface, then their application will work with that printer. The print manager application doesn't really know one printer from another, but as long as the interface is followed then everything will work together.

And that is how we will get our components to work together, by following interfaces between them. JavaScript doesn't have the concept of a programmatic interface, so we will have to document these interfaces ourselves. To build these interfaces in Vue, we will be looking at two aspects of our components that we haven't touched on yet: custom events and props.

## Custom Events for Outputting Data

Custom Events form our component's output. Whenever we want to send information out of our component to another part of the application, our component will emit an event. We'll look at the mechanics of this later, but for now we just need to understand what a custom event is made of.

All custom events will have two parts to it. The first is the name of the event. This can be whatever we want it to be, but it's usually seen in the form of a noun. Our component has performed an action and it is sending out the results of that action. `search-results`, `product-details`, and `new-message` are all good custom event names.

The second piece of a custom event is the data that is attached to that event. Usually after an action is performed, data is generated that can be sent along with the event. For example, on a `search-results` event, a JavaScript object with the search results contained in it can be sent along with the event. The structure of that data object should be carefully documented with the event so that other components will know what they will be getting.

And where does that event go? That event will go to another component. That component will be developed so that it knows what events to listen to, via `v-on`, and what structure the data is in so that it knows how to handle it. It has no idea how that data was retrieved or exactly what component created that data, only what the *interface* for that information is.

So if a component is outputting data, it will send a name and a data structure. What about if the component is receiving data?

## Props for Receiving Data

Vue components have several different types of properties; `data`, `computed`, and one that we'll look at now called `props`. `props` are specifically data that are changed outside of the component and then injected in. `props` are the way that data get into our components and then can be used inside the components to perform other actions.

`props` properties can be used inside the components just like any other kind of properties. They can be bound to UI elements using `v-for` or `{{ ... }}`--`props` are almost never two-way bound to input elements because they are changed from outside the component--and can be used inside methods or other computed properties. They are useful to set configuration options on a component, like what API URL it should connect to or what display options should be shown. But they can also be used to set the main data that a component needs based on what custom events other components might be triggering.

## Building Communicating Components

To see this in action, let's imagine an application that will allow us to search a car manufacturer API. On any kind of search screen,we will need two main features; a search box and a list of results. We could build these in one component and is probably the natural inclination to solve this problem, but let's look at these two functions. Because they are two separate functions. They work together, but they don't have to be together and part of the same thing. One of our principles is that a component should be responsible for handling only one job. Making an API call based on a search string and then showing those results to the user and two different things.

So we'll write two different components for these actions. Now let's define the interfaces in terms of custom events and input and output data.

### Defining the Search Box

Our search box component will have one responsibility, using user input to perform a search via an API.

What are the `props` this component would have? It won't need to accept any input from other components, but we can make it a very generic component by having the URL to the API added to it as a property. So we'll define a property that can be set on this component as `searchUrl`.

What are the custom events? This component will be pulling back search results from the API and then sending an event with those results in them. We'll call this event `search-results`.

### Defining the Results Display

Our results can be shown as a table of results.

What are the `props` in this component? The search results from the Search Box. That is the data coming in that we want to show in the table.

What is the output as custom events? There are none at the moment.

## Building the Components

So we have a `search-box` component that will take a `searchUrl` as a `props` property and emit a `search-results` event and a `results-display` component that will take a `searchResults` `props` property and use that to display a table of results. Let's build those components.

The first thing to look at will be building the SearchBox component. Make a new folder under `src` called components and then make a `SearchBox.vue` file there.

First, let's define our interface for the user. It'll just be a simple form with a text field and a button:

``` HTML
<template>
    <form>
        <input type="text" name="search" id="search">
        <button type="submit">Search</button>
    </form>
</template>
```

Now let's define our logic. What do we need? We need a data property to bind to the search box. We need a method to handle the form submission. We need a props property to hold the URL we are submitting the search to. Let's create those:

``` JavaScript
export default {
    name: 'search-box',
    data() {
        return {
            search: ''
        };
    },
    props: {
        searchUrl: String
    },
    methods: {
        performSearch() {
            fetch(this.searchUrl + this.search + '?format=json').then((response) => {
                return response.json();
            }).then((results) => {
                this.$emit('search-results', results);
            });
        }
    }
}
```

In order to send our results to other components, we must emit a custom event. We said that our custom event will be called `search-results` and so we call that here and send along all the results that we got back from the API call.

Now we need to wire the JavaScript to the HTML using `v-model` for the search field and `v-on` for the form submission.

Now let's create another component, the ResultsDisplay component.

Create a new file called ResultsDisplay.vue in the components folder. This component will involve a table that will display search results. This component will need to know a little more about how the data is structured. We will be doing a search off of a Department of Transportation safety database. https://vpic.nhtsa.dot.gov/api/Home

We will be searching manufacturers from this database in the following format:

``` JSON
{
    "Results": [
        "Make_ID": 474,
        "Make_Name": "Honda",
        "Mfr_Name": "HONDA MOTOR CO., LTD"
    ],
    ...
}
```

So let's build our component with that in mind.

First, we'll add our JavaScript, knowing that we will be given a `props` property for the results.

``` JavaScript
export default {
    name: 'results-display',
    props: {
        results: Array
    }
}
```

Now we can build the HTML

``` HTML
<template>
    <table v-if="results">
        <tr>
            <th>ID</th>
            <th>Make Name</th>
            <th>Manufacturer's Name</th>
        </tr>
        <tr v-for="result in results">
            <td>{{ result['Make_ID'] }}</td>
            <td>{{ result['Make_Name'] }}</td>
            <td>{{ result['Mfr_Name'] }}</td>
        </tr>
    </table>
</template>
```

Once that's done, we'll see how to wire up components so that they can talk to each other.

## Setting up the Parent Component

To get two components to talk to each other, they must both be a member of the same parent component. A parent component in Vue acts as a communication manager between components, routing messages and data to where they need to go.

The project we created already has a parent component created called App. We'll use that as the component that holds both of our search components.

First, we will need to open the App.vue file. There's not much to it at the moment, but we are going to need to import our two components and include them in this component. First, let's import them.

``` JavaScript
import SearchBox from './components/SearchBox.vue';
import ResultsDisplay from './components/ResultsDisplay.vue';
```

Then we define them as child components to the App component:

``` JavaScript
export default {
  name: 'app',
  components: {
    SearchBox,
    ResultsDisplay
  }
}
```

And then add them to that component's display. Remember that we use the component's `name`s here for the tags:

``` HTML
<template>
  <div id="app">
    <search-box></search-box>
    <results-display></results-display>
  </div>
</template>
```

Now that they are added, we need to handle their inputs and outputs. The App component is now like our switchboard, ready to route the data coming from the components and getting data to the components.

First, we need to pass the search url to the `search-box` component. We can do that by just adding an attribute to the tag:

``` HTML
<search-box
    search-url="https://vpic.nhtsa.dot.gov/api/vehicles/getmakeformanufacturer/">
</search-box>
```

We are also going to be getting data back from the search, so we also need to add a method to App that will listen to that event.

``` HTML
<search-box
    search-url="https://vpic.nhtsa.dot.gov/api/vehicles/getmakeformanufacturer/"
    v-on:search-results="handleResults">
</search-box>
```

``` JavaScript
  data() {
    return {
      searchResults: { "Results": [] }
    }
  },
  methods: {
    handleResults(newResults) {
      this.searchResults = newResults;
    }
  }
```

So when a new `search-results` event comes in from the search-box, we handle it with a call to `handleResults`. We take the new results we were given and save them to a data property on the App component. Now we just need to get that to the ResultsDisplay component, which we can do by binding the searchResults property to the ResultsDisplay props property called results.

``` HTML
<results-display v-bind:results="searchResults"></results-display>
```

If you run the application, it should run just fine.

That might have seemed like a lot to keep track of, but just remember about our interfaces. If we know what the inputs and the outputs are to the components, then we can plan out what they will need and what they will be giving out. Then it's just a matter of wiring them together in the parent component.

For inputs to a component, that will be done via attributes in the parent, either hard-coded like the url in the `search-box` tag or bound to data attributes like the `search-results` in the `results-display` tag.

For outputs, the parent tag will listen for them with a `v-on` just like any other event and then handle the event in a method.

Other than that, the parent component stays pretty dumb. Much like a controller in the MVC architecture, the parent component shouldn't have much logic in it. It's just there to route messages from one component to another.

By defining these interfaces and then focusing on one component at a time, we can now think of our application as specific pieces to be built and not as a whole that has to be kept in mind while building everything else.