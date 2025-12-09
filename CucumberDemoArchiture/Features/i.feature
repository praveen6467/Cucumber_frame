Feature:  Practicing all Cucumber FrameWork Components


@sanity
Scenario:  User open MyAccountPage
Given user Click on myAccountPage
When User login with valid email "pavanoltraining@gmail.com"
And user enter valid password "test@123"
And User Click on login
Then user move to my AccountPage 


#@sanity
Scenario: Successful user registration
    Given user navigates to the main page
    When user clicks on the My_Account button
    And user clicks on the Registration button
    Then user should be redirected to the new registration page
    When user enters all required details in the registration form
    And user clicks on the Continue button
    Then user should be successfully registered and see a confirmation message

@sanity
Scenario: Susceffuly fill the form Using SingleColumn by DataTable
Given user enter to Resitration page
When user fill the form with data using SingleColumn
|Praveen|
|padigam|
|kumar|


@sanity
Scenario: fill form with singleRow key_value
Given user enter to Resitration page
When user fill form with singlerow keyvalues
|FirstName|Praveen|
|LastName|Padigam|
|Password|GM12*#pk|
|ConformPassword|GM12*#pk|


@sanity
Scenario: fill form with MultipleRow Key Value
Given user enter to Resitration page
When  User fill with MultipleRows keyValue
|FirstName |LastName|Email|
|Praveen|kumar|pravven@gamil.com|
|Anil|rudh|anil@gami.com|
|Akhila|praveen|akhila@gmail.com|



#@Frame
#Scenario: User Read TestData from ExcelSheet
#Given User Pass TestData to TestCases
#When User read Data from ExcelSheet from 1 to 5 rows














