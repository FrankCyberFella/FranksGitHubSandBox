import ShoppingList from '@/components/ShoppingList.vue';
/* eslint-disable-next-line no-unused-vars */
import { shallowMount, Wrapper} from '@vue/test-utils';

import chai from 'chai';
chai.should();

describe('ShoppingList', () => {
    /** @type Wrapper */
    let wrapper; 
    beforeEach(  () => {
        wrapper = shallowMount(ShoppingList);
    });

    it('Shopping List is a vue instance',() => {
        wrapper.isVueInstance().should.equal(true);
    })

    it('renders...',() => {
        
    })
});