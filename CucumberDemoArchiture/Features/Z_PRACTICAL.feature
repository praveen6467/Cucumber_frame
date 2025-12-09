Feature: Login Fuctionality


# ----------> https://naveenautomationlabs.com/opencart/

@sanity
Scenario: User Login with valid Creditials
Given user navigate page and click on MyAccount with firstLoginButton
When Use passes valid Email "pavanoltraining@gmail.com" and PassWord "test@123"
And User Click on secondLoginButton
And User Click on AddressBook and NewAddress

@sanity
Scenario: User fill the Registration form using SingleColumn
Given User click on RegisterButton
When user Enter Firstname with SingleColum Datable
|Praveen|
|Sushma |
|Pavani | 

@sanity
Scenario: user Fill Form Using SingleRow KeyAndValuPair
Given user goes click on Registerbtn
When User fill with SingleRowKeyValue 
|FirstName |Praveen|
|LastName  |Sushma|
|Email     |pppppp@gamil.com|






 
#  Keep it in configure file  -->  https://opensource-demo.orangehrmlive.com/web/index.php/auth/login   
# --> NAvigate Method should be in BASEPAGE only for Good Practice 
 #@Frame
#Scenario:  switch to frame 
#Given  User switch to frame2
#When user send some message in text
#And User comeback from frame2


