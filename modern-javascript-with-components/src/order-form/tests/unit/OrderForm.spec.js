import OrderForm from '@/components/OrderForm.vue';
/* eslint-disable-next-line no-unused-vars */
import { shallowMount, Wrapper } from '@vue/test-utils';
import fetchMock from 'fetch-mock';


import chai from 'chai';
let should = chai.should();

describe('OrderForm', () => {
  /** @type Wrapper */
  let wrapper;
  beforeEach( () => {
    wrapper = shallowMount(OrderForm);
  });
    // Start remove

  before( () => {
    fetchMock.config.overwriteRoutes = true;
  });

  it('should be a Vue instance', () => {
    wrapper.isVueInstance().should.equal(true);
  });

  it('should hide fieldset when sameAddress is true', () => {
    wrapper.setData({'sameAddress': true});
    wrapper.find('#billingAddress').exists().should.be.false;
  });

  it('should show fieldset when sameAddress is false', () => {
    wrapper.setData({'sameAddress': false});
    wrapper.find('#billingAddress').exists().should.be.true;
  });

  it('should remove the needs-content css class when firstName has content', () => {
    wrapper.setData({'order': {'firstName': 'TEST'}});
    wrapper.find('#firstName').classes().should.not.contain('needs-content');
  });

  it('should add the needs-content css class when firstName is empty', () => {
    wrapper.setData({'order': {'firstName': ''}});
    wrapper.find('#firstName').classes().should.contain('needs-content');
  });

  it('should disable the submit button when credit card number is blank', () => {
    wrapper.setData({'order': {'creditCardNumber': ''}});
    wrapper.find('button[type=submit]').attributes().should.include.key('disabled');
  });

  it('should enable the submit button when credit card number is entered', () => {
    wrapper.setData({'order': {'creditCardNumber': '41111111111'}});
    wrapper.find('button[type=submit]').attributes().should.not.include.key('disabled');
  });

  it('should make computed property only return elements where canShip is true', () => {
    let testData = [
      {
        name: 'TEST1',
        canShip: true
      },
      {
        name: 'TEST2',
        canShip: false
      }
    ];
    let expectedData = [
      {
        name: 'TEST1',
        canShip: true
      }
    ];
    wrapper.setData({availableStates: testData});
    wrapper.vm.shippingStates.should.deep.equal(expectedData);
  });

  it('should set the success message when API is called successfully', async () => {
    // When a POST is made to 'https://httpbin.org/anything', return a 200 status
    fetchMock.post('https://httpbin.org/anything', { status: 200, body: '{"success":true}'});

    await wrapper.vm.saveOrder();
    wrapper.vm.message.should.equal('Successfully Saved.');

  });

  it('should set the failure message when API fails', (done) => {
    // When a POST is made to 'https://httpbin.org/anything', return a 400 status
    fetchMock.post('https://httpbin.org/anything', 400);

    wrapper.vm.saveOrder().then(() => {
      wrapper.vm.message.should.equal('An Error Occurred');
      done();
    });
    // End remove
  });
});