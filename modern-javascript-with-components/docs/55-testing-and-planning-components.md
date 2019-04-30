# Documenting and Testing Components (60 Minutes)

After planning out our components, it would be good to document them in comments in the actual component. Sadly, there is no standard way at the moment to document Vue components, but there is a draft specification that uses standard JSDoc comments to document. We'll look at that with the understanding that there may be a more standard way of handling in component documentation in the future.

## Documenting the Component

You can add comments about what the component is about right above the `export default` line. Just type `/**` and then type in a description of what your component is about. This should just be a description here. We'll get into commenting the interface later.

### Documenting Input Props

Go down to the `props` section to document the input properties that your component is expecting. Above each property name, add `/**` and add a description for that. Describe what it does and how it's used.

Then add another line in that comment that starts with `@property`. Next comes the data type of the property, surrounded by curly brackets, followed by the name and then a short description of it. It will look something like this:

``` JavaScript
/**
 * @property {string} search the search query entered by the user
 */
```

### Documenting Output Custom Events

You document events with a comment block right above the `this.$emit` call. You want to give a description of the event and also document what the data is that is being returned in the event. We'll add a number of annotations to the comment to do this.

The first is `@event` which documents the name of the event.

Next is `@type` which documents what the data type of the value is that is included in the event. In our example, it's an object.

Then we add a number of `@property` tags to document the structure of the data being returned by the event. These can be nested to document the nested structure of the object.

That would look like the following for our SearchBox `search-results` event:

``` JavaScript
/**
 * Contains search results as an object with `Results` that is
 * an array of objects.
 * @event search-results
 * @type {object}
 * @property {array} Results The results of the search from the API
 * @property {string} Results.Make_ID The primary key of the car make
 * @property {string} Results.Make_Name The name of the car make
 * @property {string} Results.Mfr_Name The name of the car manufacturer
 */
this.$emit('search-results', results);
```

You can document more of the component than that, but this will give future developers good documentation on how these inputs and outputs can be used.

## Testing the Component

Unit testing a component that talks to other components is actually straightforward. Since the component shouldn't know that about the other components, testing in isolation is already built in.

### Unit Testing Inputs

Testing inputs is as easy as setting properties on the component in the test and then making sure that it does the correct thing.

Let's set up a unit test for the ResultsDisplay component. Create a new file under `/tests/unit` called `ResultsDisplay.spec.js`. We'll need to add our boilerplate unit testing code to this:

``` JavaScript
import ResultsDisplay from '@/components/ResultsDisplay.vue';
/* eslint-disable-next-line no-unused-vars */
import { shallowMount, Wrapper } from '@vue/test-utils';

import chai from 'chai';
chai.should();

describe('ResultsDisplay', () => {
  /** @type Wrapper */
  let wrapper;
  beforeEach( () => {
    wrapper = shallowMount(ResultsDisplay);
  });

});
```

Now we can add a test. Let's test to make sure that an object given to the `results` property is properly displayed in the table.

``` JavaScript
it('should display table of information from searchResult prop', () => {
    wrapper.setProps({
        'results': {
            'Results': [
                {
                'Make_ID': 0,
                'Make_Name': 'TEST',
                'Mfr_Name': 'MFRTEST'
                }
            ]
        }
    });

    let cells = wrapper.findAll('table tr td');
    cells.at(0).text().should.equal('0');
    cells.at(1).text().should.equal('TEST');
    cells.at(2).text().should.equal('MFRTEST');
});
```

### Unit Testing Outputs

Unit testing outputs brings up a new topic that we haven't looked at yet. That's how to we test for events from a component. The testing framework does have this built in to it.

Let's create a new unit test file for SearchBox called `SearchBox.spec.js`:

``` JavaScript
import SearchBox from '@/components/SearchBox.vue';
/* eslint-disable-next-line no-unused-vars */
import { shallowMount, Wrapper } from '@vue/test-utils';
import fetchMock from 'fetch-mock';

import chai from 'chai';
chai.should();

describe('SearchBox', () => {
  /** @type Wrapper */
  let wrapper;
  beforeEach( () => {
    wrapper = shallowMount(SearchBox);
  });

  before( () => {
    fetchMock.config.overwriteRoutes = true;
  });

});
```

Now we need to set the prop for the URL, set data on the search property and mock the API call.

``` JavaScript
  it('should send results when performSearch is called', (done) => {
    fetchMock.get('*', { 'Results': 'TEST' });

    wrapper.setProps({ searchUrl: 'http://test.mock/' });
    wrapper.setData({ search: 'TEST' });
```

Then call performSearch and make sure it emits the data as an event that we told the fetch mock to send back.

``` JavaScript
    wrapper.vm.performSearch().then(() => {
      let data = wrapper.emitted('search-results');
      // Get the first event of that type and it's first parameter
      data[0][0].Results.should.equal('TEST');
      done();
    });
```

Remember that we are once again working with an asynchronous call so we have to take the Promise returned from the method and put our assertions into a new `then()` call. But once that `then()` executes, we should have an emitted event, which we can get through a call on the wrapper.

When calling `emitted()` on the wrapper, we give it an event name and it will give us all the data that was submitted with those events. There could have been more than one event triggered during the test, so the data is given back as a two dimensional array. The first index is which event this is--we're only expecting one, so the index is 0--and the second is the data that was given with that event--again, we only are expecting the one object, so the index is 0 again. If you need to test for multiple events of the same type, you'll have to go through the array and verify that you got all the ones you were expecting.