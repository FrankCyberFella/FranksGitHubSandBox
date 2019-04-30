# Curriculum and Documentation for Modern JavaScript with Components Class

This repository holds all the notes, schedules, exercises, and review material for Tech Elevator's Modern JavaScript with Components class.

## Technologies

This class will teach the use of a number of tools and technologies, including:

1. [NPM](https://www.npmjs.com/) - A JavaScript dependency management and build tool.
2. [Babel](https://babeljs.io/) - A JavaScript transpiler to turn ES6 code into cross browser ES5 code.
3. [Vue.js](https://vuejs.org/) - A JavaScript component framework that will be used to create JavaScript components.
4. [Vuex](https://vuex.vuejs.org/) - A Flux-like state management system for front-end applications.
4. [Mocha](https://mochajs.org/) and [Chai](http://www.chaijs.com/) - A Unit test runner and assertion framework--respectively--that will allow easy unit testing of the components.
5. [Vue Testing Utilities](https://vue-test-utils.vuejs.org/) - A library of tools that allow unit tests into the internals of Vue components.
6. [Cypress](https://www.cypress.io/) - A testing framework for easy E2E testing of the components.
7. [Visual Studio Code](https://code.visualstudio.com/) - A code editor that works well on all platforms and has many JavaScript editing tools built in.
8. [ESLint](https://eslint.org/) - Highly configurable linter for JavaScript.
9. [Vetur](https://marketplace.visualstudio.com/items?itemName=octref.vetur) - VS Code plugin that gives syntax highlighting and help for Vue projects

That's a lot of things, but they will be slowly introduced to the project as the class goes on.

## Approach

The class will assume that all students have some experience with JavaScript and adding functionality to their applications through JavaScript. What the class will teach is a different way of looking at JavaScript functionality from the model of DOM elements with event handlers that are all tightly coupled to the underlying DOM and the page they are on to a more flexible component based model where the components don't know about each other and are isolated and encapsulated within themselves.

To accomplish this, we will be looking at what components are in JavaScript, how to think about them in solving our problems, how to test our components using unit and E2E testing, and how to convert an existing application over to using components instead.

This will then end in a capstone project that will involve taking an existing application using basic JavaScript and convert it into multiple Vue Components all working together and fully tested performing the same task as before.