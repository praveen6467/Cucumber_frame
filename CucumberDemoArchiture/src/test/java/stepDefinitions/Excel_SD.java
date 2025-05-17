package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import utilities.ExcelReaderUtility;
//import utils.ExcelReader;

public class Excel_SD {
	
	
	WebDriver driver;
	
	HomePage  hmp = new HomePage(BaseClass.getDriver());
	AccountRegistrationPage  ActReg = new AccountRegistrationPage(BaseClass.getDriver());
	
	List<Map<String, String>> testData;
	
	
	@Given("user loads the excel test data")
	public void user_loads_the_excel_test_data() {
	    
		hmp.clickMyAccount();
		hmp.clickRegister();
		
	}

	@When("user performs login for rows {int} to {int}")
	public void user_performs_login_for_rows_to(Integer startRow, Integer endRow) throws InterruptedException 
	{
	   
		
		String filePath = "C:\\Users\\user\\git\\repository\\CucumberDemoArchiture\\testData\\TestData2.xlsx";
        String sheetName = "Sheet1";
        testData = ExcelReaderUtility.getTestData(filePath, sheetName);
        
        
        for (int i = startRow - 1; i < endRow; i++) 
        {
            Map<String, String> data = testData.get(i);
            String username = data.get("Username");
            String password = data.get("Password");
            String Role   = data.get("Role");

            System.out.println("Login Attempt [" + (i+1) + "]: " + username + " | " + password + " | " + Role);


            ActReg.setFirstName(username);
         //   Thread.sleep(2000);
            ActReg.setLastName(password);
        //    Thread.sleep(2000);
            ActReg.setEmail(Role);
         //   Thread.sleep(2000);

            // Optionally validate login outcome here
        }
		
		
	}

	
	

	
	//  ***** SCENARIO OUTLINE

	List<Map<String, String>> testDataList;
	
	@Given("user performs login for row number {int}")
	public void user_performs_login_for_row_number(Integer rowNum) throws InterruptedException 
	{
	   

		String filePath = "C:\\Users\\user\\git\\repository\\CucumberDemoArchiture\\testData\\TestData2.xlsx";
        String sheetName = "Sheet1";
        testDataList = ExcelReaderUtility.getTestData(filePath, sheetName);
        
        
      Map<String, String> data = testDataList.get(rowNum - 1);     // ****** Here There is no FORLOOP

       
           
            String username = data.get("Username");
            String password = data.get("Password");
            String Role   = data.get("Role");

         

            System.out.println("Login Attempt [Row " + rowNum + "]: " + username + " | " + password + " | " + Role);
            


            ActReg.setFirstName(username);
            Thread.sleep(2000);
            ActReg.setLastName(password);
            Thread.sleep(2000);
            ActReg.setEmail(Role);
            Thread.sleep(2000);

            // Optionally validate login outcome here
        

		
	}
	
}







