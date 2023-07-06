Feature: Verify that student is able to submit form.
As i m user 
i am able to sumbit form
so that i can register in it.

Background:
Given User is able to launch google chrome browser in window 10.
And Enter Url "https://demoqa.com/automation-practice-form"


@UI
Scenario Outline: verify the student registration form
When user enter "<Name>" , "<Lastname>" , "<Email>"
|FirstName| |LastName|  |Email|
|Varun|     |Sharma|    |varun05961@yopmail.com|
And  click on gender as "Male"
And Enter mobile number as""
And Enter "<Subject>","<Hobbies>","<date>" and "<Address>"
And Upload the picture
And Select state as "Haryana" and city as "Delhi"
And Click on "Submit" button
Then User should register successfully in the portal.

Examples:
|Subject| |Hobbies| |Date|          |Address| 
|Hindi  | |Music|   |04 july,2023|  |Ambala|