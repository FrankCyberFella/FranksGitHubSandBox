import userStore from '@/stores/user';

import chai from 'chai';
chai.should();

describe('UserStore', () => {
  beforeEach( () => {
    userStore.commit('clear');
  });

  describe('state', () => {
    it('should save filter when filter is set', () => {
      userStore.commit('changeFilter', 'TEST');
      userStore.state.filterText.should.equal('TEST');
    });

    it('should add user to array when added', () => {
      let testUser = {
        firstName: 'FTEST',
        lastName: 'LTEST'
      };
      userStore.commit('addUser', testUser);
      userStore.state.allUsers.length.should.equal(1);
      userStore.state.allUsers[0].should.deep.equal(testUser);
    });
  });

  describe('getters', () => {
    let passedUser, blockedUser;
    beforeEach( () => {
      passedUser = {
        firstName: 'FTEST',
        lastName: 'LTEST'
      };

      blockedUser = {
        firstName: 'FWORST',
        lastName: 'LWORST'
      };

      userStore.commit('addUser', passedUser);
      userStore.commit('addUser', blockedUser);
      userStore.commit('changeFilter', 'TEST');
    });

    it('should show only users matching functions when filter set', () => {
      userStore.getters.users.should.deep.contain(passedUser);
    });

    it('should not contain non matching user', () => {
      userStore.getters.users.should.not.deep.contain(blockedUser);
    });
  });
});