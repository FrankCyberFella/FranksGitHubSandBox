# Chai Assertion Library

## Commonly used assertions:

### `equal`

Asserts that the target is strictly equal (`===`) to the parameter value.

```javascript
(1).should.equal(1);
'one'.should.equal('one');
'1'.should.equal(1); // fails
```

### `false`

Asserts that the target is strictly equal (`===`) to `false`.

```javascript
false.should.be.false;
(1 == 2).should.be.false;
'false'.should.be.false; //fails
true.should.be.false; //fails
```

### `true`

Asserts that the target is strictly equal (`===`) to `true`.

```javascript
true.should.be.true;
(1 == 1).should.be.true;
'true'.should.be.true; //fails
false.should.be.true; //fails
```

### `not`

Negates all assertions that follow in the chain.

```javascript
'abc'.should.not.contain('d');
{a: 1}.should.not.have.property('b');
[1, 2].should.be.an('array').that.does.not.include(3);
'Tech Elevator'.should.not.contain('Tech'); //fails
```

### `include`, `includes`, `contain`, `contains`

_The `include` assertion and it's three aliases, `includes`, `contain`, and `contains` can be used interchangeably. Use whichever one makes your assertion the most readable._

#### Strings

When the target is a string, `.include` asserts that the string provided as a parameter is a substring of the target.

```javascript
'foobar'.should.include('foo');
'foobar'.should.include('fizz'); //fails
```

#### Arrays

When the target is an array, `.include` asserts that there is an array element that is strictly equal (`===`) to the parameter value.

```javascript
[1,2,3].should.include(2);
[1,2,3].should.include(4); //fails
```

#### Maps

When the target is a Map, `.include` asserts that the parameter value is one of the values of the target Map. `SameValueZero` equality algorithm is used.

```javascript
let toppings = new Map([['topping1', 'mushrooms'],
                        ['topping2','onions'],
                        ['topping3','peppers']]);

toppings.should.include('onions');
toppings.should.include('anchovies'); //fails
toppings.should.include('topping2'); //fails (not a value)
```

#### Other Uses

The `.include` assertion can be used for other types as well (e.g. Objects, Sets, etc). See the Chai Assertion Library documentation for more details.

Because `.include` does different things based on the target’s type, it’s important to check the target’s type before using `.include`. See the `.a` doc for info on testing a target’s type.

```javascript
[1, 2, 3].should.be.an('array').that.includes(2);
```

### `keys`

`keys` will verify that a given map or array has the given key or keys set in them. `any` and `all` can be used in conjunction with `keys` to verify keys.

`all` will tell `keys` that a given object or array must have all the specified keys (an AND logic check).

``` JavaScript
// All tests pass
{a: 1, b: 2}.should.have.all.keys('a', 'b');
['x', 'y'].should.have.all.keys(0, 1);

{a: 1, b: 2}.should.have.all.keys(['a', 'b']);
['x', 'y'].should.have.all.keys([0, 1]);
```

Use `any` to see if the given object or array has at least one of the given keys (an OR logic check).

``` JavaScript
// All tests pass
{a: 1, b: 2}.should.have.any.keys('a', 'c');
['x', 'y'].should.have.any.keys(0, 10);

{a: 1, b: 2}.should.have.any.keys(['d', 'b']);
['x', 'y'].should.have.any.keys([20, 1]);
```

`key` can be used in place of `keys` to improve readability.

### `deep`

`deep` will tell assertions to use deep equality checks, useful for verifying the structure of arrays and objects in JavaScript. By default, Chai will only check to see if two values or equal, but for reference types, you want to see if the values they contain are equal. Deep checking the value will do that for you.

``` JavaScript
{a: 1}.should.equal({a: 1}); // fails, objects are not the same object
{a: 1}.should.deep.equal({a: 1}); // passes, objects contain the same values
```

## Improving readability:

Chai provides "language chains" that can be used to improve the readability of your assertions. These are simply chainable getters that have no functional effect but can be used to make your assertions appear more like natural English language.

### Chains

- `to`
- `be`
- `been`
- `is`
- `that`
- `which`
- `and`
- `has`
- `have`
- `with`
- `at`
- `of`
- `same`
- `but`
- `does`

## Further Reading

There are many more assertions provided by Chai and can be found here: http://www.chaijs.com/api/bdd/

Be aware that the documentation is written in Expect style while our code is written in Should style. The assertions after the `expect().to` will be exactly the same in both.



