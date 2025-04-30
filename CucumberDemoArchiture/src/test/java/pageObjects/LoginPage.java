package pageObjects;



import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
	
	
	// ****** ERROR come if you not Specified 'Constroctor' HERE  in  POM :---> 
	//error is ----->Implicit super constructor BasePage() is undefined for default constructor. Must define an explicit constructor
	
	public LoginPage(WebDriver driver) {     // *****  HERE we can Write Any 'WebDriver' Variable i,e "pdriver"  it not related to Any thing
		super(driver); 
	} 

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtEmailAddress;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtPassword;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement btnLogin;


	public void setEmail(String email) {
		txtEmailAddress.sendKeys(email);
	}

	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}

	public void clickLogin() {
		btnLogin.click();
		

   }



}









