<template>
    <form class="order-form"
    <!-- Start remove -->
    v-on:submit.prevent="saveOrder"
    <!-- End remove -->
    >
        <!-- Start remove -->
        <div class="message" v-if="message != ''">{{ message }}</div>
    <!-- End remove -->
    
        <div class="form-group">
            <label for="firstName">First Name:</label>
            <input type="text" name="firstName" id="firstName"
    <!-- Start remove -->
    v-model="order.firstName"
                v-bind:class="{ 'needs-content': order.firstName == '' }"
    <!-- End remove -->
    >
        </div>
        <div class="form-group">
            <label for="lastName">Last Name:</label>
            <input type="text" name="lastName" id="lastName"
    <!-- Start remove -->
    v-model="order.lastName"
                v-bind:class="{ 'needs-content': order.lastName == '' }"
    <!-- End remove -->
    >
        </div>

        <fieldset>
            <legend>Shipping Address</legend>
            <div class="form-group">
                <label for="shippingAddressOne">Address:</label>
                <input type="text" name="shippingAddressOne" id="shippingAddressOne"
    <!-- Start remove -->
    v-model="order.shippingAddressOne"
    <!-- End remove -->
    >
            </div>

            <div class="form-group">
                <label for="shippingAddressTwo">Address Line 2:</label>
                <input type="text" name="shippingAddressTwo" id="shippingAddressTwo"
    <!-- Start remove -->
    v-model="order.shippingAddressTwo"
    <!-- End remove -->
    >
            </div>

            <div class="form-group">
                <label>City, State, Zip</label>
                <input type="text" class="city" name="shippingCity" id="shippingCity" placeholder="city"
    <!-- Start remove -->
    v-model="order.shippingCity"
    <!-- End remove -->
    >
                <select name="shippingState" class="state"
    <!-- Start remove -->
    v-model="order.shippingState"
    <!-- End remove -->
    >
                    <option value="" disabled>ST</option>
    <!-- Start remove -->
    
                    <option v-for="stateObject in shippingStates"
        v-bind:value="stateObject.abbreviation" v-bind:key="stateObject.abbreviation">{{stateObject.name}}</option>
    <!-- End remove -->
    
                </select>
                <input type="text" name="shippingZip" class="zip" id="shippingZip" placeholder="11111"
    <!-- Start remove -->
    v-model="order.shippingZip"
    <!-- End remove -->
    >
            </div>
        </fieldset>

        <div class="form-group">
            <label>
                <input type="checkbox" name="sameAddress" id="sameAddress"
    <!-- Start remove -->
    v-model="sameAddress"
    <!-- End remove -->
    >Also use for billing address
            </label>
        </div>

        <fieldset
    <!-- Start remove -->
    v-if="! sameAddress" id="billingAddress"
    <!-- End remove -->
    >
            <legend>Billing Address</legend>
            <div class="form-group">
                <label for="billingAddressOne">Address:</label>
                <input type="text" name="billingAddressOne" id="billingAddressOne"
    <!-- Start remove -->
    v-model="order.billingAddressOne"
    <!-- End remove -->
    >
            </div>

            <div class="form-group">
                <label for="billingAddressTwo">Address Line 2:</label>
                <input type="text" name="billingAddressTwo" id="billingAddressTwo"
    <!-- Start remove -->
    v-model="order.billingAddressTwo"
    <!-- End remove -->
    >
            </div>

            <div class="form-group">
                <label>City, State, Zip</label>
                <input type="text" class="city" name="billingCity" id="billingCity" placeholder="city" v-model="order.billingCity">
                <select class="state" name="billingState"
    <!-- Start remove -->
    v-model="order.billingState"
    <!-- End remove -->
    >
                    <option value="" disabled>ST</option>
    <!-- Start remove -->
    
                    <option v-for="stateObject in availableStates"
        v-bind:value="stateObject.abbreviation" v-bind:key="stateObject.abbreviation">{{stateObject.name}}</option>
    <!-- End remove -->
    
                </select>
                <input class="zip" type="text" name="billingZip" id="billingZip" placeholder="11111"
    <!-- Start remove -->
    v-model="order.billingZip"
    <!-- End remove -->
    >
            </div>
        </fieldset>

        <fieldset>
            <legend>Credit Card</legend>
            <div class="form-group">
                <label>Credit Card Number</label>
                <input type="text" name="creditCardNumber" id="creditCardNumber" placeholder="1111111111111111" class="creditCardNumber"
    <!-- Start remove -->
    v-model="order.creditCardNumber"
    <!-- End remove -->
    >
                <select name="creditCardType" id="creditCardType" class="creditCardType"
    <!-- Start remove -->
    v-model="order.creditCardType"
    <!-- End remove -->
    >
                    <option value="" disabled>-- Select One --</option>
    <!-- Start remove -->
    
                    <option v-for="(creditCardName, creditCardAbbrev) in availableCardTypes"
                        v-bind:value="creditCardAbbrev" v-bind:key="creditCardAbbrev">{{ creditCardName }}</option>
    <!-- End remove -->
    
                </select>
                <img class="creditLogo"
    <!-- Start remove -->
    v-bind:src="creditCardLogoSrc"
    <!-- End remove -->
    >
            </div>
            <div class="form-group">
                <label for="expDate">
                    Exp. Date:
                </label>
                <input type="text" name="expDate" id="expDate" placeholder="mm/YY"
    <!-- Start remove -->
    v-model="order.expDate"
    <!-- End remove -->
    >
            </div>
        </fieldset>

        <button type="submit"
    <!-- Start remove -->
    v-bind:disabled="order.creditCardNumber == ''"
    <!-- End remove -->
    >Send Order</button>

    </form>
