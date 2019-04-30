# Data Binding Simple Attributes (45 Minutes)

One of the fundamental concepts to understand about component-based development is the idea of Data Binding. In traditional JavaScript, most DOM manipulation is done using the basic functions defined for `document` and `HTMLElement`s. A large number of lines of code are dedicated to just DOM manipulation in most JavaScript applications.

In all the various component-based frameworks, DOM manipulation is handled by the framework itself in the form of Data Binding. Data Binding is the method of linking a data attribute to a specific spot in the component's view.

In our `first-component` example, we did this with our header. To display a data attribute as text, we surround it with double curly brackets:

```HTML
<h1>{{message}}</h1>
```

The above code binds the message attribute of the component to the text inside the `<h1>` tag. What shows up in that area? What ever the value is that has been set to the message data attribute:

```JavaScript
data() {
    return {
        message: 'Our message from the first component'
    }
}
```

## Data Binding Demo

We're going to take a look at data binding in a component in the `data-binding` project. This project has a number of input fields that we're going to wire up to data attributes in our component.

First, let's add data elements to the component's object. We do that by adding a new data function that returns an object containing all the beginning data that the component will start with. This will live in the `<script>` tag of the component:

```JavaScript
export default {
    name: "user-management",
    data() {
        return {
            firstName: '',
            lastName: '',
            gender: '',
            disabled: false,
            permissions: [],
            role: '',
            notes: ''
        }
    }
}
```

This object lists all the data attributes and their default values. You will define all the component's data attributes in this function or else Vue will not be able to connect them to the data binding system.

> #### Why do the data attributes need to be returned from a function and not just defined as an object?
>
> We have to return an object that contains the data attributes because if there are two of a component mounted onto the same page, we want each component to have its own set of data attributes. If we just have an object defined here, those data attributes would be considered shared between both components, kind of like static variables in Java or C#. By having it be a function that creates the data attributes, each component will call that function and get separate data attributes that act more like instance variables.

Now that we have our data attributes, let's bind them to the view.

## What is Binding?

Binding in the above example means that whatever the value of the `message` data attribute is set to, that's what will show up in the `<h1>`. If the value is ever changed, the view will automatically update with the new value. The data attribute `message` and the `{{message}}` are bound together and will stay synced.

Using the `{{ dataAttribute }}` syntax is called a one-way data binding. Data from the data attribute is bound to the view.

Let's do that for our data attributes.

In the example component, there is a table at the very bottom that will show what data was entered in the form. None of that is linked up yet, so let's get the table to show the information for us.

We can do that with the data binding syntax from above. In each table cell, let's bind the display value of the cell to the data attribute.

```HTML
<tbody>
    <tr>
        <td>{{ firstName }}</td>
        <td>{{ lastName }}</td>
        <td>{{ gender }}</td>
        <td>{{ role }}</td>
        <td>{{ disabled }}</td>
        <td>{{ permissions }}</td>
        <!-- In order to see multiline text from the textarea, wrap in pre -->
        <td><pre>{{ notes }}</pre></td>
    </tr>
</tbody>
```

After saving this in your component you'll see a new row in the table that shows all the default values. These table cells are now data bound to the values in the component's data attributes.

## Data Binding with Input Elements

### `v-model` on Input Fields

We can also bind a data attribute to an input element using an attribute on the HTML elements called `v-model`. This style of data binding can be considered two-way data binding. We can do that with text input elements with the `v-model` syntax:

``` HTML
<input type="text" v-model="name"/>
```

This will tie the data attribute `name` to the value from this text field. If the value of `name` changes, the value in the input field will change. If the user types a new value in the text field, the value of `name` will update to match that value. The data is bound in both directions.

Let's do that now with the First Name and Last Name fields.

```HTML
<input type="text" name="firstName" id="firstName" v-model="firstName">
...
<input type="text" name="lastName" id="lastName" v-model="lastName">
```

By adding a `v-model` attribute to the input elements, we can bind these input fields to the data attributes specified. Now, whenever the value in the input element changes, the value in the data attribute is automatically updated. When that value is updated, the view in the table cell automatically updates. It's important to also note that if the data attribute value ever changes via some other method (like a function call or API call), then the text in the input box will automatically update to the new value also because the input box is two-way bound to the data attribute when we use `v-model`.

### `v-model` on radio buttons

We can also bind the radio buttons to a data attribute with `v-model`. Just bind all the radio buttons to the same data attribute:

```HTML
<input type="radio" name="gender" value="m" v-model="gender">
...
<input type="radio" name="gender" value="f" v-model="gender">
...
<input type="radio" name="gender" value="o" v-model="gender">
```

Now when a radio button is selected, the data attribute `gender` is updated to the value of that button.

### `v-model` on selects

To add a data binding to a select element, just add `v-model` on the `select` tag with the data attribute you want to bind to.

```HTML
<select name="role" v-model="role">
```

This will update the data attribute with the value from the `option` tag when a new option is selected.

> Vue states that it's good practice to make the first option disabled with a value of the empty string. If you don't, some mobile browsers won't allow a selection to be made by the user.

### `v-model` on single checkbox

You can add a model on a single checkbox to track if it is checked or not with a `true`/`false` value. Just don't give the checkbox a value and bind it to a data attribute with `v-model`.

``` HTML
<input type="checkbox" name="disabled" id="disabled" v-model="disabled">
```

If the box is checked, the data attribute `disabled` will be true. If it's unchecked, `disabled` will be false.

### `v-model` on multiple checkboxes

You can also use multiple checkboxes with values to bind to an array of values. Give each checkbox the same name but unique values. Then add `v-model` binding them to the same data attribute array.

You'll notice that we set up the `permissions` data attribute to default to an empty array. Let's bind that to the checkboxes for Extra Permissions.

``` HTML
<input type="checkbox" name="permissions" value="w" v-model="permissions">
...
<input type="checkbox" name="permissions" value="x" v-model="permissions">
...
<input type="checkbox" name="permissions" value="d" v-model="permissions">
```

As you check and uncheck the boxes now, you'll see those box's values being added and removed from the array.

It's very important that we initialize this data attribute as an empty array. If we didn't, Vue would have treated the value as a boolean and would have checked and unchecked all the boxes in the list. By initializing the value as an array, we told Vue that we want to treat the checkboxes as individual values that are part of a like group.

### `v-model` on textareas

Textareas work much like input text boxes. Let's link the `notes` data attribute to the Other Notes textarea.

``` HTML
<textarea name="notes" cols="60" rows="10" v-model="notes"></textarea>
```

Just like with a text box, edits to the textarea can be seen immediately in the table cell.

## `v-model` modifiers

There are some modifiers that we can add to `v-model` too.

### .lazy

If we add .lazy to a field, the data attribute won't be update as the user is typing, but will instead wait until the user has left the text field before updating. You can add this to the textarea like this.

``` HTML
<textarea name="notes" cols="60" rows="10" v-model.lazy="notes"></textarea>
```

Now the table cell won't update until you click out of the textarea.

### .number

You can add `.number` to `v-model` to tell it to save the value as a JavaScript number instead of as a string. This is useful for number input elements or anything that you know you'll want as a number and don't want to convert yourself. An example of this would be:

```HTML
<input type="number" name="age" id="age" v-model.number="age">
```

### .trim

You can remove any beginning or ending whitespace that a user might have typed in by putting `.trim` on `v-model`. We can add that to the `firstName` and `lastNames` text boxes.

``` HTML
<input type="text" name="firstName" id="firstName" v-model.trim="firstName">
...
<input type="text" name="lastName" id="lastName" v-model.trim="lastName">
```