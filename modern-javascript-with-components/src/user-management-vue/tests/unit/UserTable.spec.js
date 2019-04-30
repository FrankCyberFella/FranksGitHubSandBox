import UserTable from '@/components/UserTable.vue';
/* eslint-disable-next-line no-unused-vars */
import { shallowMount, Wrapper } from '@vue/test-utils';
// if using fetch in component 
//import fetchMock from 'fetch-mock';

import chai from 'chai';
chai.should();

describe('UserTable', () => {
  /** @type Wrapper */
  let wrapper;
  beforeEach( () => {
    wrapper = shallowMount(UserTable);
  });

  it('should be a Vue component', () => {
    wrapper.isVueInstance().should.be.true;
  });

  it('should show users when users prop is set', () => {
    wrapper.setProps({
      users: [
        {
          id: 1,
          firstName: 'TEST',
          lastName: 'LTEST',
          title: 'SENIOR TESTER',
          email: 'TEST@TEST.TEST',
          enabled: true
        }
      ]
    });

    let cells = wrapper.findAll('table tbody tr td');
    cells.at(0).text().should.equal('1');
    cells.at(1).text().should.equal('TEST LTEST');
    cells.at(2).text().should.equal('SENIOR TESTER');
    cells.at(3).text().should.equal('TEST@TEST.TEST');
    cells.at(4).text().should.equal('Yes');
  });
});