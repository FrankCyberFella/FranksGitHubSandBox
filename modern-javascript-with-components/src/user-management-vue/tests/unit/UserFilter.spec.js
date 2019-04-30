import UserFilter from '@/components/UserFilter.vue';
/* eslint-disable-next-line no-unused-vars */
import { shallowMount, Wrapper } from '@vue/test-utils';
// if using fetch in component 
//import fetchMock from 'fetch-mock';

import chai from 'chai';
chai.should();

describe('UserFilter', () => {
  /** @type Wrapper */
  let wrapper;
  beforeEach( () => {
    wrapper = shallowMount(UserFilter);
  });

  it('should be a Vue component', () => {
    wrapper.isVueInstance().should.be.true;
  });

  it('should emit new-filter on input events', () => {
    let filterField = wrapper.find('input#filter');
    filterField.trigger('input', { keyCode: 20 });
    filterField.trigger('input', { keyCode: 20 });
    filterField.trigger('input', { keyCode: 20 });

    wrapper.emitted('new-filter').length.should.equal(3);
  });
});