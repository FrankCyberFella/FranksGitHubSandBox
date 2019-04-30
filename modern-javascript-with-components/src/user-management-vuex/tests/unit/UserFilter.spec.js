import UserFilter from '@/components/UserFilter.vue';
/* eslint-disable-next-line no-unused-vars */
import { shallowMount, Wrapper } from '@vue/test-utils';
// if using fetch in component 
//import fetchMock from 'fetch-mock';
import userStore from '@/stores/user';

import chai from 'chai';
chai.should();

describe('UserFilter', () => {
  /** @type Wrapper */
  let wrapper;
  beforeEach( () => {
    wrapper = shallowMount(UserFilter);
  });

  afterEach( () => {
    userStore.commit('clear');
  });

  it('should be a Vue component', () => {
    wrapper.isVueInstance().should.be.true;
  });

  it('should update user store on input events', () => {
    let filterField = wrapper.find('input#filter');
    filterField.setValue('input');

    userStore.state.filterText.should.equal('input');
  });
});