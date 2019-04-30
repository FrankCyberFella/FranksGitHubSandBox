# Using `v-bind` to Bind Attribute Values (30 Minutes)

We can also bind attribute values--and not just text--to data attribute changes. One of the main ways you will use this is in setting classes on elements.

## Using `v-bind` to Toggle CSS Classes

Using the Vue `v-bind` syntax, we can set up CSS classes to toggle on and off for an element depending on what information is in a data attribute.

For example, let's say in our order form that we want some fields to be required. What we would like to do is visually show that to a user, so they know which fields they will need to fill in. If there is nothing entered into a required field, we'll set that field's background color to yellow. Once it has content, we will take that color off.

The first part of this is to create a CSS class that sets that color. That is already set up in the component as a `needs-content` class.

```CSS
.needs-content {
    background-color: yellow;
}
```

We can now set up a binding that watches for data coming into the data attribute for the field and removes the `needs-content` class once the field has content. Let's add that to the `firstName` field.

``` HTML
<input type="text" name="firstName" id="firstName" v-model="firstName"
    v-bind:class="{ 'needs-content': firstName == '', 'super': firstName == 'Joe' }">
```

As you can see, we pass `v-bind:class` a JavaScript object. The keys of that object are the classes that we want to toggle on this element and the values are a boolean expression that we well check to see if the class goes on or not. If the value evaluates to true, the class is added. If it evaluates to false, the class is removed.

In this `v-bind:class`:

``` HTML
v-bind:class="{ 'needs-content': firstName == '' }"
```

We are saying that we want Vue to check the `firstName` field. If it is empty--`firstName == ''` is true--then Vue will add the `needs-content` class. Otherwise, it will remove it.

We can add this same `v-bind:class` to every other field that would be required, like lastName, shippingAddress, the city, state and zip, etc.

You can use this same concept for `v-bind:style` to apply inline style rules to an element.

```HTML
<div v-bind:style="{ 'color': activeColor, 'font-size': fontSize + 'px' }"></div>
```

### Unit Testing `v-bind:class`

To test this functionality, we just need to set the data attributes appropriately and then see if the classes appear and disappear from the element.

```JavaScript
it('should remove the needs-content css class when firstName has content', () => {
    wrapper.setData({'firstName': 'TEST'});
    wrapper.find('#firstName').hasClass('needs-content').should.be.false;
});

it('should add the needs-content css class when firstName is empty', () => {
    wrapper.setData({'firstName': ''});
    wrapper.find('#firstName').hasClass('needs-content').should.be.true;
});
```

## Using `v-bind:src` to Change Images

We can also use the `v-bind` syntax to change images on the page by binding the `img` tag's `src` attribute to a data property on the component.

For instance, let's say that I want the credit card images to change depending on what credit card is being used. If I check the first digit of the card as it's typed in, I can tell whether the card is a Visa, MasterCard or Discover Card. There are some images for this in the `assets` folder already, and this sounds like a perfect use for a computed property.

So let's create a computed property that looks at `creditCardNumber` and returns a link to the logo of the company whose credit card is being used. If we don't know the card, just return the generic `credit.png`.

``` JavaScript
computed: {
    ...
    creditCardLogoSrc(vm) {
        if(vm.creditCardNumber.startsWith('4')) {
            return require('../assets/visa.png');
        } else if (vm.creditCardNumber.startsWith('5')) {
            return require('../assets/mastercard.png');
        } else if (vm.creditCardNumber.startsWith('6')) {
            return require('../assets/discover.png');
        } else {
            return require('../assets/credit.png');
        }
    }
},
```

> #### Why are we using `require` here?
>
> Our tool chain is doing a lot for us with our images that we haven't really talked about yet. Any image that we put into the `assets` folder is being handle in a special way for us to make our application more robust and efficient. This is being handled automatically for us if we put the images in a `src` attribute, but won't be automatically handled when we using image paths in our code.
>
> In order to get that assistance again from our code, we have to load the images using the `require` command. This is only needed for assets we've placed in the `assets` folder, so you if you have images from a CDN or other location, you won't need the `require`. We only need the `require` here because we're loading images from this `assets` folder.

And now we can change the image for that logo to:

``` HTML
<img class="creditLogo" v-bind:src="creditCardLogoSrc">
```

You can use this same technique for other attributes, like `v-bind:href`.

## Using `v-bind` to Disable Elements

We can conditionally disable elements by using `v-bind:disabled` on it. The value of that will be a boolean statement, either a data property or a boolean expression, that says whether the element should be disabled or not.

For our form, we could put in that the submit button is disabled until a credit card number is entered. We can do that pretty simply right on that button element.

``` HTML
<button type="submit" v-bind:disabled="creditCardNumber == ''">Send Order</button>
```

When the `creditCadNumber` is empty--the expression is true--then the element is disabled and can't be clicked. Once something is put into the `creditCardNumber` field, the button is enabled again.

This could be more robust by checking all the required fields. That would best be done in a `computed` property that could return true until all the fields are filled in, then start returning false so that the button could be enabled.

### Unit Testing Disabled Fields

We can unit test this by, again, setting data and then checking to make sure the field is disabled.

``` JavaScript
it('should disable the submit button when credit card number is blank', () => {
    wrapper.setData({'creditCardNumber': ''});
    wrapper.find('button[type=submit]').attributes().should.include.key('disabled');
});

it('should enable the submit button when credit card number is entered', () => {
    wrapper.setData({'creditCardNumber': '41111111111'});
    wrapper.find('button[type=submit]').attributes().should.not.include.key('disabled');
});
```

## Using `v-html` to Inject HTML in an Element

When we use the `{{ ... }}` syntax to put data into our HTML, that data will be properly escaped so that no user submitted HTML will be injected into our HTML. If that didn't happen, we leave ourselves open to Cross Site Scripting Attacks where a malicious user might be able to inject JavaScript into our application and attack other users of our application. 99.9% of the time, you're going to want to just use the `{{ ... }}` syntax and know that you are protected from any XSS vulnerability.

However, there may come a time when you are using a Rich Text field library or other HTML generating code and want the output of that code inserted into your page. That is possible by using `v-html` to indicate to Vue that you want a property of the component injected directly into the DOM of the application as HTML elements. Again, Vue will *not* protect you from XSS if you do this and you must be sure, through other means, that there is not malicious content in the data. You should never do this with content coming directly from a user.

We won't show an example in the order form, but you can use `v-html` in this way:

```HTML
<p v-html="rawHtmlContent"></p>
```

This will put whatever is in the `rawHtmlContent` property directly as children of this `p` tag. You should not have content in an element that has a `v-html` attribute because it will be overwritten anyway when the `v-html` is run.