import MailingList from '@/components/MailingList.vue';
/* eslint-disable-next-line no-unused-vars */
import { shallowMount, Wrapper } from '@vue/test-utils';
// if using fetch in component 
//import fetchMock from 'fetch-mock';

import chai from 'chai';
chai.should();

describe('MailingList', () => {
  /** @type Wrapper */
  let wrapper;
  beforeEach( () => {
    wrapper = shallowMount(MailingList);
  });

  describe('data fields', () => {
    it('should map input fields to data properties', () => {
      wrapper.find('#name').setValue('NAME_TEST');
      wrapper.find('#email').setValue('EMAIL_TEST');
      wrapper.find('#agree').setChecked(true);

      wrapper.vm.name.should.equal('NAME_TEST');
      wrapper.vm.email.should.equal('EMAIL_TEST');
      wrapper.vm.agree.should.be.true;
    });

    it('should show data in table below form', () => {
      wrapper.setData({
        name: 'NAME_TEST',
        email: 'EMAIL_TEST',
        agree: true
      });

      let cells = wrapper.findAll('table tbody td');
      cells.at(0).text().should.equal('NAME_TEST');
      cells.at(1).text().should.equal('EMAIL_TEST');
      cells.at(2).text().should.equal('Yes');
    });
  });

  describe('display bindings', () => {
    it('should highlight name and email when values are empty', () => {
      wrapper.setData({
        name: '',
        email: ''
      });

      wrapper.find('#name').classes().includes('alert').should.be.true;
      wrapper.find('#email').classes().includes('alert').should.be.true;
    });

    it('should show Yes in table when agree is true', () => {
      wrapper.setData({
        agree: true
      });

      wrapper.find('table tbody td:last-child').text().should.equal('Yes');
    });

    it('should show No in table when agree is false', () => {
      wrapper.setData({
        agree: false
      });

      wrapper.find('table tbody td:last-child').text().should.equal('No');
    });

    it('should have the submit button disabled if not all fields are filled in', () => {
      wrapper.setData({
        name: 'TEST'
      });

      wrapper.find('button[type=submit]').attributes().should.contain.key('disabled');

      wrapper.setData({
        email: 'TEST'
      });

      wrapper.find('button[type=submit]').attributes().should.contain.key('disabled');

      wrapper.setData({
        agree: true
      });

      wrapper.find('button[type=submit]').attributes().should.not.contain.key('disabled');
    });
  });
});