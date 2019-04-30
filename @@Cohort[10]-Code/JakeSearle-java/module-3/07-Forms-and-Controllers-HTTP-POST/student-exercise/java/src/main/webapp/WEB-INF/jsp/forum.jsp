<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<section id="cigarReviews">


	<h1 id="title">Squirrel Cigar Parties for Dummies Review Page</h1>

	<form action="forum" method="POST">
		<div id="forumInput">
			<div id="cigarForumUser">
				<label for="UserName">Username:</label> <input type="text"
					name="username" id="username"
					placeholder=" Please enter your username" />
			</div>
			<div id="cigarForumRating">
				<label for="Rating">Rating:</label> <input type="text"
					name="rating" id="rating" placeholder=" Please enter your rating out of 5" />
			</div>
			<div id="cigarForumSub">
				<label for="Title">Subject:</label> <input type="text"
					name="title" id="title" placeholder=" Please enter a subject" />
			</div>
			<div id="cigarForumMessage">
				<label for="Message">Message:</label> <input type="text"
					name="text" id="text"
					placeholder=" Please enter your message" />
			</div>
			<div id="button-one">
				<label for="button"></label> <input class="formSubmitButton"
					type="submit" value="Submit" />
			</div>
		</div>
	</form>


</section>