<template>
   <div id="register">
   <h1>Register with Restaurant Tinder</h1>
   <form class='form-register' @submit.prevent="register">
         <div class="alert alert-danger" role="alert" v-if="registrationErrors == true">
          Please fill out all fields
          </div>
         <label for= "email">E-mail</label>
         <input type='text' class="form-control" id="email" placeholder="Email" v-model="user.username" required autofocus/>

         <label for="password">Password</label>
         <input type='password' class="form-control" id="password" placeholder="Password" v-model="user.password" required autofocus/>

         <label for= "City">City</label>
         <input type='text' class="form-control" id="city" placeholder="City" v-model="user.city" required autofocus/>

         <label for="State">State</label>
         <input type='text' class="form-control" id="state" placeholder="State" v-model="user.state" required autofocus/>

         <label for="Cuisine">Cuisine</label>
         <select class="custom-select" v-model="user.current_preference">
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
        </select>

         <button class="btn btn-primary" id="register-button" type='submit'>Submit</button>
    </form>
   </div>
</template>

<script>
export default {
   name:'register',
   data() {
      return {
         user: {
            username: '',
            password: '',
            city: '',
            state: '',
            current_preference: '',
            role: 'user'
         },
         registrationErrors: false,
      };
   },
   methods: {
   register() {
      fetch(`${process.env.VUE_APP_REMOTE_API}/register`, {
        method: 'POST',
        headers: {
          Accept: 'application/json',
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(this.user),
      })
        .then((response) => {
          if (response.ok) {
            this.$router.push({ path: '/login', query: { registration: 'success' } });
          } else {
            this.registrationErrors = true;
          }
        })
        
        //.then((err) => console.error(err));
    },
}
}
</script>

<style>

  #register {
    display: flex;
    flex-direction: column;
    align-items: center;
  }

  form {
    margin-left: 20px;
    margin-right: 20px;
    background-color: white;
    max-width: 400px;
    box-shadow: 0px 0px 50px #ebebeb;
    border-radius: 10px;
    padding: 20px;
  }

  #register-button {
    margin: 10px;
  }

  #email {
    margin-bottom: 10px;
  }

  #password {
    margin-bottom: 10px;
  }

  #city {
    margin-bottom: 10px;
  }

  #state {
    margin-bottom: 10px;
  }
</style>
