Feature: Verify that user is able to add item in the cart
As i am user
I want to add item in the cart 
so that i can purchase product

Background:
Given User lauches google chrome browsers in window 10
And Enter url "https://www.flipkart.com/account/login?ret=/"

@function_add_to_cart
Scenario Outline: add item in the cart
When User enter login credentials username & passsword
And click on submit button
And click on mobile <Mobilename>
And User click to "add to cart" button
Then Item should appears in cart

Examples:
|Mobilename|
|iphone 14 |


