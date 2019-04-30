<template>
  <div id="login" class="text-center">
    <div id="login-wrapper">
      <img id="login-logo" src="@/assets/rr_logo.png"/>
    </div>
    <form class="form-signin" @submit.prevent="login">
      <h1 class="h3 mb-3 font-weight-normal">Sign In</h1>
      <div class="alert alert-danger" role="alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>
      <div class="alert alert-success" role="alert" v-if="this.$route.query.registration">
        Thank you for registering, please sign in.
      </div>
      <label for="username" class="sr-only">Username</label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      <label for="password" class="sr-only">Password</label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
      <router-link :to="{ name: 'register' }">
        Need an account?
      </router-link>
      <button class="btn btn-lg btn-primary btn-block" type="submit">
        Sign in
      </button>
    </form>
  </div>
</template>

<script>
import auth from '@/shared/auth.js';

export default {
  name: 'login',
  components: {},
  data() {
    return {
      logo: "@/assets/imgs/restauraunt_tinder_logo.PNG",
      user: {
        username: '',
        password: '',
      },
      invalidCredentials: false,
    };
  },

  computed: {
     logoImg() {
            return `@/assets/test.png`;
        }
    
    },

  methods: {
    login() {
      fetch(`${process.env.VUE_APP_REMOTE_API}/login`, {
        method: 'POST',
        headers: {
          Accept: 'application/json',
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(this.user),
      })
        .then((response) => {
          if (response.ok) {
            return response.text();
          } else {
            this.invalidCredentials = true;
          }
        })
        .then((token) => {
          if (token != undefined) {
            if (token.includes('"')) {
              token = token.replace(/"/g, '');
            }
            auth.saveToken(token);
            this.$router.push('/');
          }
        })
        .catch((err) => console.error(err));
    },
  },
};
</script>

<style>
html,
body {
  height: 100%;
}
#app {
  height: 100%;
}
#login {
  height: 100%;
  display: -ms-flexbox;
  display: flex;
  -ms-flex-align: center;
  align-items: center;
  padding-top: 40px;
  padding-bottom: 40px;
  background-color: #fff4e1;
  /*background-color: #f5f5f5;*/
  font-family: 'Roboto Condensed', sans-serif;
  justify-content: center;
}

.form-signin {
  width: 100%;
  max-width: 330px;
  padding: 15px;
  margin-left: 50px;
  background-color: white;
  box-shadow: 0px 0px 50px #ded4c3;
  border-radius: 10px;
  
}

.form-signin .form-control {
  position: relative;
  box-sizing: border-box;
  height: auto;
  padding: 10px;
  font-size: 16px;
  
}
.form-signin .form-control:focus {
  z-index: 2;
}
.form-signin input[type='text'] {
  margin-bottom: 10px;
  border-bottom-right-radius: 0;
  border-bottom-left-radius: 0;
}
.form-signin input[type='password'] {
  margin-bottom: 10px;
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}

#login-wrapper {
  margin-right: 50px;
  margin-left: 20px;
}

#login-logo {
  max-width: 100%;
  height: auto;
}

#login-logo{
  animation: rr-logo-animation-frames linear 1s;
  animation-iteration-count: 1;
  transform-origin: 50% 50%;
  -webkit-animation: rr-logo-animation-frames linear 1s;
  -webkit-animation-iteration-count: 1;
  -webkit-transform-origin: 50% 50%;
  -moz-animation: rr-logo-animation-frames linear 1s;
  -moz-animation-iteration-count: 1;
  -moz-transform-origin: 50% 50%;
  -o-animation: rr-logo-animation-frames linear 1s;
  -o-animation-iteration-count: 1;
  -o-transform-origin: 50% 50%;
  -ms-animation: rr-logo-animation-frames linear 1s;
  -ms-animation-iteration-count: 1;
  -ms-transform-origin: 50% 50%;

}

