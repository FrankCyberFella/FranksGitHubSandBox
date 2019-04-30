<template>
    <div id="favorites-page" >
        <logout/>
        <h1>Your Favorites</h1>
        <div class="alert alert-success" role="alert" v-if="this.$route.query.like">
                    Thank you for visiting!
                </div>

        <div id="favorites-containter">
            <div id="favorites-card-holder" v-for="restaurant in restaurants" v-bind:key="restaurant">
                <div id="cuisine-card-like"> 
                        <img id="delete-button" v-on:click="deleteFav(restaurant)" src="@/assets/dislike.png"/>
                         
                        <img id="favorites-cuisine-picture" v-bind:src="getCuisine(restaurant)"/>
                        <h3>{{restaurant.name}}</h3>
                        <h4>{{restaurant.cuisine}}</h4>
                        <h5>{{restaurant.address}}</h5>
                        <h3>Rating: {{restaurant.rating}}</h3>
                        <h3> <strong id="dollarSigns" v-for="n in restaurant.price" v-bind:key="n">$</strong></h3>
                        <a v-bind:href="restaurant.menu" target="_blank">Menu</a>
                        <div id="visits-line">
                            <button type=submit id="visit-button" class= "btn btn-secondary" v-on:click= "addVisit(restaurant)">Visited!</button>
                            <strong>Visits: {{restaurant.visits}}</strong>
                        </div>
                        
                        
                    </div>

            </div>
        </div>
        <navbar></navbar>
    </div>
</template>

<script>
import Navbar from '@/components/nav/NavBar.vue'
import auth from '@/shared/auth';
import Logout from '@/components/logout/Logout.vue'

export default {

    name: 'favorites',
    components: {
        Navbar,
        Logout

    },
    data () {
        return {
            isFlipped: false,
            count: 0,
            dollarSigns: '',
            visits: 0,
            restaurants: [],
            cuisine: ''
        }
    },
    
    methods: {
        getCuisine(restaurant) {
                this.cuisine = 'International';
                if(restaurant.cuisine.includes('Burger')) {this.cuisine = 'Burger'}
                if(restaurant.cuisine.includes('Caribbean')) {this.cuisine = 'Caribbean'}
                if(restaurant.cuisine.includes('Chinese')) {this.cuisine = 'Chinese'}
                if(restaurant.cuisine.includes('European')) {this.cuisine = 'European'}
                if(restaurant.cuisine.includes('German')) {this.cuisine = 'German'}
                if(restaurant.cuisine.includes('Indian')) {this.cuisine = 'Indian'}
                if(restaurant.cuisine.includes('Italian')) {this.cuisine = 'Italian'}
                if(restaurant.cuisine.includes('Japanese')) {this.cuisine = 'Japanese'}
                if(restaurant.cuisine.includes('Mediterranean')) {this.cuisine = 'Mediterranean'}
                if(restaurant.cuisine.includes('Mexican')) {this.cuisine = 'Mexican'}
                if(restaurant.cuisine.includes('Spanish')) {this.cuisine = 'Spanish'}
                if(restaurant.cuisine.includes('Thai')) {this.cuisine = 'Thai'}

                return this.cuisine ? require(`@/assets/imgs/${this.cuisine}.png`) : '';
        },

        addVisit(restaurant) {
            console.log(restaurant);
            fetch(`${process.env.VUE_APP_REMOTE_API}/visited`, {
                    method: 'POST',
                    headers: {
                        Authorization: 'Bearer ' + auth.getToken(),
                        Accept: 'application/json',
                                'Content-Type': 'application/json',
                                'Access-Control-Allow-Origin': '*',
                                
                    },
                    credentials: 'same-origin',
                    body: JSON.stringify(restaurant),
                })
                .then(() => {
                    document.location.reload(true);
                    this.$router.push({ path: '/favorites', query: { like: 'success' } });
                }) 
                    
                
        },

        deleteFav(restaurant) {
            console.log(restaurant);
            fetch(`${process.env.VUE_APP_REMOTE_API}/deleteFav`, {
                    method: 'POST',
                    headers: {
                        Authorization: 'Bearer ' + auth.getToken(),
                        Accept: 'application/json',
                                'Content-Type': 'application/json',
                                'Access-Control-Allow-Origin': '*',
                                
                    },
                    credentials: 'same-origin',
                    body: JSON.stringify(restaurant),
                })
                .then(() => {
                    document.location.reload(true);
                    this.$router.push({ path: '/favorites'});
                })     
        },         
    },

    created() {
        fetch(`${process.env.VUE_APP_REMOTE_API}/retrieveLike`, {
                    method: 'GET',
                    headers: {
                        Authorization: 'Bearer ' + auth.getToken(),
                        Accept: 'application/json',
                                'Content-Type': 'application/json',
                                'Access-Control-Allow-Origin': '*',        
                    },
                    credentials: 'same-origin',
            })
            .then((response) => {
                if(response.ok) {
                    return response.json();
                }
            })

            .then((data) => {
                this.restaurants = data;

            })


    }

}
</script>

<style>

#favorites-page {
    background-color: #fff4e1;;
}

#favorites-container {
    display: flex;
    flex-wrap: wrap;
    

}


#favorites-cuisine-picture {
    max-width: 100%;
    height: auto;
    border-radius: 20px;
    display: block;
    margin-left: auto;
    margin-right: auto;
    
}

#favorites-card-holder {
    display: inline-block;
    width: 30%;
    height: auto;
    
}

#cuisine-card-like {
    background-color: white;
    padding: 20px;
    box-shadow: 0px 0px 40px #ded4c3;
    border-radius: 20px;
    margin: 10px;
}
#dollarSigns {
    color:rgb(88, 168, 8);
}

#cuisine-card-like button {
    align-self: flex-end;
    
}

#delete-button {
    max-width: 10%;
    height: auto;
    display: float;
    margin-bottom: 5px;
    float:right;
    cursor: pointer;
}
#visit-button {
    margin-left: 10px;

}
#visits-line {
    display: flex;
    flex-direction: row;
    justify-content: space-between;
}

@media screen and (max-width: 800px) {

    #favorites-card-holder {
    display: inline-block;
    width: 45%;
    height: auto;
    
}
}
 
 @media screen and (max-width: 500px) {

    #favorites-card-holder {
    display: inline-block;
    width: 95%;
    height: auto;
    
}
 }
/*.Flipper {
    width: 100px;
    height: 100px;
}*/

/* #favorites-info-card{ 
    
    align-items: center;
    background: #f5f5f5;
    margin-left: 0px;
    
    padding: 10px;
    border-radius: 10px;
     
}

#favorites-cuisine-picture {
    width: 250px;
    height: 250px;
}



#cuisine-card-back-like {
    cursor: pointer;
    background-color: white;
    padding: 10px 5px 10px 5px;
    box-shadow: 0px 0px 40px #dcdcdc;
    border-radius: 20px;
    margin: 20px;
}
*/

</style>
