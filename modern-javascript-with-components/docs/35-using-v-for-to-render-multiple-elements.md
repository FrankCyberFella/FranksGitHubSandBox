# Using `v-for` to Render Multiple Elements (45 Minutes)

There are often times when you have a list of values and you want to render elements based on that list. A table of products, a list of available options for a select, or a list of radio buttons are just some examples.

Vue gives us an easy way to take an array or a JavaScript object and create a series of DOM elements from them.

We're going to do that with an array of credit card types that we can use in the credit card type select box. We may only accept certain credit cards and need to show only the ones we accept in the select box.

We'll start with the data first. So let's create a data attribute to hold all the available credit card types that will go in the select box. Here, we'll make it an object with key/value pairs.

``` JavaScript
expDate: '',
creditLogoSrc: '../assets/credit.png',
availableCardTypes: {
    'visa': 'Visa',
    'mc': 'MasterCard',
    'dc': 'Discover Card'
}
```

We then want to build an option element for every key in that object. We can do that by going to the `creditCardType` select area and adding in a new option tag with the `v-for` attribute included:

``` HTML
<select name="creditCardType" id="creditCardType" class="creditCardType" v-model="creditCardType">
    <option value="" disabled>-- Select One --</option>
    <option v-for="(creditCardName, creditCardAbbrev) in availableCardTypes"
        v-bind:value="creditCardAbbrev">{{ creditCardName }}</option>
</select>
```

There's quite a bit going on here, so let's piece it apart.

When using `v-for` on an object, the default action is for the `v-for` to loop through all the values of the properties. So if we had our state object that looks like this:

``` JavaScript
{
    'visa': 'Visa',
    'mc': 'MasterCard',
    'dc': 'Discover Card'
}
```

We can write a `v-for` to loop through those. It would look something like this:

``` HTML
v-for="value in availableCardTypes"
```

Using this would pull back the values only.

```
Visa
MasterCard
Discover Card
```

That's because, by default, the `v-for` will only return values and not keys. If you also want the keys, you have to specify that you want the keys stored in a variable for each iteration as well.

``` HTML
v-for="(value, key) in availableCardTypes"
```

Or, written another way:

``` HTML
v-for="(creditCardName, creditCardAbbrev) in availableCardTypes"
```

This will allow us to get both the key and the value of each object property, treating as a map or dictionary of card types.

Looking again at the example, we are getting the `creditCardName` and the `creditCardAbbrev` and then binding the `creditCardAbbrev` to the value of the `option` tag and the `creditCardName` to the display text of the `option` tag.

```JavaScript
<option v-for="(creditCardName, creditCardAbbrev) in availableCardTypes"
    v-bind:value="creditCardAbbrev">{{ creditCardName }}</option>
```

We'll be talking about `v-bind` later, but that's how we bind a value to an HTML element's attributes.

If we add this into the component, we can see that a new option is created for each value in our object.

## `v-for` with Arrays

You can also use the `v-for` with a normal array. If we had the following array saved in the `availableCardTypes` data attribute:

``` JavaScript
[
    'Visa',
    'MasterCard',
    'Discover Card'
]
```

Then we could loop through those elements and their indexes with:

``` HTML
v-for="(creditCardName, index) in availableCardTypes"
```

Then the second argument is the index of that element in the array, starting at zero.

## Binding a Unique Key for Each Object

One thing you will notice after putting this code into your component is that VSCode is now giving an error saying that you should have a 'v-bind:key' directive. `v-bind:key` is a way for Vue to keep track of which object goes with which DOM element. That way, if an object is removed or moved in the array, Vue will know exactly which DOM element to update and won't need to rerender every DOM element over again. It lets Vue handle the DOM more efficiently than it otherwise would.

To do that, we just want to add another attribute to our `option` tag. The "key" must be a value that is unique to each object in the list, like a primary key or--in our example--the card type abbreviation.

``` HTML
<option v-for="(creditCardName, creditCardAbbrev) in availableCardTypes"
    v-bind:value="creditCardAbbrev" v-bind:key="creditCardAbbrev">{{ creditCardName }}</option>
```

This looks like the `v-bind:value` that we added before, but `v-bind:key` is only used internally to Vue and doesn't add a new attribute to the `option` tag. Adding the `v-bind:key` attribute will remove the error, and make our application more efficient.

## Computed Properties and Filtered Lists

Let's do the same for states. We will handle the states a little differently since we only want to ship to certain states and not all of them. States are going to be an array of objects that will hold information on the state's display name, the state's abbreviation and whether we will ship to that state or not.

These are saved in the `availableStates` data attribute. We can use that in the billing address section to populate the state select box. Even though we have an array this time, we can still use the `v-for` syntax to loop through all the states. Then we can use that state object to create our option tag.

``` HTML
<option v-for="stateObject in availableStates"
    v-bind:value="stateObject.abbreviation" v-bind:key="stateObject.abbreviation">
    {{stateObject.name}}
</option>
```

Since this is the billing state select box and we will happily accept money from any state in the union, that's all we need to do.

For `shippingState`, we only want to list the states that have their `canShip` property set to true. We can't really change the data attribute for `availableStates` because that will also change the list for `billingState`. We could duplicate the list, but that's just sounds awful.

Vue, however, gives us a way of making a property in our component that can be calculated from another data attribute. You could think of it almost like a view of that data. If that data attribute is ever updated, the computed properties based off of will also update.

Much like we have our `data` attributes, we can also have `computed` attributes. We can add a section for this in our component right below the `name` property.

We'll create a function in the `computed` section of our component that filters the availableStates list so that is only contains states where the `canShip` property is true.

``` JavaScript
name: 'order-form',
computed: {
    shippingStates(vm) {
        return vm.availableStates.filter(state => state.canShip);
    }
},
```

We can now use `shippingStates` as if it were a data attribute. That includes using it in the generation of our options for `shippingState`.

``` HTML
<option v-for="stateObject in shippingStates"
    v-bind:value="stateObject.abbreviation" v-bind:key="stateObject.abbreviation">{{stateObject.name}}</option>
```

We could have just filtered the states in the `v-for` ourselves, but by using `computed`, Vue will cache the computed value so that it doesn't need to be calculated every time and will automatically update `shippingStates` if `availableStates` ever changes.

### Unit Testing Computed Properties

To unit test computed properties so make sure your computed function is working correctly, you just need to set the data attribute that the computed property is being calculated from and then verify that the computed property is returning the correct results. Remember to use the `deep` keyword if you're checking arrays or objects.

``` JavaScript
it('should make computed property only return elements where canShip is true', () => {
    let testData = [
        {
            name: 'TEST1',
            canShip: true
        },
        {
            name: 'TEST2',
            canShip: false
        }
    ];
    let expectedData = [
        {
            name: 'TEST1',
            canShip: true
        }
    ];
    wrapper.setData({availableStates: testData});
    wrapper.vm.shippingStates.should.deep.equal(expectedData);
});
```

You should also unit test that the select boxes generate the appropriate options from the data that is provided.