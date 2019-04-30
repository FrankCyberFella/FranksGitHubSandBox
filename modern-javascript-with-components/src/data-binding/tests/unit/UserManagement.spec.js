// Start remove
import UserManagement from '@/components/UserManagement.vue';
/* eslint-disable-next-line no-unused-vars */
import { shallowMount, Wrapper } from '@vue/test-utils';

import chai from 'chai';
chai.should();

describe('UserManagement', () => {
  /** @type Wrapper */
  let wrapper;
  beforeEach( () => {
    wrapper = shallowMount(UserManagement);
  });

  it('should be a Vue instance', () => {
    wrapper.isVueInstance().should.equal(true);
  });

  describe('Data Binding', () => {
      // Data binding unit tests go here
    it('should set the firstName data attribute when text is entered into the firstName field', () => {
      wrapper.find('input[name=firstName]').setValue('TEST');
      wrapper.vm.firstName.should.equal('TEST');
    });

    it('should set the lastName data attribute when text is entered into the lastName field', () => {
      wrapper.find('input[name=lastName]').setValue('TEST');
      wrapper.vm.lastName.should.equal('TEST');
    });

    it('should set the notes data attribute when text is entered into the notes field', () => {
      wrapper.find('textarea[name=notes]').setValue('TEST');
      wrapper.vm.notes.should.equal('TEST');
    });

    it('should set the role data attribute when the select box changes', () => {
      wrapper.find('select[name=role]').setValue('admin');
      wrapper.vm.role.should.equal('admin');

      wrapper.find('select[name=role]').setValue('staff');
      wrapper.vm.role.should.equal('staff');

      wrapper.find('select[name=role]').setValue('volunteer');
      wrapper.vm.role.should.equal('volunteer');
    });

    it('should set the gender data attribute when the radio button is checked', () => {
      wrapper.find('input[name=gender][value=m]').setChecked(true);
      wrapper.vm.gender.should.equal('m');

      wrapper.find('input[name=gender][value=f]').setChecked(true);
      wrapper.vm.gender.should.equal('f');

      wrapper.find('input[name=gender][value=o]').setChecked(true);
      wrapper.vm.gender.should.equal('o');
    });

    it('should default the disabled data attribute to false', () => {
      wrapper.vm.disabled.should.equal(false);
    });

    it('should set the disabled data attribute when disabled is checked', () => {
      wrapper.find('input[name=disabled]').setChecked(true);
      wrapper.vm.disabled.should.equal(true);
    });

    it('should default permissions data attribute to empty array', () => {
      wrapper.vm.permissions.should.deep.equal([]);
    });

    it('should set permissions data attribute to array of checked permissions', () => {
      wrapper.find('input[name=permissions][value=w]').setChecked(true);
      wrapper.vm.permissions.should.deep.equal(['w']);
    });

    it('should set permissions data attribute to all checked permissions', () => {
      wrapper.find('input[name=permissions][value=x]').setChecked(true);
      wrapper.find('input[name=permissions][value=d]').setChecked(true);
      wrapper.vm.permissions.should.deep.equal(['x', 'd']);
    });
  });

  describe('Show User Information', () => {
    // Data display unit tests go here
    it('should set the UI for firstName when the data attribute is set', () => {
      wrapper.setData({'firstName': 'TEST'});
      wrapper.findAll('table tbody tr td').at(0).text().should.equal('TEST');
    });

    it('should set the UI for lastName when the data attribute is set', () => {
      wrapper.setData({'lastName': 'TEST'});
      wrapper.findAll('table tbody tr td').at(1).text().should.equal('TEST');
    });

    it('should set the UI for gender when the data attribute is set', () => {
      wrapper.setData({'gender': 'o'});
      wrapper.findAll('table tbody tr td').at(2).text().should.equal('o');
    });

    it('should set the UI for role when the data attribute is set', () => {
      wrapper.setData({'role': 'admin'});
      wrapper.findAll('table tbody tr td').at(3).text().should.equal('admin');
    });

    it('should set the UI for disabled when the data attribute is set', () => {
      wrapper.setData({'disabled': true});
      wrapper.findAll('table tbody tr td').at(4).text().should.equal('true');
    });

    it('should set the UI for permissions when the data attribute is set', () => {
      wrapper.setData({'permissions': ['w', 'd']});
      wrapper.findAll('table tbody tr td').at(5).text().should.include("w").and.include("d");
    });

    it('should set the UI for notes when the data attribute is set', () => {
      wrapper.setData({'notes': 'TEST'});
      wrapper.findAll('table tbody tr td').at(6).text().should.equal('TEST');
    });
  });
});
// End remove