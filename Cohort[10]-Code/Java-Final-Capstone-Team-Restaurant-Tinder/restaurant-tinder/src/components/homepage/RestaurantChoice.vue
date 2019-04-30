<template>
    <div id="restaurant-choice">

        <h1 v-show="loadingDisplay == false">{{restaurantDisplayed}} <img id="vegetarian-img" v-show="isVegetarian == true" src="@/assets/vegetarian_logo.png"/></h1>
        <h2 v-show="loadingDisplay == false"><b>Price Range:</b> {{dollarSigns}}</h2>
        <div class="alert alert-warning alert-dismissible fade show" role="alert" v-if="hide">
            <strong>Click the card to flip it and see additional info!</strong> 
                <button type="button" class="close" data-dismiss="alert" v-on:click="close">
                <span aria-hidden="true">&times;</span>
                 </button>
            </div>
        <div id="flipper-holder">
        <flipper
            :flipped="isFlipped"
            @click="isFlipped = !isFlipped"
            >
            
        
        <div id="cuisine-card" slot="front">   
            <img id="cuisine-picture" v-bind:src="cuisineImg" v-show="loadingDisplay == false" /> 
       </div>
       <div id="cuisine-card-back" slot="back">
        <div id="info-card" slot="back">        
            <h1>{{currentLocality}}</h1>
            <h3>Rating: {{currentRating}}</h3>
            <h4>Address: {{currentAddress}}</h4>
            <h4>Cuisines: {{currentCuisines}}</h4> 
            <ul id= "review-List">
            <li v-for="review in this.reviews" :key="review"><strong>{{review.name}}</strong> {{review.review}}</li>
            </ul>
        </div> 
       </div>  
            
        </flipper>
        

        <div id="like-dislike">
        <form @submit.prevent="" id="form-dislike">
        <button id="like-dislike-buttons" type= "submit" class= "form-dislike" v-show="loadingDisplay == false" v-on:click="pass"><img id="like-dislike-imgs" src="@/assets/dislike.png"/>
         </button>
         </form> 
        <form class='form-like' @submit.prevent="saveRestaurant">
         <button id="like-dislike-buttons" type= "submit" class = "button-like" v-show="loadingDisplay == false"><img id="like-dislike-imgs" src="@/assets/like.png"/></button>
        </form>
        </div>
        </div>
        <div id="loading-display">
            <img id="loading-picture" src="@/assets/imgs/loading.png"  v-show="loadingDisplay == true"/>
            <div class="spinner-border text-danger center" role="status" v-show="loadingDisplay == true">
                <span class="sr-only">Loading...</span>
            </div>
        </div>
    </div>
</template>

<script>

import Flipper from 'vue-flipper';
import auth from '@/shared/auth';

