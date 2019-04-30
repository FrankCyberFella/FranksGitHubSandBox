import ShoppingList from '@/components/ShoppingList';
/* eslint-disable-next-line no-unused-vars */
import { shallowMount, Wrapper } from '@vue/test-utils';

import chai from 'chai';
chai.should();

describe('ShoppingList', () => {
  /** @type Wrapper */
  let wrapper;
  beforeEach( () => {
    wrapper = shallowMount(ShoppingList);
  });

  it('should be a Vue instance', () => {
    wrapper.isVueInstance().should.be.true;
  });

  it('should show one list item', () => {
    const item = [{
      id: 1,
      name: 'TEST NAME',
      completed: false
    }];

    wrapper.setData({ groceries: item });

    // Should only have one review
    wrapper.findAll('div li').length.should.equal(1);

    wrapper.find('div li').classes('completed').should.equal(false);
    wrapper.find('div li').text().should.equal('TEST NAME');

    });

    it('should show five list items', () => {
        const items = [
            {
            id: 1,
            name: 'TEST NAME1',
            completed: false
        },
        {
            id: 2,
            name: 'TEST NAME2',
            completed: false
          },
          {
            id: 3,
            name: 'TEST NAME3',
            completed: false
          },
          {
            id: 4,
            name: 'TEST NAME4',
            completed: false
          },
          {
            id: 5,
            name: 'TEST NAME5',
            completed: false
          }
    ];

    wrapper.setData({groceries: items});

    wrapper.findAll('div li').length.should.equals(5);

    });

    it('should show completed when li is clicked', () => {
        const item = [{
          id: 1,
          name: 'TEST NAME',
          completed: false
        }];
    
        wrapper.setData({ groceries: item });
    
        wrapper.find('div li').classes('completed').should.equal(false);
        wrapper.find('div li').trigger('click');
        wrapper.find('div li').classes('completed').should.equal(true);
    
        });

});