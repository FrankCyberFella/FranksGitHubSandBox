import ShoppingList from '@/components/ShoppingList';
/*eslint-disable-next-line no-unused-vars */
import {shallowMount, Wrapper} from '@vue/test-utils';

import chai from 'chai'
chai.should();

describe('ShoppingList', () => {
    /** @type Wrapper */
    let wrapper;
    beforeEach(() => {
        wrapper = shallowMount(ShoppingList);
    });

    it('should be a Vue instance', () => {
        wrapper.isVueInstance().should.be.true;
    });

    it('should show a shopping list item on the UI', () => {
        const testItem =[{
            id: 1,
            name: 'Apple',
            completed: false,
        }];
        wrapper.setData({ groceries: testItem});
        wrapper.findAll('li').length.should.equal(1);
        wrapper.find('div.review h4').text().should.equal('TEST NAME');
        wrapper.find('div.review h3').text().should.equal('TEST TITLE');
        wrapper.find('div.review p').text().should.equal('TEST REVIEW');
        wrapper.find('div.review div.rating').element.children.length.should.equal(3);
      
    });
});