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

    it('should return appropriate name', () => {
      const testGroceries = [{
        name: 'TEST NAME'
      }];
      wrapper.setData({ groceries : testGroceries });
      wrapper.find('div.shopping-list li').text().should.equal('TEST NAME');
    });

    it('should return appropriate name', () => {
      const testGroceries = [
        {name: 'TEST 1'},
        {name: 'TEST 2'},
        {name: 'TEST 3'},
        {name: 'TEST 4'},
        {name: 'TEST 5'}
      ];
      wrapper.setData({ groceries : testGroceries });
      wrapper.findAll('div.shopping-list ul li').length.should.equal(5);
    });

    it('should render as false and class is not completed', () => {
      const testGroceries = [
        {name: 'TEST',
        completed: false}
      ];
      wrapper.setData({groceries : testGroceries});
      wrapper.vm.groceries[0].completed.should.equal(false);
      wrapper.find('li').classes().should.not.contain('completed');
    });

    it('should become completed once clicked', () => {
      wrapper.find('li').trigger('click');
      wrapper.find('li').classes().should.contain('completed');
    });
    
});