export default {
    components: {
        Flipper
    },
    data() {
        return {
            apiURL: "https://developers.zomato.com/api/v2.1/",
            restaurants: [],
            randomRestaurant: '',
            restaurantOptions: [],
            restaurantDisplayed: '',
            currency: '',
            dollarSigns: '',
            cuisine:'',
            imageDisplay: '',
            loadingDisplay: true,
            restaurant: '',
            isFlipped: false,
            currentLocality: '',
            currentRating: '',
            currentAddress: '',
            currentCuisines: '',
            currentCity: '',
            searchCity: '',
            searcnState: '',
            isVegetarian: false,
            restaurantReviews: [],
            reviews: [],
            reviewText: '',
            restaurantId: '',
            hide: true
        };
    },
    computed: {
        cuisineImg() {

            if (this.cuisine) {
                this.loadingDisplay = false;
            }
           
            return this.cuisine ? require(`@/assets/imgs/${this.cuisine}.png`) : '';
        }

    },
    methods: {

            close() {
                this.hide = !this.hide;
            },

            pass() {
                this.restaurantOptions.splice(this.randomRestaurant, 1);
                setTimeout(this.nextRestaurant, 300);
            },

            redirectMe() {
                this.$router.push({ path: '/profile', query: { invalidCity: 'success' } });
            },

            nextRestaurant(){
                
                this.isFlipped = false;
                this.randomRestaurant = Math.floor(Math.random() * (this.restaurantOptions.length));
                this.restaurantId = this.restaurantOptions[this.randomRestaurant].id;
                this.reviews = [];
                fetch('https://developers.zomato.com/api/v2.1/reviews?res_id=' + this.restaurantId, {
                        method: 'GET',
                        headers: {
                            'Content-Type': "application/json",
                            'user-key': '81cc853d216c63f3d060310593b971f1'
                        },
                    })
                    .then((response) => {
                    if(response.ok) {
                        return response.json();
                    }
                    })
                    .then((data) => {
                        this.restaurantReviews = data;
                        for(let i=0; i<data.reviews_shown; i++) {
                            this.reviews.push({name: this.restaurantReviews.user_reviews[i].review.user.name}, {review: this.restaurantReviews.user_reviews[i].review.review_text});                        }
                    })

               
                if (this.restaurantOptions.length == 1) {
                    this.$router.push({ path: '/profile'});
                }
                
                this.restaurantDisplayed = this.restaurantOptions[this.randomRestaurant].name;
                const currentCuisine = this.restaurantOptions[this.randomRestaurant].cuisine;
                this.currency = this.restaurantOptions[this.randomRestaurant].price;
                this.currentLocality = this.restaurantOptions[this.randomRestaurant].locality;
                this.currentRating = this.restaurantOptions[this.randomRestaurant].rating;
                this.currentAddress = this.restaurantOptions[this.randomRestaurant].address;
                this.currentCuisines = currentCuisine;
                this.cuisine = 'International';
                if(currentCuisine.includes('Burger')) {this.cuisine = 'Burger'}
                if(currentCuisine.includes('Caribbean')) {this.cuisine = 'Caribbean'}
                if(currentCuisine.includes('Chinese')) {this.cuisine = 'Chinese'}
                if(currentCuisine.includes('European')) {this.cuisine = 'European'}
                if(currentCuisine.includes('German')) {this.cuisine = 'German'}
                if(currentCuisine.includes('Indian')) {this.cuisine = 'Indian'}
                if(currentCuisine.includes('Italian')) {this.cuisine = 'Italian'}
                if(currentCuisine.includes('Japanese')) {this.cuisine = 'Japanese'}
                if(currentCuisine.includes('Mediterranean')) {this.cuisine = 'Mediterranean'}
                if(currentCuisine.includes('Mexican')) {this.cuisine = 'Mexican'}
                if(currentCuisine.includes('Spanish')) {this.cuisine = 'Spanish'}
                if(currentCuisine.includes('Thai')) {this.cuisine = 'Thai'}
                if(currentCuisine.includes('Vegetarian')) {
                    this.isVegetarian = true;
                    }
                
                this.dollarSigns = '';
                for (let i = 0; i < this.currency; i= i + 1) {
                    this.dollarSigns = this.dollarSigns + "$";
                }
                
                
            },
            
            saveRestaurant(){
                this.isFlipped = false;
                //alert('hello friendz');
                fetch(`${process.env.VUE_APP_REMOTE_API}/like`, {
                    method: 'POST',
                    headers: {
                        Authorization: 'Bearer ' + auth.getToken(),
                        Accept: 'application/json',
                                'Content-Type': 'application/json',
                                'Access-Control-Allow-Origin': '*',
                                
                    },
                    credentials: 'same-origin',
                    body: JSON.stringify(this.restaurantOptions[this.randomRestaurant]),

                })
                .then((response) => {
                if (response.ok) {
                this.$router.push({ path: '/'});
                } else {
                    this.registrationErrors = true;
          }
          
        }) .then(() => {

       
        fetch(`${process.env.VUE_APP_REMOTE_API}/link`, {
                    method: 'POST',
                    headers: {
                        Authorization: 'Bearer ' + auth.getToken(),
                        Accept: 'application/json',
                                'Content-Type': 'application/json',
                                'Access-Control-Allow-Origin': '*',
                                
                    },
                    credentials: 'same-origin',
                    body: JSON.stringify(this.restaurantOptions[this.randomRestaurant]),
                })
                .then((response) => {
                if (response.ok) {
                this.$router.push({ path: '/'});
                } else {
                    this.registrationErrors = true;
                }
                this.restaurantOptions.splice(this.randomRestaurant, 1);
                console.log(this.restaurantOptions.length);
                this.nextRestaurant();
                
          
        })
         })
        
        },
    },
     created() {

            console.log('hello');
            console.log(this.apiURL);
            console.log('goodbye');
            
            fetch(`${process.env.VUE_APP_REMOTE_API}/city`, {
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
            this.searchCity = data[0];
            this.searchState = data[1];
            fetch(this.apiURL + 'locations?query=' + this.searchCity + ', ' + this.searchState, {
                method: 'GET',
                headers: {
                    'Content-Type': "application/json",
                    'user-key': '81cc853d216c63f3d060310593b971f1',
                },
            })
            .then((response) => {
                if(response.ok) {
                    return response.json();
                }
            })
            .then((data) => {
                if (data.location_suggestions.length == 0) {
                    console.log('There is not  proper city!!!');
                    setTimeout(this.redirectMe, 3000);
                } 
                
                this.currentCity = data.location_suggestions[0].city_id;
                
                if (!this.currentCity) {
                    console.log('HEY THIS IS UNDEFINED!!');
                }
                console.log(this.currentCity);
            })

            .then(() => {
            fetch('http://localhost:8080/AuthenticationApplication/preference', {
                method: 'GET',
                headers: {
                Authorization: 'Bearer ' + auth.getToken(),
                 Accept: 'application/json',
                                'Content-Type': 'application/json',
                                'Access-Control-Allow-Origin': '*',
                },       
            })
            .then((response) => {
                if(response.ok) {
                    return response.json();
                }
            })
            .then((data) => {
                this.apiURL = this.apiURL + "search?city_id=" + this.currentCity;
                this.currentCuisines = data;
                console.log(this.currentCuisines);
                if (this.currentCuisine != "") {
                this.apiURL = this.apiURL + "&cuisines=" + this.currentCuisines
                console.log(this.apiURL);
                 }
            fetch(this.apiURL, {
                method: 'GET',
                headers: {
                    'Content-Type': "application/json",
                    'user-key': '81cc853d216c63f3d060310593b971f1',
                },
            })
            .then((response) => {
                if(response.ok) {
                    return response.json();
                }
            })
            .then((data) => {
                this.restaurants = data;
              //  const randomRestaurant = Math.floor(Math.random() * (data.results_shown));
                for(let i=0; i<data.results_shown; i++) {
                let restaurant = {
                    id: this.restaurants.restaurants[i].restaurant.R.res_id,
                    name: this.restaurants.restaurants[i].restaurant.name,
                    cuisine: this.restaurants.restaurants[i].restaurant.cuisines,
                    price: this.restaurants.restaurants[i].restaurant.price_range,
                    rating: this.restaurants.restaurants[i].restaurant.user_rating.aggregate_rating,
                    address: this.restaurants.restaurants[i].restaurant.location.address,
                    locality: this.restaurants.restaurants[i].restaurant.location.locality,
                    city: this.restaurants.restaurants[i].restaurant.location.city_id,
                    menu: this.restaurants.restaurants[i].restaurant.menu_url
                };
                this.restaurantOptions.push(restaurant);
                }
                console.log(this.restaurantOptions.length);
                this.nextRestaurant();
                
            })
            })
            })
            })
    }
}
</script>