</template>

<script>
export default {
    name: 'order-form',
    // Start remove
    computed: {
        shippingStates(vm) {
            return vm.availableStates.filter(state => state.canShip);
        },
        creditCardLogoSrc(vm) {
            if(vm.order.creditCardNumber.startsWith('4')) {
                return require('../assets/visa.png');
            } else if (vm.order.creditCardNumber.startsWith('5')) {
                return require('../assets/mastercard.png');
            } else if (vm.order.creditCardNumber.startsWith('6')) {
                return require('../assets/discover.png');
            } else {
                return require('../assets/credit.png');
            }
        }
    },
    // End remove
    // Start remove
    methods: {
        saveOrder() {
            let url = 'https://httpbin.org/anything';

            let form = new FormData();
            for(let name in this.order) {
                form.append(name, this.order[name]);
            }

            return fetch(url, {
                method: 'POST',
                body: form
            }).then((response) => {
                return response.json();
            }).then((returnedData) => {
                this.message = 'Successfully Saved.';
            }).catch(() => {
                this.message = 'An Error Occurred';
            });
        }
    },
    // End remove
    data() {
        return {
            // Start remove
            message: '',
            order: {
                firstName: '',
                lastName: '',
                shippingAddressOne: '',
                shippingAddressTwo: '',
                shippingCity: '',
                shippingState: '',
                shippingZip: '',
                billingAddressOne: '',
                billingAddressTwo: '',
                billingCity: '',
                billingState: '',
                billingZip:'',
                creditCardNumber: '',
                creditCardType: '',
                expDate: ''
            },
            sameAddress: false,
            creditLogoSrc: '../assets/credit.png',
            // End remove
            availableCardTypes: {
                'visa': 'Visa',
                'mc': 'MasterCard',
                'dc': 'Discover Card'
            },
            availableStates: [
                {
                    "name": "Alabama",
                    "abbreviation": "AL",
                    "canShip": false
                },
                {
                    "name": "Alaska",
                    "abbreviation": "AK",
                    "canShip": false
                },
                {
                    "name": "Arizona",
                    "abbreviation": "AZ",
                    "canShip": false
                },
                {
                    "name": "Arkansas",
                    "abbreviation": "AR",
                    "canShip": false
                },
                {
                    "name": "California",
                    "abbreviation": "CA",
                    "canShip": false
                },
                {
                    "name": "Colorado",
                    "abbreviation": "CO",
                    "canShip": false
                },
                {
                    "name": "Connecticut",
                    "abbreviation": "CT",
                    "canShip": false
                },
                {
                    "name": "Delaware",
                    "abbreviation": "DE",
                    "canShip": false
                },
                {
                    "name": "Florida",
                    "abbreviation": "FL",
                    "canShip": false
                },
                {
                    "name": "Georgia",
                    "abbreviation": "GA",
                    "canShip": false
                },
                {
                    "name": "Hawaii",
                    "abbreviation": "HI",
                    "canShip": false
                },
                {
                    "name": "Idaho",
                    "abbreviation": "ID",
                    "canShip": false
                },
                {
                    "name": "Illinois",
                    "abbreviation": "IL",
                    "canShip": true
                },
                {
                    "name": "Indiana",
                    "abbreviation": "IN",
                    "canShip": true
                },
                {
                    "name": "Iowa",
                    "abbreviation": "IA",
                    "canShip": false
                },
                {
                    "name": "Kansas",
                    "abbreviation": "KS",
                    "canShip": false
                },
                {
                    "name": "Kentucky",
                    "abbreviation": "KY",
                    "canShip": false
                },
                {
                    "name": "Louisiana",
                    "abbreviation": "LA",
                    "canShip": false
                },
                {
                    "name": "Maine",
                    "abbreviation": "ME",
                    "canShip": false
                },
                {
                    "name": "Maryland",
                    "abbreviation": "MD",
                    "canShip": false
                },
                {
                    "name": "Massachusetts",
                    "abbreviation": "MA",
                    "canShip": false
                },
                {
                    "name": "Michigan",
                    "abbreviation": "MI",
                    "canShip": true
                },
                {
                    "name": "Minnesota",
                    "abbreviation": "MN",
                    "canShip": false
                },
                {
                    "name": "Mississippi",
                    "abbreviation": "MS",
                    "canShip": false
                },
                {
                    "name": "Missouri",
                    "abbreviation": "MO",
                    "canShip": false
                },
                {
                    "name": "Montana",
                    "abbreviation": "MT",
                    "canShip": false
                },
                {
                    "name": "Nebraska",
                    "abbreviation": "NE",
                    "canShip": false
                },
                {
                    "name": "Nevada",
                    "abbreviation": "NV",
                    "canShip": false
                },
                {
                    "name": "New Hampshire",
                    "abbreviation": "NH",
                    "canShip": false
                },
                {
                    "name": "New Jersey",
                    "abbreviation": "NJ",
                    "canShip": false
                },
                {
                    "name": "New Mexico",
                    "abbreviation": "NM",
                    "canShip": false
                },
                {
                    "name": "New York",
                    "abbreviation": "NY",
                    "canShip": false
                },
                {
                    "name": "North Carolina",
                    "abbreviation": "NC",
                    "canShip": false
                },
                {
                    "name": "North Dakota",
                    "abbreviation": "ND",
                    "canShip": false
                },
                {
                    "name": "Ohio",
                    "abbreviation": "OH",
                    "canShip": true
                },
                {
                    "name": "Oklahoma",
                    "abbreviation": "OK",
                    "canShip": false
                },
                {
                    "name": "Oregon",
                    "abbreviation": "OR",
                    "canShip": false
                },
                {
                    "name": "Pennsylvania",
                    "abbreviation": "PA",
                    "canShip": true
                },
                {
                    "name": "Rhode Island",
                    "abbreviation": "RI",
                    "canShip": false
                },
                {
                    "name": "South Carolina",
                    "abbreviation": "SC",
                    "canShip": false
                },
                {
                    "name": "South Dakota",
                    "abbreviation": "SD",
                    "canShip": false
                },
                {
                    "name": "Tennessee",
                    "abbreviation": "TN",
                    "canShip": false
                },
                {
                    "name": "Texas",
                    "abbreviation": "TX",
                    "canShip": false
                },
                {
                    "name": "Utah",
                    "abbreviation": "UT",
                    "canShip": false
                },
                {
                    "name": "Vermont",
                    "abbreviation": "VT",
                    "canShip": false
                },
                {
                    "name": "Virginia",
                    "abbreviation": "VA",
                    "canShip": false
                },
                {
                    "name": "Washington",
                    "abbreviation": "WA",
                    "canShip": false
                },
                {
                    "name": "West Virginia",
                    "abbreviation": "WV",
                    "canShip": false
                },
                {
                    "name": "Wisconsin",
                    "abbreviation": "WI",
                    "canShip": false
                },
                {
                    "name": "Wyoming",
                    "abbreviation": "WY",
                    "canShip": false
                }
            ]
        };
    }
};
</script>



