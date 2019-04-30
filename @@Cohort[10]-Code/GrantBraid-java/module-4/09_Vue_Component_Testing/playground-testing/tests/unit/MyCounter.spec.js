/* eslint-disable-next-line no-unused-vars */
import { shallowMount, Wrapper } from '@vue/test-utils';
import MyCounter from '@/components/MyCounter';

import chai from 'chai';
chai.should(); // .should is the assertion style picked

describe('My Counter component tests', () => {
    /** @type Wrapper */
    let wrapper;

    beforeEach(() => {
        wrapper = shallowMount(MyCounter);
    });

    it('when the component first loads the count should be 0', () => {
        wrapper.find('.count p').text().should.equal('Your current count: 0');
    });

    it('When the user clicks the increment button the count should increase by 1', () => {
        wrapper.find('#inc').trigger('click');
        wrapper.vm.count.should.equal(1);
        wrapper.find('.count p').text().should.equal('Your current count: 1');
    });
});