<style src="vue-flipper/dist/vue-flipper.css" />

<style>
.center {
    margin-top: 0px;
    margin-left: auto;
    margin-right: auto;
}

h2 {
    font-size: 1000%;
    color:rgb(88, 168, 8);
}
b {
    color: black;
    font-size: 50%;
}
#cuisine-picture {
    width: 600px;
    height: 600px;
    border-radius: 10px;
}
#loading-picture {
    display: block;
    margin-left: auto;
    margin-right: auto;
    width: 600px;
    height: 600px;
}
#loading-display {
    display: flex;
    flex-direction: column;
}

#cuisine-card {
    cursor: pointer;
    display: inline-block;
    background-color: white;
    padding: 10px;
    box-shadow: 0px 0px 40px #ded4c3;
    border-radius: 20px;
    margin: 20px;
    
}
#cuisine-card-back {
    overflow: auto;
    cursor: pointer;
    display: inline-block;
    background-color: white;
    padding: 10px 5px 10px 5px;
    box-shadow: 0px 0px 40px #ded4c3;
    border-radius: 20px;
    margin: 20px;
}

#like-dislike {
    display: flex;
    flex-direction: row;
    justify-content: space-between;
}

#form-dislike {
    border-radius: 50%;
    box-shadow: 0px 0px 30px #ded4c3;
}

