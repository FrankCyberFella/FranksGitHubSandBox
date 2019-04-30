// https://docs.cypress.io/api/introduction/api.html

describe('User Manager', () => {
  it('Visits the app root url', () => {
    cy.visit('/');
    cy.contains('button', 'New User');
  });

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

  it('should have two rows when two users entered', () => {
    cy.visit('/');
    cy.get('button#new-user-button').click();
    cy.get('input#firstName').type('TEST');
    cy.get('input#lastName').type('LTEST');
    cy.get('input#title').type('SENIOR TESTER');
    cy.get('input#email').type('TEST@TEST.TEST');
    cy.get('input#enabled').click();

    cy.get('button[type=submit]').click();
    
    cy.get('button#new-user-button').click();
    cy.get('input#firstName').type('TEST2');
    cy.get('input#lastName').type('LTEST2');
    cy.get('input#title').type('SENIOR TESTER2');
    cy.get('input#email').type('TEST@TEST.TEST2');

    cy.get('button[type=submit]').click();

    cy.get('table tbody tr').should('have.length', 2);
  });

  it('should have one row when two users entered and filter matches only one', () => {
    cy.visit('/');
    cy.get('button#new-user-button').click();
    cy.get('input#firstName').type('TEST');
    cy.get('input#lastName').type('LTEST');
    cy.get('input#title').type('SENIOR TESTER');
    cy.get('input#email').type('TEST@TEST.TEST');
    cy.get('input#enabled').click();

    cy.get('button[type=submit]').click();
    
    cy.get('button#new-user-button').click();
    cy.get('input#firstName').type('TEST2');
    cy.get('input#lastName').type('LTEST2');
    cy.get('input#title').type('SENIOR TESTER2');
    cy.get('input#email').type('TEST@TEST.TEST2');

    cy.get('button[type=submit]').click();

    cy.get('input#filter').type('TEST2');

    cy.get('table tbody tr').should('have.length', 1);
  });
});
