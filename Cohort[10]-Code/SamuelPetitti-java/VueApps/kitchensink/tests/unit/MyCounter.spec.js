/*eslint-disable-next-line no-unused-vars */
import { shallowMount, Wrapper } from '@vue/test-utils';
import MyCounter from '@/components/MyCounter';

import chai from 'chai'
chai.should();

describe('MyCounter component tests', () => {
     /** @type Wrapper */ 
    let wrapper;
    beforeEach(() => {
        wrapper = shallowMount(MyCounter);
    });
    it('when the component first loads the count should be 0',() => {
        wrapper.find('.counter p').text().should.equal('current count is: 0'); //wrapper.find = vue test utils
                                                                               //should.equal = chai
    });

    it('when the user clicks the increment button the count should increase by 1', () => {
        wrapper.find('#counter').trigger('click');
        wrapper.find('.counter p').text().should.equal('current count is: 1');
    });
});











