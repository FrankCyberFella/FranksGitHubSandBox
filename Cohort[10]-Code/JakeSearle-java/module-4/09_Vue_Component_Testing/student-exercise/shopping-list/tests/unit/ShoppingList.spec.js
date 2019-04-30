import { shallowMount, Wrapper } from '@vue/test-utils';
/* eslint-disable-next-line no-unused-vars */
import ShoppingList from '@/components/ShoppingList.vue';

import chai from 'chai'
chai.should();

describe('ShoppingList component tests', () => {
    /** @type Wrapper */
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
    
        wrapper.setData({ groceries : testGroceries });
    
        wrapper.findAll('div.shopping-list').length.should.equal(1);

        wrapper.find('div.shopping-list li').text().should.equal('TEST');
    });

    it('should show a five items on the UI and the number of li should be five', () => {
        const testGroceryFive = [
          {name: 'TEST'},
          {name: 'TEST2'},
          {name: 'TEST3'},
          {name: 'TEST4'},
          {name: 'TEST5'}
        ];
    
        wrapper.setData({ groceries : testGroceryFive });
    
        wrapper.findAll('div.shopping-list ul li').length.should.equal(5);
    });

    it('renders an item where completed is false and it should NOT have the class completed', () => {
        const testGroceries = [
          {name: 'TEST', 
          completed: false}
        ];

        wrapper.setData({ groceries : testGroceries});
        wrapper.vm.groceries[0].completed.should.equal(false);
        wrapper.find('div.shopping-list li').classes().should.not.contain('completed');
    });

    it('clicking the item should call out changeStatus method and add the class completed ', () => {

        wrapper.find('div.shopping-list li').trigger('click');
        wrapper.find('div.shopping-list li').classes().should.contain('completed');
    });
});