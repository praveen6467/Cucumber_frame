package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.POM_Practical;

public class SD_Practical {
	
	WebDriver driver ;
	
	POM_Practical obj =new POM_Practical (BaseClass.getDriver());
	HomePage   obj2 = new  HomePage(BaseClass.getDriver());
	AccountRegistrationPage obj3 = new AccountRegistrationPage(BaseClass.getDriver());
	
	
	@Given("user is on the login page")
	public void user_is_on_the_login_page() {
	   
		
		
	//	obj = new POM_Practical (BaseClass.getDriver());
		obj.ClickOnMyAccount();
		obj.ClickOnLogin();
		
	}

	@When("user logs in with username {string} and password {string}")
	public void user_logs_in_with_username_and_password(String mail, String pass) {
	    
		obj.EnterEmail(mail);
		obj.EnterPassword(pass);
		
	}

	@Then("user should be logged in successfully")
	public void user_should_be_logged_in_successfully() {
	   
		obj.ClickInsideLogin();
	}

	
	// Scenario Outline
	 
	@When("user enter {string} and {string}")
	public void user_enter_and(String mail, String paswword) throws InterruptedException {
	    
		obj.EnterEmail(mail);
		obj.EnterPassword(paswword);
		
		Thread.sleep(2000);
		
		obj.ClickInsideLogin();
	}
	

//	@Then("user should be logged succesfully and my Accout page Should be open")
	public void user_should_be_logged_succesfully_and_my_accout_page_should_be_open() {
	   
		String Actual=obj.GetText();
	
		Assert.assertEquals(Actual, "My Account");
		
	}
	
	//  1)  filling form  ***Single Column to Step in Feature file
	
	@Given("user navigate registion form")
	public void user_navigate_registion_form() {
	    
		obj2.clickMyAccount();
		
		obj2.clickRegister();
		
	}

	@When("user fill form with data")    // **** Single Column to Step in Feature file
	public void user_fill_form_with_data(DataTable dataTable) throws InterruptedException {
	List<String> dt  =	dataTable.asList(String.class);
	for(String fe :dt)
	{
		obj3.setFirstName(fe);
		
		obj3.clickContinue();
		Thread.sleep(2000);
		
		obj3.setFirstNameClear();
	}
	
/*	obj3.setFirstName(dt.get(0));
	Thread.sleep(2000);
	obj3.clickContinue();
	obj3.setFirstNameClear();
	
	Thread.sleep(2000);
	obj3.setFirstName(dt.get(1));
	Thread.sleep(2000);
	obj3.clickContinue();
	obj3.setFirstNameClear();  */
	
	
}
	
	// Filling with SingleRow Key And Value Pair

	@Given("user navigate registration form")
	public void user_navigate_registration_form() {
	    
       obj2.clickMyAccount();
		
		obj2.clickRegister();
		
	}

	@When("user fill form with data in singleRow key and value")
	public void user_fill_form_with_data_in_single_row_key_and_value(DataTable dataTable) {
	   
		  Map<String,String> map =dataTable.asMap(String.class,String.class);
		
		obj3.setFirstName(map.get("Firstname"));
		obj3.setLastName(map.get("lastname"));
		  obj3.setEmail(BaseClass.randomAlphaNumeric()+"@gmail.com");
		  obj3.setTelephone(map.get("telenphone"));
	}

// Filling Mutiple row with Key And Value Pair
	
	@Given("user navigate registration form with mutiplrows")
	public void user_navigate_registration_form_with_mutiplrows() {
	   
obj2.clickMyAccount();
		
		obj2.clickRegister();
		
		
	}

	@When("user fill form with data in MutipleRows key and value")
	public void user_fill_form_with_data_in_mutiple_rows_key_and_value(DataTable dataTable) throws InterruptedException {
	    
		List<Map<String, String>> Maps =dataTable.asMaps();
		
		for(Map<String,String> fe:Maps)
		{
			String names =fe.get("Firstname");
			String Lastnames=fe.get("LastName");
			
			
			obj3.setFirstName(names);
			
			
			Thread.sleep(4000);
			obj3.setFirstNameClear();
			
			obj3.setLastName(Lastnames);
			
			Thread.sleep(2000);
			
			System.out.println(names);
			System.out.println(Lastnames);
		}
		
	}



	
	
	
	
	//-----------------Frame Performed in Pom-----------------------
	@Given("User switch to frame2")
	public void user_switch_to_frame2() {
	    obj.EnterToFrame2();
	}

	@When("user send some message in text")
	public void user_send_some_message_in_text() {
	    obj.TextSomeMessage();
	}

	@When("User comeback from frame2")
	public void user_comeback_from_frame2() {
	    obj.ComeBackFromFrame();
	}



}










