Feature: Account Login 

# ----------> https://naveenautomationlabs.com/opencart/

Background: 
 Given user is on the login page


#@sanity
Scenario: User logs in with valid credentials
     When user logs in with username "padigampraveen6467@gmail.com" and password "GM12*#pk"
    Then user should be logged in successfully


#@sanity
Scenario Outline: user login with mutiple creditential
    When user enter "<Email>" and "<password>"
#    Then user should be logged succesfully and my Accout page Should be open

Examples:  
|Email                         | password  |
| naresh                       | 1234       |
|padigampraveen6467@gmail.com  | GM12*#pk   |


#@sanity
Scenario: User fill the form with creditendials
Given user navigate registion form 
When user fill form with data
| Praveen |
|Padigam |
|Kumar  |


#@sanity
Scenario: User fill the form with SingleRow Key and Value 
Given user navigate registration form
When user fill form with data in singleRow key and value
|Firstname | john |
|lastname  | Paul |
| telenphone |  91| 


@sanity
Scenario: User fill the form with MutipleRow Key and Value 
Given user navigate registration form with mutiplrows
When user fill form with data in MutipleRows key and value
|Firstname | LastName | telephone   |
|Praveen  | Padigam   | 9989453214  |
| Anil    | Rudh     | 99          |



 
#  Keep it in configure file  -->  https://opensource-demo.orangehrmlive.com/web/index.php/auth/login   
# --> NAvigate Method should be in BASEPAGE only for Good Practice 
 #@Frame
#Scenario:  switch to frame 
#Given  User switch to frame2
#When user send some message in text
#And User comeback from frame2


