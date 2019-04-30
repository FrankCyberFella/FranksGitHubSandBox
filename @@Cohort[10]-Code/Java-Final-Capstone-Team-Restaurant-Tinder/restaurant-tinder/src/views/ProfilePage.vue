<template>
    <div id="profile-page">
        <logout/>
        <div>
        <h1>What are you in the mood for?</h1>
        </div>
        <div id="form-wrapper">
            
            <form class='form-profile' @submit.prevent="update">
                <div class="alert alert-danger" role="alert" v-if="this.$route.query.invalidCity">
                    Options are currently unavailable for this city. Please enter another city and state.
                </div>
                
                <label for= "city">City</label>
                <input type='text' class="form-control" id="city" placeholder="Cleveland" v-model="updateStatement.city" required autofocus/>

                <label for= "state">State</label>
                <input type='text' class="form-control" id="state" placeholder="Ohio" v-model="updateStatement.state" required autofocus/>

                <label for="Cuisine">Cuisine</label>
                <select class="custom-select" v-model="updateStatement.current_preference">
                    <option value="168">Burger</option>
                    <option value="158">Carribbean</option>
                    <option value="25">Chinese</option>
                    <option value="38">European</option>
                    <option value="134">German</option>
                    <option value="148">Indian</option>
                    <option value="55">Italian</option>
                    <option value="60">Japanese</option>
                    <option value="70">Mediterranean</option>
                    <option value="73">Mexican</option>
                    <option value="89">Spanish</option>
                    <option value="95">Thai</option>
                    <option value="308">Vegetarian</option>
                    <option value="0">Restaurant Roulette?!</option>
                </select>

                <button class="btn btn-primary" id="profile-button" type='submit'>Go!</button>
            </form>
        </div>

        <navbar></navbar>
    </div>
</template>

<script>
import Logout from '@/components/logout/Logout.vue'
import Navbar from '@/components/nav/NavBar.vue'
import auth from '@/shared/auth.js'

export default {
    name: 'profile',
    components: {
        Navbar,
        Logout
    },

    data() {
        return {

            updateStatement: {
                city: '',
                state: '',
                current_preference: '',
            },
        }
    },

    methods: {
        update() {
            
            fetch(`${process.env.VUE_APP_REMOTE_API}/profile`, {
            method: 'POST',
            headers: {
                Authorization: 'Bearer ' + auth.getToken(),
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(this.updateStatement),
            credentials: 'same-origin'

        })

        .then(() => {
            this.$router.push({ path: '/', method: "Get"});
        })

        },
        
        }
    ,

    created() {
        fetch(`${process.env.VUE_APP_REMOTE_API}/profile`, {
            method: 'GET',
            headers: {
                Authorization: 'Bearer ' + auth.getToken(),
            },

            credentials: 'same-origin'

        })

        .then((response) => {
            if (response.status !== 200) {
                console.log(response.status);
            } 
        })
    }
    
}
</script>

<style>

  #form-wrapper {
    display: flex;
    flex-direction: column;
    align-items: center;
    margin-top: 50px;
    
  }

  #profile-button {
      margin-top: 20px;
  }

  

  #logout {
      background:mediumaquamarine;
  }

  .form-profile {
      box-shadow: 0px 0px 50px #ded4c3;
  }

</style>
