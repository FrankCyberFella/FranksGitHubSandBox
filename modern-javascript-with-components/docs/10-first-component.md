# The First Component (30 Minutes)

There is a lot that gets generated for a new project, but what we're going to focus on right now is what's in the `src` folder. This is where all of our component code is going to go.

Vue components are loaded onto a page inside of a main component called a root Vue instance. You can have multiple root Vue instances on one page, but if components are going to communicate with each other, they will need to live inside the same root Vue instance.

In our new project, our root Vue component is conveniently called `App.vue` and lives in our `src` folder. This is the engine that will start and coordinate our Vue components.

Looking at this component, we can see all the basic elements that will make up a Vue component.

At the top, surrounded by `<template>` tags, is the HTML that defines the structure and content of the component. The App component contains HTML for a div, an image, and an `<HelloWorld>` tag. Remember how I said that components are just custom HTML elements? This tag will eventually be replaced by another component that is defined elsewhere. We'll take a look at that later.

Next is the JavaScript inside of `<script>` tags. The JavaScript represents the data and behavior for our component. For the App component, most of its functionality is in loading other components into the page. Here it is loading in the HelloWorld component.

The `<script>` tag also defines the Vue object for the component. This object will contain all the configuration needed to create a Vue instance from our component code. We will be going over all of the parts of this as we go through this course.

In the App component, we can see that it's defined with a `name` and what other `components` it contains. A Vue component can be as simple as that.

Next is the CSS. We've told Vue CLI to use SCSS for our CSS and we can use that right inside of our components. This CSS defines the default view and layout for the component. A site wide CSS can still change or apply new styles to this component if it wants to, but any CSS we right in a component is scoped to only apply to that component.

And those are the three pieces of a component. HTML, CSS, and JavaScript.

If you run `npm run serve` in the integrated terminal, this will compile the code and run it using a virtual server for you to view.

Now, let's make our own.

## Creating a Component From Scratch

We're now going to create a simple component. All components that we will be making will be created in their own `.vue` file in the `components` directory.

Create a new file in the `components` directory called `first-component.vue`. This is where we will create a simple component and include it into the index page.

First, we'll fill out the HTML that we want to show up when the component is rendered.

> #### One Root Element
>
> One key to remember here is that each Vue component must have only one root element. That means that inside the `<template>` tags, there must be an HTML element that holds all the rest of the component's HTML.
>
> Typically that tag is a div.

```HTML
<template>
    <div>
        <h1>{{message}}</h1>
    </div>
</template>
```

This defines our component as a `<div>` tag that contains an `<h1>` tag. When our component is shown, the `<template>` tags won't be included in the display, but everything else that's between them will.

The syntax of `{{message}}` is an example of data binding, which we will see in a minute. It will always show the value of our component's `message` data field.

Now that we have our HTML, we can add in some CSS. The order of these sections doesn't really matter, so even though the App component had the CSS last, we can put it second or even first if it makes sense to us.

Let's add the following CSS:

``` SCSS
<style scoped lang="scss">
    h1 {
        color: blue;
    }
</style>
```

Again, we can use the SCSS pre-processor language instead of just straight CSS. This will set the `<h1>` color to blue, but only the one in the component since we have also `scoped` the CSS to just this component.

Now we can add in the Vue object that will define the behavior and data for this component:

``` JavaScript
<script>
export default {
    name: 'first-component',
    data() {
        return {
            message: 'Our message from the first component'
        }
    }
}
</script>
```

If you save those three sections into your `first-component.vue` file, that will give you a complete Vue component. You can now go into the `App.vue` file and load it from there.

In `App.vue`, go to the beginning of the JavaScript section and add in a new import line to import your new component:

``` JavaScript
<script>
import HelloWorld from './components/HelloWorld.vue'
import FirstComponent from './components/first-component.vue'
```

Then add the component to the `components` section of the Vue object:

``` JavaScript
  components: {
    HelloWorld,
    FirstComponent
  }
```

Finally, we add in the tag to the `<template>` section at the top of the `App.vue` component to show our new tag on the page.

```HTML
  <div id="app">
    <first-component/>
    <img alt="Vue logo" src="./assets/logo.png">
```

> #### Why do we use the name `first-component`?
>
> The reason the tag is called `first-component` here is because that's the `name` of the component. Whatever we set the `name` to in the component's Vue object is going to be the name of the tag. It's good to make the name a kebab cased value because, according to the HTML standard, all custom made HTML elements should be all lower case and contain a hyphen to separate them from the standard HTML elements.
>
> As a special note, the auto generated HelloWorld component does *not* follow this standard and should be considered poorly named.

After saving this file, you should see the component show up on your in browser preview. You may need to run `npm run serve` again to start up the live preview.

Now that we see the basic workflow for creating a new component, let's take a look at what we can do with components.