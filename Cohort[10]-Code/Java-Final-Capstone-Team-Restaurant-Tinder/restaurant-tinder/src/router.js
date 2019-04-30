import Vue from "vue";
import Router from "vue-router";
import Login from "./views/LoginPage.vue";
import HomePage from "./views/HomePage.vue";
import Favorites from "./views/FavoritesPage.vue";
import ProfilePage from "./views/ProfilePage.vue";
import Register from "./views/Register.vue";
import Navbar from "@/components/nav/NavBar.vue";
import auth from "./shared/auth";


Vue.use(Router);

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
  mode: "history",
  base: process.env.BASE_URL,
  routes: [
    
    {
      path: "/login",
      name: "login",
      component: Login,
    },

    {
      path: "/register",
      name: "register",
      component: Register,
    },
    {
      path: "/",
      name: "home",
      component: HomePage
    },
    {
      path: "/favorites",
      name: "favorites",
      component: Favorites
    },
    {
      path: "/profile",
      name: "profile",
      component: ProfilePage
    },
    {
      path: "/navbar",
      name: "navbar",
      component: Navbar
    },
    {
      path: "/home",
      name: "home",
      component: HomePage
    }
  ]
});

router.beforeEach((to, from, next) => {
  // redirect to login page if not logged in and trying to access a restricted page
  const publicPages = ['/login', '/register'];
  const authRequired = !publicPages.includes(to.path);
  console.log(authRequired);
  const loggedIn = auth.getUser();
  console.log(loggedIn);

  if (authRequired && !loggedIn) {
    return next('/login');
  }

  next();
});

export default router;
