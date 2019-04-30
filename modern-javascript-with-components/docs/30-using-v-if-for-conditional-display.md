# Using `v-if` for Conditional Display (20 Minutes)

In many JavaScript applications, we want to show or hide a section of the screen based on data the user has or hasn't input. Many times this is accomplished with the `display:` CSS class.

Vue has a keyword for this already built into the framework. We can add a `v-if` attribute to any element in the template to get this effect. The value of `v-if` is tied to a data attribute or a JavaScript expression and tells the component whether to show the HTML element or not.

We can add this to our component to decide whether to show or not show the billing address. If the checkbox that's labeled "Also use for billing address" is checked, we want to hide the billing address fields. If it's not checked, we want to show the billing address fields.

That checkbox is data bound to the `sameAddress` data attribute, so we can look there to see whether or not we want to show the fieldset for the billing address. So let's add a `v-if` to that fieldset:

``` HTML
<fieldset v-if="! sameAddress">
    <legend>Billing Address</legend>
```

`v-if` takes a JavaScript expression stating that if the `sameAddress` data attribute is *not* checked, then show the Billing Address fieldset. If you inspect the DOM after checking this button, you'll see that that fieldset isn't hidden or set invisible, it is completely removed from the DOM.

## Hiding Elements using `v-show`

If you don't want the elements to be removed, but just want them to be hidden but still on the page, you can use `v-show` instead. It works exactly the same way, but will toggle the display of the element rather than remove it from the page.

``` HTML
<fieldset v-show="! sameAddress">
    <legend>Billing Address</legend>
```

## Unit Testing for `v-if`

We will need to unit test to make sure the `v-if` is working the way we expect. We can do that by setting the data attribute to a value and then seeing if the element is there or not. Let's add that to a unit test file for OrderForm:

```JavaScript
it('should hide fieldset when sameAddress is true', () => {
    wrapper.setData({'sameAddress': true});
    wrapper.find('#billingAddress').exists().should.be.false;
});

it('should show fieldset when sameAddress is false', () => {
    wrapper.setData({'sameAddress': false});
    wrapper.find('#billingAddress').exists().should.be.true;
});
```