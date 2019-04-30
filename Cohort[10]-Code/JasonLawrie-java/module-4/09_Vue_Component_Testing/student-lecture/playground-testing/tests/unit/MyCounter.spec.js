/* eslint-disable-next-line no-unused-vars */
import { shallowMount, Wrapper} from '@vue/test-utils';
import MyCounter from '@/components/MyCounter.vue';

import chai from 'chai';
chai.should();

describe('MyCounter component tests',()=>{
    
    /**@type Wrapper */
    let wrapper;
    
    beforeEach(()=>{
        wrapper=shallowMount(MyCounter);
    });

    it('when the component first loads the count should be 0',()=>{
        wrapper.find('.counter p').text().should.equal('Current count is: 0');

    });
    it('when the increment button is clicked the count should be 1',()=>{
        wrapper.find('#counter').trigger('click');
        wrapper.vm.count.should.equal(1);
        wrapper.find('.counter p').text().should.equal('Current count is: 1');
    })
})