.form-like {
    border-radius: 50%;
    box-shadow: 0px 0px 30px #ded4c3;
}

#like-dislike-buttons {
    border-radius: 50%;
    border: none;
    background-color: white;
    width: 100px;
    height: 100px;
}

#like-dislike-imgs {
    max-width: 90px;
    max-height: 90px;
}
#info-card {
    overflow: auto;
    position: relative;
    left: calc(50% - 310px);
    width: 600px;
    height: 600px;
    align-items: center;
    text-align: center;
    background: #f5f5f5;
    margin-left: 10px;
    
    padding: 10px;
    border-radius: 10px;
     
}


#flip-hold {
    height: auto;
    width: auto;
}
#vegetarian-img {
    width: 30px; 
    height: auto;
    padding-bottom: 5px;
}

#review-List {
    list-style-type: none;
    text-align: left;
}

#review-List li {
    padding-top: 10px;
}
#flipper-holder {
    display: flex;
    flex-direction: column;
}

@media screen and (max-width: 1000px) {
    #cuisine-picture {
    width: 400px;
    height: 400px;
    border-radius: 10px;
}
#info-card {
    overflow: auto;
    position: relative;
    left: calc(50% - 210px);
    width: 400px;
    height: 400px;
    align-items: center;
    text-align: center;
    background: #f5f5f5;
    margin-left: 10px;
    
    padding: 10px;
    border-radius: 10px;
     
}
    
    
}
@media screen and (max-width: 800px) {
    #cuisine-picture {
    width: 300px;
    height: 300px;
    border-radius: 10px;
}
#info-card {
    overflow: auto;
    position: relative;
    left: calc(50% - 160px);
    width: 300px;
    height: 300px;
    align-items: center;
    text-align: center;
    background: #f5f5f5;
    margin-left: 10px;
    
    padding: 10px;
    border-radius: 10px;
     
}
#app {
    width: 100%;
    height: 100%;
}
    
    
}
/* @media screen and (max-width: 500px) {
    #cuisine-picture {
    width: 200px;
    height: 200px;
    border-radius: 10px;
}
#info-card {
    overflow: auto;
    position: relative;
    left: calc(50% - 110px);
    width: 200px;
    height: 200px;
    align-items: center;
    text-align: center;
    background: #f5f5f5;
    margin-left: 10px;
    
    padding: 10px;
    border-radius: 10px;
     
}
#like-dislike-buttons {
    border-radius: 50%;
    border: none;
    background-color: white;
    width: 50px;
    height: 50px;
    position: absolute;
    bottom: 5%;
  
}

#like-dislike-imgs {
    max-width: 45px;
    max-height: 45px;
    position: absolute;
    bottom: 5%;
  
}

    
    
} */
</style>
