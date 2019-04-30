import ShoppingList from '@/components/ShoppingList.vue';
import {shallowMount, Wrapper} from '@vue/test-utils';

import chai from 'chai';
chai.should();

describe('ShoppingList', () => {
    /**@type Wrapper */
    let wrapper;

    beforeEach(() => {
        wrapper = shallowMount(ShoppingList);
    });

    it('should be a Vue instance', () => {
        wrapper.isVueInstance().should.be.true;
    });

    it('renders a single shopping list item to the DOM and the name is what we expect it to be', () => {
        const testGroceries = [{
            id: 1, 
            name: 'TEST', 
            completed: false
        }];

        wrapper.setData({groceries: testGroceries});

        wrapper.find('.shopping-list ul li').text().should.equal('TEST');
    });

    it('renders 5 items to the DOM and the number of li elements found is 5', () => {
        const testGroceries = [{
                id: 1, 
                name: 'TEST', 
                completed: false
            },
            {
                id: 2, 
                name: 'TEST', 
                completed: false
            },
            {
                id: 3, 
                name: 'TEST', 
                completed: false
            },
            {
                id: 4, 
                name: 'TEST', 
                completed: false
            },
            {
                id: 5, 
                name: 'TEST', 
                completed: false
            },
        ];

        wrapper.setData({groceries: testGroceries});

        wrapper.findAll('.shopping-list ul li').length.should.equal(5);
    });

    it('renders an item where completed is false and it should NOT have the class completed', () => {
        const testGroceries = [{
            id: 1, 
            name: 'TEST', 
            completed: false
        }];

        wrapper.setData({groceries: testGroceries});

        wrapper.find('.shopping-list ul li').classes().should.not.contain('completed');
    });

    it('clicking the list item should call our change status method and add the class completed', () => {
        const testGroceries = [{
            id: 1, 
            name: 'TEST', 
            completed: false
        }];

        wrapper.setData({groceries: testGroceries});

        wrapper.find('.shopping-list ul li').trigger('click');
        wrapper.find('.shopping-list ul li').classes().should.contain('completed');
    });
});