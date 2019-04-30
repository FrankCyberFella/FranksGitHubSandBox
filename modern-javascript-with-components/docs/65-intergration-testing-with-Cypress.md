# Integration Testing with Cypress (45 Minutes)

Now that we have an application with multiple components, fully unit tested, how can we test them all together.

We when set up these projects, we selected an integration testing framework called Cypress. This is already fully set up in our project, so now we just need to write the tests.

> #### Note::This is an introduction to Cypress
>
> This is just an introduction into Cypress and not an example of full E2E testing of the application. If the students are interested in this, you could go deeper into how to test different aspects of the application and looking at Cypress's ability to take screenshots and videos of the tests as they run.

## Cypress

Cypress tests are structured a lot like our unit tests, so the syntax will look very similar, but not exactly the same. If we open the tests/e2e/specs/tests.js file, we'll see a template there of our e2e tests. Let's change this to match our new application.

The `cy` object is our connection to Cypress and to the testing browser that is controlled by Cypress. The first thing we do in every test is to tell Cypress where to go in our application. We only have the one page, so we can keep the `cy.visit('/')`. On that page, there should be a `New User` button, so let's look for that and make sure it exists. If this test fails, that means our application isn't running at all.

``` JavaScript
describe('User Manager', () => {
  it('Visits the app root url', () => {
    cy.visit('/');
    cy.contains('button', 'New User');
  });
});
```

Then we can run `npm run test:e2e`. This opens the Cypress test runner. We can run all tests in a self contained browser by selecting Electron in the right top corner. Then just click on your test file. Success!

Let's now test to make sure we can add a new user. Remember, we tested the New User button already in the unit test. Here, we're testing the integration between components.

``` JavaScript
  it('should add a new user when form is submitted', () => {
    cy.visit('/');
    cy.get('button#new-user-button').click();
    cy.get('input#firstName').type('TEST');
    cy.get('input#lastName').type('LTEST');
    cy.get('input#title').type('SENIOR TESTER');
    cy.get('input#email').type('TEST@TEST.TEST');
    cy.get('input#enabled').click();

    cy.get('button[type=submit]').click();

    cy.get('table tbody tr').children().should('have.length', 5);
    cy.get('table tbody tr').children().eq(1).contains('TEST LTEST');
    cy.get('table tbody tr').children().eq(2).contains('SENIOR TESTER');
    cy.get('table tbody tr').children().eq(3).contains('TEST@TEST.TEST');
    cy.get('table tbody tr').children().eq(4).contains('Yes');
  });
```

We're no longer calling methods and injecting data and props, we are now testing at the UI level and therefore have to select the elements on the page and interact with them there. They Cypress documentation has a lot of examples around how to code these kinds of tests.