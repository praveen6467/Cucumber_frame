Feature: Login functionality with Excel data for specific rows


Background: 
Given user loads the excel test data

 @sanity
  Scenario: Login with selected data rows from Excel
    
    When user performs login for rows 1 to 5
    
    
   @sanity 
 Scenario Outline: Login with selected data rows from Excel for ScenarioOutline
   
    And user performs login for row number <RowNumber>
    
    Examples:
   | RowNumber|
   |          7|
   |          9|
   |          10|
  
  