@keyframes rr-logo-animation-frames{
  0% {
    transform:  rotate(0deg) scaleX(1.00) scaleY(1.00) ;
  }
  10% {
    transform:  rotate(-3deg) scaleX(0.80) scaleY(0.80) ;
  }
  20% {
    transform:  rotate(-3deg) scaleX(0.80) scaleY(0.80) ;
  }
  30% {
    transform:  rotate(3deg) scaleX(1.20) scaleY(1.20) ;
  }
  40% {
    transform:  rotate(-3deg) scaleX(1.20) scaleY(1.20) ;
  }
  50% {
    transform:  rotate(3deg) scaleX(1.20) scaleY(1.20) ;
  }
  60% {
    transform:  rotate(-3deg) scaleX(1.20) scaleY(1.20) ;
  }
  70% {
    transform:  rotate(3deg) scaleX(1.20) scaleY(1.20) ;
  }
  80% {
    transform:  rotate(-3deg) scaleX(1.20) scaleY(1.20) ;
  }
  90% {
    transform:  rotate(3deg) scaleX(1.20) scaleY(1.20) ;
  }
  100% {
    transform:  rotate(0deg) scaleX(1.20) scaleY(1.20) ;
  }
}

@-moz-keyframes rr-logo-animation-frames{
  0% {
    -moz-transform:  rotate(0deg) scaleX(1.00) scaleY(1.00) ;
  }
  10% {
    -moz-transform:  rotate(-3deg) scaleX(0.80) scaleY(0.80) ;
  }
  20% {
    -moz-transform:  rotate(-3deg) scaleX(0.80) scaleY(0.80) ;
  }
  30% {
    -moz-transform:  rotate(3deg) scaleX(1.20) scaleY(1.20) ;
  }
  40% {
    -moz-transform:  rotate(-3deg) scaleX(1.20) scaleY(1.20) ;
  }
  50% {
    -moz-transform:  rotate(3deg) scaleX(1.20) scaleY(1.20) ;
  }
  60% {
    -moz-transform:  rotate(-3deg) scaleX(1.20) scaleY(1.20) ;
  }
  70% {
    -moz-transform:  rotate(3deg) scaleX(1.20) scaleY(1.20) ;
  }
  80% {
    -moz-transform:  rotate(-3deg) scaleX(1.20) scaleY(1.20) ;
  }
  90% {
    -moz-transform:  rotate(3deg) scaleX(1.20) scaleY(1.20) ;
  }
  100% {
    -moz-transform:  rotate(0deg) scaleX(1.20) scaleY(1.20) ;
  }
}

@-webkit-keyframes rr-logo-animation-frames {
  0% {
    -webkit-transform:  rotate(0deg) scaleX(1.00) scaleY(1.00) ;
  }
  10% {
    -webkit-transform:  rotate(-3deg) scaleX(0.80) scaleY(0.80) ;
  }
  20% {
    -webkit-transform:  rotate(-3deg) scaleX(0.80) scaleY(0.80) ;
  }
  30% {
    -webkit-transform:  rotate(3deg) scaleX(1.20) scaleY(1.20) ;
  }
  40% {
    -webkit-transform:  rotate(-3deg) scaleX(1.20) scaleY(1.20) ;
  }
  50% {
    -webkit-transform:  rotate(3deg) scaleX(1.20) scaleY(1.20) ;
  }
  60% {
    -webkit-transform:  rotate(-3deg) scaleX(1.20) scaleY(1.20) ;
  }
  70% {
    -webkit-transform:  rotate(3deg) scaleX(1.20) scaleY(1.20) ;
  }
  80% {
    -webkit-transform:  rotate(-3deg) scaleX(1.20) scaleY(1.20) ;
  }
  90% {
    -webkit-transform:  rotate(3deg) scaleX(1.20) scaleY(1.20) ;
  }
  100% {
    -webkit-transform:  rotate(0deg) scaleX(1.20) scaleY(1.20) ;
  }
}

