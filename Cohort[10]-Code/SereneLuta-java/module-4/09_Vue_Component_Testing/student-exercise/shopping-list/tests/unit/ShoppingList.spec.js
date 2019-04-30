import ShoppingList from '@/components/ShoppingList.vue';
/* eslint-disable-next-line no-unused-vars */
import { shallowMount, Wrapper } from '@vue/test-utils';

import chai from 'chai';
chai.should();

describe('ShoppingList', () => {
  /** @type Wrapper */
  let wrapper;
  beforeEach( () => {
    wrapper = shallowMount(ShoppingList);
  });

  it('should be a Vue instance', () => {
    wrapper.isVueInstance().should.be.true;
  });

  it('renders a single shopping list item to the DOM and the name is what we expect it to be', () => {
    const testListItem = [
        {id: 1, name: 'Milk', completed: false }
    ];

    wrapper.setData({ groceries: testListItem });

    // Should only have one list item
    wrapper.findAll('li').length.should.equal(1);

    // List item should show what was set on data
    wrapper.find('li').text().should.equal('Milk');
  });

  it('renders 5 items to the DOM and the number of elements found is 5', () => {
    const testListItems = [
        {id: 1, name: 'Hot Water', completed: false },
        {id: 2, name: 'Tea', completed: false },
        {id: 3, name: 'Seltzer', completed: false },
        {id: 4, name: 'Lemon', completed: false },
        {id: 5, name: 'Echinacea', completed: false }
    ];

    wrapper.setData({ groceries: testListItems });

    // Should have 5 list items
    wrapper.findAll('li').length.should.equal(5);
});


it('renders an item where completed is false and it should NOT have class completed', () => {
    const testListItemFalse = [
        {id: 1, name: 'Hot Water', completed: false }
    ];

    wrapper.setData({ groceries: testListItemFalse});

    wrapper.vm.groceries[0].completed.should.equal(false);
    wrapper.find('li').classes().should.not.contain('completed');
});

it('clicking the list item should call our change status method and add the class completed', () => {
      wrapper.find('#chkbox').trigger('click');
      wrapper.find('li').classes().should.contain('completed');

});

});