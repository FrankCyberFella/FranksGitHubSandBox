# Building and Deploying Your Components (30 Minutes)

As we've seen, the components we've been making live in a project that would generally be separate from the rest of your application. That's not very useful if that's how it stayed however. Since we aren't writing our components in straight JavaScript and have to go through a build process to compile them to run in a browser, we will need to see how to build components for final deployment to an application.

## Building as an Application

If we built the project to be a single page application in pure JavaScript, building and deploying is pretty straight forward. Just run `npm run build` and the Vue CLI will turn your components into JavaScript and put them into a `dist` folder under your project. This will include an `index.html` file and all the JavaScript code from Vue (and Vuex if used), your components and the `main.js` that you configured in your project. It also extracts the CSS from all the components and puts it into one minified file. These files are ready to deploy directly to your site as an SPA.

## Building as a Parent/Child Component

Building a component to go on a page is done basically the same way, except that you won't need the `index.html` file. Just grab the `js` and `css` folders, or the assets in them, and add them to the static assets of your project. You could do this by writing a script for `npm` or using another build tool to kick off the npm build and copy the assets for you.

Then you will include the files on your page and add a tag that matches the tag that you defined in the project's `index.html` and your tag will be mounted when that page loads.

## Building Multiple Independent Components

If you're using Vuex data stores in the application, you won't need the parent component to contain all of the other components. You also won't need the `index.html` or the `main.js` once they are deployed. That's because you can package independent components as Web Components.

Web Components are a browser standard that is being adopted by many newer browsers to do just what we talked about here, build pieces of functionality that can be used as custom HTML elements.

To show how we can use Vue components as Web Components, we're going to add a new build option to our `user-management-vuex` project. Open the `package.json` file and add this to the `scripts` section:

``` JSON
"build:wc": "vue-cli-service build --target wc 'src/components/*.vue'"
```

Now, if we execute `npm run build:wc` all of our components will be packaged up as Web Components and put into a single JavaScript file, here called `user-management-vuex.min.js`. We can now put this on our site and include our components as Web Components.

To show how this works, make another folder in your work directory called `sample-component-demo`. copy the minified JavaScript file into that folder and make a new `index.html` in there as well. Type this in to the HTML file:

``` HTML
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
<script src="https://unpkg.com/vue"></script>
<script src="https://unpkg.com/@webcomponents/webcomponentsjs/webcomponents-loader.js"></script>
<script  src="user-management-vuex.min.js"></script>
    <title>Vue Components on a web page</title>
</head>
<body>
    <div class="container">
        <h1>User Management Demo</h1>
        
        <hr>
        <user-management-vuex-user-table></user-management-vuex-user-table>
        <p>Feel free to add users as you need to.</p>
        <user-management-vuex-new-user></user-management-vuex-new-user>
        Filter: <user-management-vuex-user-filter></user-management-vuex-user-filter>
    </div>
</body>
</html>
```

You'll see that in order to use our Web Components, we need to load a couple of other JavaScript files. First, is the Vue library. It does not get included when we build the components, but it is easy enough to load from a CDN.

Next are polyfills for Web Components. These are already built into Chrome and will soon be added to Firefox. This polyfill will make them work for all browsers back to IE 11. It will also only download the polyfills that the browser needs, so the Chrome and Firefox will be minimal.

Then we load in our Web Components. And that's it. We just include the tag--prepended with the project name--on the page and the components will just load. This is a great way to add a lot of different components to a project and then you can just add a tag to the page when you want one to show up.

One thing to note, if you're using Web Components natively to the browser, the components will *not* be able to use the CSS defined on the site. You can solve that by loading the CSS into the component. The CSS file itself will only be loaded from the server once, but by putting an `@import` in your component, the component is saying that it wants to use it to.

That would look something like this:

``` CSS
<style>
@import url( 'https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css' ); 
</style>
```