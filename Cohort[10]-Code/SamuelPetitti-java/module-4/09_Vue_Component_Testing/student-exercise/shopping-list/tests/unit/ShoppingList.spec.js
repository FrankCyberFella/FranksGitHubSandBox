import ShoppingList  from '@/components/ShoppingList.vue';
/* eslint-disable-next-line no-unused-vars */
import { shallowMount, Wrapper } from '@vue/test-utils';

import chai from 'chai';
chai.should();

describe('ShoppingList', () => {
    /**@type Wrapper*/
    let wrapper;
    beforeEach(() => {
        wrapper = shallowMount(ShoppingList);
    });

it('should be a Vue instance', () => {
    wrapper.isVueInstance().should.be.true;
    });

it('should show a single item on the UI named TEST', () => {
    const testGroceries = [{
        name: 'TEST'
    }];
    wrapper.setData({groceries: testGroceries});

    wrapper.findAll('div.shopping-list').length.should.equal(1);

    wrapper.find('div.shopping-list li').text().should.equal('TEST');

})    

it('should show 5 items on the UI', () => {
    const testFiveGroceries = [
        {name: 'TEST1'},
        {name: 'TEST2'},
        {name: 'TEST3'},
        {name: 'TEST4'},
        {name: 'TEST5'}
    ];
    
    wrapper.setData({
        groceries: testFiveGroceries
    });

    wrapper.findAll('div.shopping-list li').length.should.equal(5);
})    

it('renders an item where completed is false and it should NOT have the class completed', () => {
    const testCompletedFalse = [
        {name: 'TEST',
        completed: false}
    ];
    wrapper.setData({
        groceries: testCompletedFalse
    });
    wrapper.vm.groceries[0].completed.should.equal(false);

    wrapper.find('div.shopping-list li').classes().should.not.contain('completed');
});

it('clicking a list item should call a method and add the class completed', () => {
    const testCompletedClick = [
        {name: 'TEST',
        completed: false}
    ];

    wrapper.setData({
        groceries: testCompletedClick
    });
    
    wrapper.find('div.shopping-list li').trigger('click');

    wrapper.find('div.shopping-list li').classes().should.contain('completed');
    })

});