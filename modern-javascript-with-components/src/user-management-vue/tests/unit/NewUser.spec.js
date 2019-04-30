import NewUser from '@/components/NewUser.vue';
/* eslint-disable-next-line no-unused-vars */
import { shallowMount, Wrapper } from '@vue/test-utils';
// if using fetch in component 
//import fetchMock from 'fetch-mock';

import chai from 'chai';
chai.should();

describe('NewUser', () => {
  /** @type Wrapper */
  let wrapper;
  beforeEach( () => {
    wrapper = shallowMount(NewUser);
  });

  it('should be a Vue component', () => {
    wrapper.isVueInstance().should.be.true;
  });

  it('should not show form at first', () => {
    wrapper.find('#edit-screen').exists().should.be.false;
  });

  it('should show form when button is clicked', () => {
    wrapper.find('button#new-user-button').trigger('click');

    wrapper.find('#edit-screen').exists().should.be.true;
  });

  it('should save user information in data when entered into form', () => {
    // Need to click that button first or none of these are here
    wrapper.find('button#new-user-button').trigger('click');

    wrapper.find('input#firstName').setValue('TEST');
    wrapper.find('input#lastName').setValue('LTEST');
    wrapper.find('input#title').setValue('SENIOR TESTER');
    wrapper.find('input#email').setValue('TEST@TEST.TEST');
    wrapper.find('input#enabled').setChecked(true);

    wrapper.vm.user.should.deep.include({
      firstName: 'TEST',
      lastName: 'LTEST',
      title: 'SENIOR TESTER',
      email: 'TEST@TEST.TEST',
      enabled: true
    });
  });

  it('should send new-user event with user information', () => {
    let userData = {
      firstName: 'TEST',
      lastName: 'LTEST',
      title: 'SENIOR TESTER',
      email: 'TEST@TEST.TEST',
      enabled: true
    };
    wrapper.setData({
      user: userData
    });

    wrapper.vm.performSubmit();
    wrapper.emitted('new-user')[0][0].should.deep.include(userData);
  });

  it('should set a random id on user when user information is submitted', () => {
    let userData = {
      firstName: 'TEST',
      lastName: 'LTEST',
      title: 'SENIOR TESTER',
      email: 'TEST@TEST.TEST',
      enabled: true
    };
    wrapper.setData({
      user: userData
    });

    wrapper.vm.performSubmit();
    let generatedId = wrapper.emitted('new-user')[0][0].id;
    generatedId.should.be.a('Number');
    generatedId.should.not.equal(0);
  });

  it('should blank out the user information when the cancel button is pressed', () => {
    wrapper.find('button#new-user-button').trigger('click');

    wrapper.find('input#firstName').setValue('TEST');
    wrapper.find('input#lastName').setValue('LTEST');
    wrapper.find('input#title').setValue('SENIOR TESTER');
    wrapper.find('input#email').setValue('TEST@TEST.TEST');
    wrapper.find('input#enabled').setChecked(true);

    wrapper.find('button#cancel-save').trigger('click');

    wrapper.vm.user.firstName.should.equal('');
    wrapper.vm.user.lastName.should.equal('');
    wrapper.vm.user.title.should.equal('');
    wrapper.vm.user.email.should.equal('');
    wrapper.vm.user.enabled.should.equal(false);
    wrapper.vm.user.id.should.equal(0);
  });
});