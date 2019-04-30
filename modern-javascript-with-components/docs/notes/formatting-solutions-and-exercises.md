# Formatting Solutions and Exercises

## Install `RexReplace`

`npm install -g rexreplace`

## Copy the projects in `src` to `exercises` folder

`cp -r src/data-binding exercises/data-binding`

## Get rid of comment sections for exercises

```
rr '\\s*<!-- Start remove -->[\\S\\s]+?<!-- End remove -->\\s*' '' exercises/*/**.vue
rr '\\s*// Start remove[\\S\\s]+?// End remove\\s*' '' exercises/*/**.vue
rr '\\s*// Start remove[\\S\\s]+?// End remove\\s*' '' exercises/*/**.js
```

## Copy the projects in `src` to `solutions` folder

`cp -r src/data-binding solutions/data-binding`

## Get rid of comments but keep solution code

```
rr '\\s*<!-- Start remove -->\\s*' ' ' solutions/*/**.vue
rr '\\s*<!-- End remove -->\\s*' '' solutions/*/**.vue
rr '\\s*// Start remove\\s' '\n' solutions/*/**.vue
rr '\\s*// End remove\\s?' '\n' solutions/*/**.vue
rr '\\s*// Start remove\\s' '\n' solutions/*/**.js
rr '\\s*// End remove\\s?' '\n' solutions/*/**.js
```