@-o-keyframes rr-logo-animation-frames {
  0% {
    -o-transform:  rotate(0deg) scaleX(1.00) scaleY(1.00) ;
  }
  10% {
    -o-transform:  rotate(-3deg) scaleX(0.80) scaleY(0.80) ;
  }
  20% {
    -o-transform:  rotate(-3deg) scaleX(0.80) scaleY(0.80) ;
  }
  30% {
    -o-transform:  rotate(3deg) scaleX(1.20) scaleY(1.20) ;
  }
  40% {
    -o-transform:  rotate(-3deg) scaleX(1.20) scaleY(1.20) ;
  }
  50% {
    -o-transform:  rotate(3deg) scaleX(1.20) scaleY(1.20) ;
  }
  60% {
    -o-transform:  rotate(-3deg) scaleX(1.20) scaleY(1.20) ;
  }
  70% {
    -o-transform:  rotate(3deg) scaleX(1.20) scaleY(1.20) ;
  }
  80% {
    -o-transform:  rotate(-3deg) scaleX(1.20) scaleY(1.20) ;
  }
  90% {
    -o-transform:  rotate(3deg) scaleX(1.20) scaleY(1.20) ;
  }
  100% {
    -o-transform:  rotate(0deg) scaleX(1.20) scaleY(1.20) ;
  }
}

@-ms-keyframes rr-logo-animation-frames {
  0% {
    -ms-transform:  rotate(0deg) scaleX(1.00) scaleY(1.00) ;
  }
  10% {
    -ms-transform:  rotate(-3deg) scaleX(0.80) scaleY(0.80) ;
  }
  20% {
    -ms-transform:  rotate(-3deg) scaleX(0.80) scaleY(0.80) ;
  }
  30% {
    -ms-transform:  rotate(3deg) scaleX(1.20) scaleY(1.20) ;
  }
  40% {
    -ms-transform:  rotate(-3deg) scaleX(1.20) scaleY(1.20) ;
  }
  50% {
    -ms-transform:  rotate(3deg) scaleX(1.20) scaleY(1.20) ;
  }
  60% {
    -ms-transform:  rotate(-3deg) scaleX(1.20) scaleY(1.20) ;
  }
  70% {
    -ms-transform:  rotate(3deg) scaleX(1.20) scaleY(1.20) ;
  }
  80% {
    -ms-transform:  rotate(-3deg) scaleX(1.20) scaleY(1.20) ;
  }
  90% {
    -ms-transform:  rotate(3deg) scaleX(1.20) scaleY(1.20) ;
  }
  100% {
    -ms-transform:  rotate(0deg) scaleX(1.20) scaleY(1.20) ;
  }
}

#login-logo:active {
  
	-webkit-animation: rotate-center 1s ease-in-out both;
	        animation: rotate-center 1s ease-in-out both;

}

/* ----------------------------------------------
 * Generated by Animista on 2019-4-18 10:37:22
 * w: http://animista.net, t: @cssanimista
 * ---------------------------------------------- */

/**
 * ----------------------------------------
 * animation rotate-center
 * ----------------------------------------
 */
@-webkit-keyframes rotate-center {
  0% {
    -webkit-transform: rotate(0);
            transform: rotate(0);
  }
  100% {
    -webkit-transform: rotate(360deg);
            transform: rotate(360deg);
  }
}
@keyframes rotate-center {
  0% {
    -webkit-transform: rotate(0);
            transform: rotate(0);
  }
  100% {
    -webkit-transform: rotate(360deg);
            transform: rotate(360deg);
  }
}

@media screen and (max-width: 645px) {

    #login {
      display: flex;
      flex-direction: column;
      align-items: center;
    }

    #login-logo {
      max-width: 75%;
      margin-bottom: 50px;
      height: auto;
    }

    #login-wrapper {
      margin: 0px;
    }

    .form-signin {
      margin-left: 20px;
      margin-right: 20px;
    }
    
}


</style>
