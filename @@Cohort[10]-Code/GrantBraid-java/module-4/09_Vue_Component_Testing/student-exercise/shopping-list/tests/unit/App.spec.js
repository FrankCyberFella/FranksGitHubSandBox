import ShoppingList from '@/components/ShoppingList.vue';

import { shallowMount, Wrapper } from '@vue/test-utils';

import chai from 'chai';
chai.should();

describe('ShoppingList', () => {
    /** @type Wrapper */
    let wrapper;

    const testList = [{
        id: 1,
         name: 'Oatmeal',
          completed: false
    },
    {
    id:2,
    name: 'Goatmeal',
    completed: true
    },
    {
    id:3,
    name: 'Yuck Puddle',
    completed: true
    },
    {
    id:4,
    name: 'Pretzels',
    completed: true
    },
    {
    id:5,
    name: 'Toaster',
    completed: true
    }];

    beforeEach( () => {
        wrapper = shallowMount(ShoppingList);
    });

    it('should be a vue instance', () => {
        wrapper.isVueInstance().should.be.true;
    });

    it('renders a single shopping list item to the DOM and the name is what we expect it to be', () => {
       
        wrapper.setData({groceries: testList});
        wrapper.vm.groceries[0].name.should.equal('Oatmeal');
        wrapper.vm.groceries[1].name.should.equal('Goatmeal');
        wrapper.vm.groceries[4].name.should.equal('Toaster');
    });
    it('renders 5 items to the DOM and has 5 li', () => {
        wrapper.setData({groceries: testList});
        wrapper.vm.groceries.length.should.equal(5);
    });
    it('renders an item where completed is false and it should NOT have the class completed', () => {
        wrapper.setData({groceries: testList});
        wrapper.vm.groceries[0].completed.should.equal(false);
        wrapper.find('li').classes().should.not.contain('completed');
    });
    it('licking the list item should call our change status method and add the class completed', () => {
        wrapper.setData({groceries: testList});
        wrapper.find('li').trigger('click');
        wrapper.find('li').classes().should.contain('completed');
    });
});