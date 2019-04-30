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

    it('should be a single shopping list item', () => {
        const testGrocery  = [{
            name: 'TESTNAME',
        }];

        wrapper.setData({groceries: testGrocery});
        wrapper.find('div.shopping-list li').text().should.equal('TESTNAME')
    })

    it('should render 5 list items', () => {
        const testGrocery = [
            {name: 'one'},
            {name: 'two'},
            {name: 'three'},
            {name: 'four'},
            {name: 'five'}
        ]
    

    wrapper.setData({groceries: testGrocery});
    wrapper.findAll('div.shopping-list li').length.should.equal(5);
    })

    it('should not have item marked "completed = false" with the class completed', () => {
        const testGrocery = [
            {name: 'TEST',
             completed: false
            }
        ]
    wrapper.setData({groceries: testGrocery});
    wrapper.find('div.shopping-list li').classes().should.not.contain('completed');
    })

    it('should call method and change class', () => {
    

        wrapper.find('li').trigger('click');
        wrapper.find('li').classes().should.contain('completed');


    })
})

