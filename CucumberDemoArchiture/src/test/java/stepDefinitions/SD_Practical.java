package stepDefinitions;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BasePage;
import pageObjects.POM_Practical;

public class SD_Practical {
	
	WebDriver driver ;
	
	POM_Practical obj =new POM_Practical (BaseClass.getDriver());
	
	
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










