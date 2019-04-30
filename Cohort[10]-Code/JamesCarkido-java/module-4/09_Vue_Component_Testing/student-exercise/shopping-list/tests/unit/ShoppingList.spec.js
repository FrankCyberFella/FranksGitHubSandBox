import ShoppingList from '@/components/ShoppingList.vue';
/* eslint-disable-next-line no-unused-vars */
import { shallowMount, Wrapper } from '@vue/test-utils';

import chai from 'chai';
chai.should();

describe('ShoppingList', () => {

    const testList = [
    
        { id: 1, name: 'TEST 1', completed: false },
        { id: 2, name: 'TEST 1', completed: false },
        { id: 3, name: 'TEST 1', completed: true },
        { id: 4, name: 'TEST 1', completed: false },
        { id: 5, name: 'TEST 1', completed: true }
    ];

    /** @type Wrapper */
    let wrapper;
    beforeEach( () => {
        wrapper = shallowMount(ShoppingList);
    });

    it ('Should be a Vue Instance', () => {
        wrapper.isVueInstance().should.be.true;
    });

    it('Renders a single shopping list item to the DOM and the name is what we expect it to be', () => {
        wrapper.find('.shopping-list h1').text().should.equal('My Shopping List');
    });

    it('Renders 5 items to the DOM and number of li elements is 5',() => {
        wrapper.setData({ groceries: testList });
        wrapper.findAll('.shopping-list ul li').length.should.equal(5);
    });

    it('Renders item where completed is false and should not have the class completed', () => {
        const testItem = [{ id: 1, name: 'TEST 1', completed: false}];
        wrapper.setData({ groceries: testItem});
        wrapper.find('.shopping-list ul li').classes().should.not.contain('completed');

    });

    it('when the user clicks an item it should call changeStatus and add class completed', () => {
        const testItem=[{ id:1, name: 'TEST 1', completed: false}];
        wrapper.setData({groceries: testItem});
        wrapper.find('.shopping-list ul li').trigger('click');
        wrapper.find('.shopping-list ul li').classes().should.contain('completed');
    });
});