/* eslint-disable-next-line no-unused-vars */
import{ shallowMount, Wrapper} from  '@vue/test-utils';
import MyCounter from '@/components/MyCounter';

import chai from 'chai'
chai.should();

describe('MyCounter component tests', ()=> {
/* @type Wrapper */
    let wrapper;
    beforeEach( () => {
        wrapper = shallowMount(MyCounter);
    });
    
    it('when the component first runs the counter should show 0', () => {
        wrapper.find('.counter p').text().should.equal('current count is: 0');
    });
});