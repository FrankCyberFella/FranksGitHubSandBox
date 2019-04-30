# Client-Side Programming Mini-Capstone

Apply the following rules to the LexCorp Employment Application form using jQuery validation and JavaScript.

Job Posting
-
Display appropriate "description" based upon the selected posting. Hide all others.

"*" Starred Fields
-
All starred fields are required.

Phone
-
All phone numbers must follow the format: [9+ ]999-999-9999.

Optional phone numbers may be blank.

SSN (Social Security Number)
-
SSN must follow the format: 999-99-9999.

Email Address
-
All email addresses must "reasonably" follow the expected format: my.name@hostname.tld.

Optional email addresses may be blank.

State
-
State must be a valid State abbreviation.

Zip Code
-
All zip codes must follow the format: 99999[-9999]

Date
-
All dates must follow the format: mm/dd/yyyy

Employment Information
-
Can you work: Checking/unchecking All, checks/unchecks WeekEnds and Evenings.

Available: Checking/unchecking All, checks/unchecks all days.

Question 1:
> 
No - Show subsequent "can you provide proof of eligibility" question
Yes - Hide subsequent "can you provide proof of eligibility" question

Question 2:
>
No - Hide "Please provide dates and location"
Yes - Show "Please provide dates and location"

Question 3:
>
No - Disable radio buttons and hide textfield of Question 4
Yes - Enable radio buttons and hide textfield of Question 4

Question 4: (If Radio buttons are enabled)
>
No - Show "If no,please explain"
Yes - Hide "If no, please explain"

Question 6:
>
No - Hide "If yes, please explain"
Yes - Show "If yes, please explain"

Question 7:
>
No - Hide "If yes, please explain"
Yes - Show "If yes, please explain"

Question 8:
>
No - Hide "If yes, please explain"
Yes - Show "If yes, please explain"

Question 9:
>
No - Hide "If yes, state name and relationship"
Yes - Show "If yes, state name and relationship"

Employer
-
Write event handlers for +, -, up, and down buttons.
>
'+'		expands the employer, and makes all fields visible<br/>
'-'		contracts the employer, and hides all fields<br/>
'up'	moves the employer above another<br/>
'down'	moves the employer below another

Reference
-
Write event handlers for +, -, up, and down buttons.
>
'+'		expands the reference, and makes all fields visible<br/>
'-'		contracts the reference, and hides all fields<br/>
'up'	moves the reference above another<br/>
'down'	moves the reference below another

At least one of the optional fields: Address, Telephone, or Email Address, must be provided for each Reference given.

Additional Work
-
Break the form into multiple local sections:

* Job Posting, Personal, and Current Address
* Employment Information
* Employer(s)
* References(s)

Using jQuery and JavaScript, add Next and Previous buttons to the page, and display only one of the logical sections at a time. The Next and Previous buttons will allow users to navigate between sections while remaining on the same page.

As an added challenge, add tabs for each of the sections using Bootstrap, providing users an alternative means of navigating between sections.
