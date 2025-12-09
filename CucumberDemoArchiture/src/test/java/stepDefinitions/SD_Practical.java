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
	
	POM_Practical obj = new POM_Practical(BaseClass.getDriver());
	
	@Given("user navigate page and click on MyAccount with firstLoginButton")
	public void user_navigate_page_and_click_on_my_account_with_first_login_button() {
	    
		obj.ClickMyAccount();
		obj.ClickOnFirstLogin();
	}

	@When("Use passes valid Email {string} and PassWord {string}")
	public void use_passes_valid_email_and_pass_word(String mail, String pass) {
	   obj.SetEmail(mail);
	   obj.SetPassword(pass);
		
	}

	@When("User Click on secondLoginButton")
	public void user_click_on_second_login_button() {
	  obj.ClickOnSecondLogin();
	
	}

	@When("User Click on AddressBook and NewAddress")
	public void user_click_on_address_book_and_new_address() {
		
		obj.ClickOnAddressBook();
		obj.acceptLoginAlert();
		obj.ClickOnNewAddress();
	    
	}

	// Registration
	
	
	@Given("User click on RegisterButton")
	public void user_click_on_register_button() {
	   obj.ClickMyAccount();
		obj.RegisterButton();
	}

	@When("user Enter Firstname with SingleColum Datable")
	public void user_enter_firstname_with_single_colum_datable(DataTable dataTable) {
	   
		List<String > l=dataTable.asList(String.class);
		
		for(String fe:l)
		{
			obj.FirstName(fe);
			
		}
	}

	// Single Row KeyAnd Value Pair
	
	@Given("user goes click on Registerbtn")
	public void user_goes_click_on_registerbtn() {
		 obj.ClickMyAccount();
			obj.RegisterButton();
		
	}

	@When("User fill with SingleRowKeyValue")
	public void user_fill_with_single_row_key_value(DataTable dataTable) {
	    
		Map<String,String> map=dataTable.asMap(String.class,String.class);
		
		obj.FirstName(map.get("FirstName"));
		obj.LastName(map.get("LastName"));
		
		
	}

	
	
	
}