<style lang="scss" scoped>
    .order-form {
        width: 800px;
        margin: auto;

        .needs-content {
            background-color: yellow;
        }

        div.form-group {
            padding: 0.25em;

            img.creditLogo {
                width: 50px;
                vertical-align: middle;
            }

            label {
                width: 45%;
                display: inline-block;
                font-weight: bold;
                text-align: right;
                padding-right: 1em;
                vertical-align: top;
            }
            input[type=text], select {
                width: 45%;
            }

            input.city, input.creditCardNumber {
                width: 18%;
                margin: 0 0.5em;
            }

            select.state, select.creditCardType {
                width: auto;
                margin: 0 0.5em;
            }

            input.zip {
                width: 15%;
                margin: 0 0.5em;
            }

            div.button-group {
                text-align: left;
                display: inline-block;
                width: 45%;

                label {
                    width: 100%;
                    text-align: left;
                }
            }
        }

        table {
            max-width: 100%;
            width: 100%;
            border-collapse: collapse;
            border-spacing: 0;

            > thead,
            > tbody,
            > tfoot {
                > tr {
                    > th,
                    > td {
                        padding: 0.25em;
                        vertical-align: top;
                        border-top: 1px solid lightgray;
                    }
                }
            }
            // Bottom align for column headings
            > thead > tr > th {
                vertical-align: bottom;
                border-bottom: 2px solid gray;
            } 
        }
    }

    .center {
        text-align: center;
    }
</style>
