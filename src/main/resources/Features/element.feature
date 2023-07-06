Feature: Verify that user is able to submit details
As i am a user 
i am able to enter data in fields
so that i m submit my details


Background:
Given user launches google chrome browser in windows 10
And enter url "https://demoqa.com/text-box"

Scenario Outline:
When i enter data in the fields
And enter data name <Full name> , email address<Email> , address <Current address> , Paddress<Permanent address>
And click on "submit" button
Then success message appears

Examples:
|  name       | |Email            | |address| |  Paddress    |
| Varun sharma| |test@yopmail.com | | Mohal | | Ambala cantt |     


