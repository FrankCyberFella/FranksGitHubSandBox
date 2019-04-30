import ShoppingList from '@/components/ShoppingList';
import {shallowMount, Wrapper} from '@vue/test-utils';
import chai from 'chai';
chai.should();

describe('ShoppingList', () => {
    /** @type Wrapper */
    let wrapper;
    beforeEach( ()=> {
        wrapper=shallowMount(ShoppingList);

    });
    it('should be a vue instance', () => {
            wrapper.isVueInstance().should.be.true;
    });
    it('should show a shopping list item on the UI', () => {
            const testShoppingList = [{
                
            }]
    });

    it('should be a vue instance', () => {
        wrapper.isVueInstance().should.be.true;
});

it('should be a vue instance', () => {
    wrapper.isVueInstance().should.be.true;
});

it('should be a vue instance', () => {
    wrapper.isVueInstance().should.be.true;
});

it('should be a vue instance', () => {
    wrapper.isVueInstance().should.be.true;
});
});

