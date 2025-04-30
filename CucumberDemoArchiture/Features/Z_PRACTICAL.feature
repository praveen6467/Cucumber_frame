Feature: Account Login 

# ----------> https://naveenautomationlabs.com/opencart/
@sanity
Scenario: User logs in with valid credentials
    Given user is on the login page
    When user logs in with username "padigampraveen6467@gmail.com" and password "GM12*#pk"
    Then user should be logged in successfully



#  Keep it in configure file  -->  https://opensource-demo.orangehrmlive.com/web/index.php/auth/login   
# --> NAvigate Method should be in BASEPAGE only for Good Practice 
@Frame
Scenario:  switch to frame 
Given  User switch to frame2
When user send some message in text
And User comeback from frame2
