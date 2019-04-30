/* eslint-disable-next-line no-unused-vars */
import { shallowMount,Wrapper } from '@vue/test-utils';
import MyCounter from '@/components/MyCounter';

import chai from 'chai'
chai.should();

describe('MyCounter component tests', () => {
    /** @type Wrapper  */
    let wrapper;

    beforeEach(() => {
        wrapper = shallowMount(MyCounter); //shallowMount says to just test this component, not its children
    })
it('test 1', () => {
    wrapper.find('#counter p').text().should.equal('Current Count is: 0');
    });

it('test 2', () => {
    wrapper.find('#increment').trigger('click');
    wrapper.vm.count.should.equal(1);
    wrapper.find('#counter p').text().should.equal('Current Count is: 1');

    });
});