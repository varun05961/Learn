Feature: How to book ride in uber
As i am user
i want to book ride 
so that i reach my location

Background:
Given User launches Uber app


Scenario Outline:
And Enter mobile number to login
And Click on Submit button
And Enter OTP for verification
And User able to lgin into the app
And User lands on Home page
And Enter location <name> on search bar
When User choose ride option
Then Rider accept user booking 
And Ride booked

Examples:
|name |
|Mohali|
