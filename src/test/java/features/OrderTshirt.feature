Feature: To order the T-shirt and updating the personal information


#Background:
#Given Launch the chrome browser
#And Load the url
#When Click on Sign in button 
#And Enter the username as MonishaB@example.com
#And Enter the password as Password123
#Then Page should be signed with your name
@smoke 
Scenario: TC001_OrderTshirt
Given Click TShirts link
When Click on Faded short sleeve tshirt 
When Click on Add to Cart
And Click on Procced to checkout
When Click on Procced to checkout in summary page
When Click on Procced to checkout in Address page
When Click on checkbox Terms of Service in shipping page
When Click on Procced to checkout in shipping page
When Click on Pay by bank wire
When click on I confirm my order
When click on the customer account
And Click on order history
And Click on Details
Then Product name should be displayed

@functional
Scenario: TC002 _Updating personal information

Given Click on profile name
And Click on Personal information
And Enter First Name
And Enter Current Password
And Enter New password
And Enter Confirmation Password
When Click on save button
Then Account Name should be updated






