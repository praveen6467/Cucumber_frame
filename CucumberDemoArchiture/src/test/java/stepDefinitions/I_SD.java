package stepDefinitions;

import java.util.List;
import java.util.Map;

import factory.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageObjects.I_POM;
import utilities.ExcelReaderUtility;



public class I_SD {
	
	
	I_POM obj = new I_POM(BaseClass.getDriver());
	
	List<Map<String, String>> testData;
	
	
	@Given("user Click on myAccountPage")
	public void user_click_on_my_account_page() {
	   
		obj.ClickMyAccount();
		obj.Clicklogin();
	}

	@When("User login with valid email {string}")
	public void user_login_with_valid_email(String string1) {
	    
		obj.SetEmail(string1);
	}

	@When("user enter valid password {string}")
	public void user_enter_valid_password(String string2) {
	  
		obj.SetPassword(string2);
	}

	@When("User Click on login")
	public void user_click_on_login() {
	   
		obj.ClickInnerLogin();
	}

	@Then("user move to my AccountPage")
	public void user_move_to_my_account_page() {
	  
		String  t1 =obj.getTextFrom();
		Assert.assertEquals("ok", "My Account", t1);
		System.out.println(t1);
		
	}
	
	
	///  Registration -2 --------------------------------->
	@Given("user navigates to the main page")
	public void user_navigates_to_the_main_page() {
	   
		System.out.println("main page open");
		
	}

	@When("user clicks on the My_Account button")
	public void user_clicks_on_the_my_account_button() {
	    obj.ClickMyAccount();
	}

	@When("user clicks on the Registration button")
	public void user_clicks_on_the_registration_button() {
	   obj.ClickRegister();
	}

	@Then("user should be redirected to the new registration page")
	public void user_should_be_redirected_to_the_new_registration_page() {
	   
		System.out.println("Redirected to RegistrationPage");
	}

	@When("user enters all required details in the registration form")
	public void user_enters_all_required_details_in_the_registration_form() {
	   
//		obj.setfirstname();
//		obj.setLastName();
//		obj.setEmail();
//		obj.SetTele();
//		obj.SetPass();
//		obj.SetConfirmPass();
//		
	}

	@When("user clicks on the Continue button")
	public void user_clicks_on_the_continue_button() throws InterruptedException {
	    obj.checkbtn();
	    obj.continuous();
	}

	@Then("user should be successfully registered and see a confirmation message")
	public void user_should_be_successfully_registered_and_see_a_confirmation_message() {
	   
		System.out.println("message");
	}

// Single Column 3 ----------------------------------------------->
	
	@Given("user enter to Resitration page")
	public void user_enter_to_resitration_page() {
	    
		obj.ClickMyAccount();
		obj.ClickRegister();
		
	}

	@When("user fill the form with data using SingleColumn")
	public void user_fill_the_form_with_data_using_single_column(DataTable dataTable) throws InterruptedException {
	   
		List<String> column=dataTable.asList(String.class);
		
		for(String fe:column)
		{
			
			obj.setfirstname(fe);
			Thread.sleep(1000);
			obj.setClear();
		}
		
		
	}

// single Column key-value
	@When("user fill form with singlerow keyvalues")
	public void user_fill_form_with_singlerow_keyvalues(DataTable dataTable) throws InterruptedException {
	   
		Map<String, String> Map =dataTable.asMap(String.class,String.class);
		
		obj.setfirstname(Map.get("FirstName"));
		obj.setLastName(Map.get("LastName"));
		obj.setEmail(BaseClass.randomAlphaNumeric()+"@gmail.com");
		obj.SetTele(BaseClass.randomeNumber());
		obj.SetPass(Map.get("Password"));
		obj.SetConfirmPass(Map.get("ConformPassword"));
		
		Thread.sleep(2000);
		obj.checkbtn();
		Thread.sleep(2000);
		obj.continuous();
		
		
	}

	// Mutliple Row
	@When("User fill with MultipleRows keyValue")
	public void user_fill_with_multiple_rows_key_value(DataTable dataTable) {
		
		List<Map<String, String>> maps =	dataTable.asMaps();
		
		for(Map<String, String> fes:maps)
		{
			String Fname=fes.get("FirstName");
			String Ltname=fes.get("LastName");
			String mail=fes.get("Email");
			
			obj.setfirstname(Fname);
			obj.setLastName(Ltname);
			obj.setEmail(mail);
			
		}
	   
	}


/*// Excel Reading Data
	@Given("User Pass TestData to TestCases")
	public void user_pass_test_data_to_test_cases() {
		
		obj.ClickMyAccount();
		obj.ClickRegister();
		
	    
	}

	
	
	@When("User read Data from ExcelSheet from {int} to {int} rows")
	public void user_read_data_from_excel_sheet_from_to_rows(Integer Start, Integer End) {
	   
		
		String filePath = "C:\\Users\\user\\git\\repository\\CucumberDemoArchiture\\testData\\TestData2.xlsx";
		String  sheetName = "Sheet1";
		
		testData=ExcelReaderUtility.getTestData(filePath, sheetName);
		
		
		for(int i= Start-1; i<End; i++)
		{
			Map<String, String> maped =testData.get(i);
			
			String name=  maped.get("Username");
			String pass= maped.get("Password");
		String role=	maped.get("Role");
			String q=  maped.get("Quality");
			
			
			obj.setfirstname(name);
			obj.setEmail(pass);
			
			
		}
		
		
	}*/

	


 }












