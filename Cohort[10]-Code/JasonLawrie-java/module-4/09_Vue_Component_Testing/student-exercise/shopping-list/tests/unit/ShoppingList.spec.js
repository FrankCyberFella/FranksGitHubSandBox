
import ShoppingList from '@/components/ShoppingList.vue';
/* eslint-disable-next-line no-unused-vars */
import {shallowMount,Wrapper} from '@vue/test-utils';

import chai from 'chai';
chai.should();

describe('ShoppingList.vue',()=>{
    /**@type Wrapper */
    let wrapper;

    beforeEach(()=>{
        wrapper=shallowMount(ShoppingList);
    });
    it('the wrapper should be a vue component',()=>{
        wrapper.isVueInstance().should.be.true;
    })
    it('should print the name of a shopping list item',()=>{
        wrapper.vm.groceries=[{name:'TEST1'}];
        wrapper.find('.shopping-list ul li').text().should.equal('TEST1');
    })
    it('should have list items for each grocery item',()=>{
        wrapper.vm.groceries=[
            {name:'TEST1'},
            {name:'TEST2'},
            {name:'TEST3'},
            {name:'TEST4'},
            {name:'TEST5'}
        ];
        wrapper.findAll('.shopping-list ul li').length.should.equal(5);
    })
    it('should not have completed class if completed is false',()=>{
        wrapper.vm.groceries=[{name:'TEST1',completed:false}];
        wrapper.find('.shopping-list ul li').classes('completed').should.be.false;
    })
    it('should have completed class if completed is true',()=>{
        wrapper.find('.shopping-list ul li').trigger('click');
        wrapper.find('.shopping-list ul li').classes('completed').should.be.true;
    })
})