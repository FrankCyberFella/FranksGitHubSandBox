<template>
    <div id="navbar">
        <div id="wrapper">
            <div id="nav-profile-button">
                <router-link :to="{ name: 'profile' }">
                    <img id="navbar-imgs" src="@/assets/profile.png"/>
                </router-link>
            </div>

            <div id="nav-home-button">
                <router-link :to="{ name: 'home' }">
                    <img id="navbar-imgs" src="@/assets/home.png"/>
                </router-link>
            </div>

            <div id="nav-favorites-button">
                <router-link :to="{ name: 'favorites' }">
                    <img id="navbar-imgs" src="@/assets/favorites.png"/>
                </router-link>
            </div>
        </div>
    </div>
</template>

<script>
export default {

    name: 'navbar',
    components: {
    },

    data() {
        return {

        };
    },

}
</script>

<style>

    #wrapper {
        background-color: white;
        display: flex;
        justify-content: space-between;
        font-size: 32px;
        padding-left: 20px;
        padding-right: 20px;
        padding-top: 10px;
        padding-bottom: 10px;
        box-shadow: 0px 0px 50px #ded4c3;
        border-radius: 10px;

        position: fixed;
        bottom: 0;
        width: 100%;
    }

    #navbar-imgs {
        max-width: 25%;
        height: auto;
    }


</style>
