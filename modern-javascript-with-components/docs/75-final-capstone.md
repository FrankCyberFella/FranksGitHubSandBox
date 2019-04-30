# Final Capstone Project

> Note::This Project Verifies Learning
>
> This is a project to let the students feel as if they have a grasp on the concepts before leaving to go back to their jobs. Encourage them to ask questions and explore options as they work through it. Have them decide whether they want to try the parent/child model or the Vuex model and encourage them to experiment while you are there in the class room with them.
>
> Stay in the class room and work until it seems like everyone feels they have a pretty good handle on the material. Let them know they can leave whenever but that you'll stick around if they have any questions and thank them for coming to the training. Send the final class email either later that day or the next day.

> Note::Pre-set up for assignment
>
> Go to https://www.mockapi.io/ and set up a new endpoint for the class. Create a `users` resource and then set it's data to the JSON in the notes folder called `user-data-for-final-capstone-api.json`. Give the URL of that resource to the students by sending it to them or writing it on the board.

In order to solidify everything that was learned, we're going to build a complex web site using component-based development. We will be revisiting the user management application but adding new features to it. You can either base your project on that one or create a new project from scratch to practice all the aspects of component-based development in Vue.

We will be pulling data from an online API. If you're using a Parent component, you can call this API from a `created()` section in your component so that the API and data is loaded when the component starts up. If you're using the data store model of development, one of the sub components should call an `action` in the data store when it is created.

Try to implement the following features and think about what component the feature should live in or if a new component is in order.

1. Show the users in a table
2. Allow filtering of the users by first name and last name
3. Add sorting to the table by its various columns
4. Allow adding a new user to the table (and synced with the back-end API using a POST)
5. Allow editing a user (and synced with the back-ent API using a PUT)
6. Allow deleting a user (and synced with the back-end API using a DELETE)
7. Add paging to the table to only show 10 users at a time
8. Create a view that allows the users to be shown as "cards" or in divs on the screen

> Note::How these should be handled
>
> 1. This is like the existing UserTable component
> 2. This is like the existing UserFilter component
> 3. This is something that can be added to UserTable that sets data in the data store to tell it how to sort the users on the computed or getter method
> 4. This is like the existing NewUser component
> 5. This would be a new component that would reference an `edittingUser` property in the data store or parent with a link added to the UserTable component to set the user there. Once saved, an action would be called on the data store to save the user to the API.
> 6. This would be a link in the UserTable component that would call an action method on the data store to remove the user from the array and call the API.
> 7. This would be added to the UserTable and update values in the data store to set what page you are currently on
> 8. This would be a new component that mimicked the input and output of the UserTable component