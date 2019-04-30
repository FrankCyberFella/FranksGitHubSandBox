# The Tool Chain (30 Minutes)

Before we can fully jump into making a component, let's take a look at the tools we will be using.

## Vue.js

The first thing we will need is a framework to build the components in. JavaScript, by default, does not have a framework for component-based development. There is a web standard that is being worked on called Web Components, but it hasn't been fully supported yet and has a lot of shortcomings.

There are many frameworks to choose from, many of which you've probably heard about. Angular, React, Polymer. However, many of these frameworks are very heavy or cumbersome if we just want to make a component or two for an existing site.

Vue.js is a framework that is very lightweight and easily used to build components that can live along side other functionality on an existing site. All of the concepts that you'll learn here are easily transferable to any of the other frameworks mentioned above. The biggest difference will be the syntax that you might need to learn for a different framework.

In order to use Vue, we're going to need a tool chain that can take the code that we write and convert it into plain JavaScript that will run in the browser. Due to the nature of how we will be writing the code, a transpiler will be needed to convert the Vue components that we write into regular JavaScript.

To run this tool chain, we will be using NPM. NPM stands for the Node Package Manager and will be used to manage our code's dependencies and to transpile and build our code as well as run our unit tests and development server. You should already have NPM installed as part of your pre-work for this class.

## The Vue CLI

Vue.js also has a command line application that we can use to set up a new application. First, we will need to install it via NPM:

```shell
sudo npm install -g @vue/cli
```

This command line tool will give us a quick adn easy way to get a new Vue project set up with all the tools we will need for our development.

## Generating a Project

To start a new project, open your integrated Terminal in VS Code and type:

```shell
vue create first-project
```

This will walk us through picking a number of modules and defaults for our project. We're going to pick a number of these modules to set up a project structure for our code. Select the following modules:

- Babel - Used so that we can write our code in modern JavaScript but still have it compatible with all major browsers.
- CSS Pre-processors - This lets us use a preprocessor for our CSS--in this example SCSS--so that we can use a more modular syntax for your CSS.
- ESLint - to check syntax and common errors when the project is built.
- Unit Testing using Mocha and Chai - for an easy to use unit testing framework for your components.
- E2E Testing using Cypress - in order to do black box and integration testing using the Cypress testing framework.

> #### Note::Possible Student Issues
>
> Some students might not understand how to navigate a command line option list like this. Let them know that the arrow keys are for navigating through the items, space selects an item and enter goes to the next screen.
>
> There was also an issue where one students has a VPN and proxy installed on their machine and wasn't able to connect with NPM. That was a configuration issue that they were able to get sorted out with their tech support.

There's a lot to learn here, but we're going to learn it one step at a time. First, we're going to make our first component.