package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//import org.openqa.selenium.WebDriver;

public class I_POM extends BasePage {
	
	// Constructor
	public I_POM (WebDriver driver)
	{
		super(driver);
	}

	
	// Locators  for Login 1
//	@FindBy(xpath="") WebElement
	@FindBy(xpath="//span[normalize-space()='My Account']") WebElement MyAccountBtn;
	@FindBy(xpath="//a[normalize-space()='Register']") WebElement Register;
	@FindBy(xpath="//a[normalize-space()='Login']") WebElement login;
	@FindBy(xpath="//input[@id='input-email']") WebElement Email ;
	@FindBy(xpath="//input[@id='input-password']") WebElement Password;
	@FindBy(xpath="//input[@value='Login']") WebElement  InnerLogin;
	@FindBy(xpath="//h2[text()='My Account']") WebElement myAccountDisplay;
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']") WebElement logOut;
	
	  // Avtions Methods
	
	public void ClickMyAccount()
	{
		waitForElementToBeClickable(MyAccountBtn);
		
		MyAccountBtn.click();
	}
	 public void ClickRegister()
	  {
		  Register.click();
	  }
	public void Clicklogin()
	{
		login.click();	
	}
	
	public void SetEmail(String email)
	{  waitForElementToBeVisible(Email);
		Email.sendKeys(email);
	}
	
	public void SetPassword(String pwd)
	{
		Password.sendKeys(pwd);
	}
	
	 public void ClickInnerLogin()
	 {
		 InnerLogin.click(); 
	 }
	 
	 public String getTextFrom()
	 {
		 try {
		String text = myAccountDisplay.getText();
		return text;
		 }
		 catch(Exception e)
		 {
			 return("not present");
		 }
	 }
	 
	
	 public boolean logoutDispaly()
	 {
		 try
		 {
			return (logOut.isDisplayed());
		 }
		 catch(Exception e)
		 {
			 return(false);
		 }
	 }
	 
	 
	 // Registration 2
	// Elements
				@FindBy(name = "firstname")
				WebElement txtFirstname;

				@FindBy(name = "lastname")
				WebElement txtLasttname;

				@FindBy(name = "email")
				WebElement txtEmail;

				@FindBy(name = "telephone")
				WebElement txtTelephone;

				@FindBy(name = "password")
				WebElement txtPassword;

				@FindBy(name = "confirm")
				WebElement txtConfirmPassword;

				@FindBy(name = "agree")
				WebElement chkdPolicy;

				@FindBy(xpath = "//input[@value='Continue']")
				WebElement btnContinue;

				@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
				WebElement msgConfirmation;
			
				
				
				public void setfirstname(String firstname)
				{
					waitForElementToBeVisible(txtFirstname);
					
					txtFirstname.sendKeys(firstname);
				}
				
				public void setClear()   // Extra method to clearField
				{
					waitForElementToBeVisible(txtFirstname); 
					txtFirstname.clear();
				}
				
				public void setLastName(String LastName)
				{
					txtLasttname.sendKeys(LastName);
				}
				public void setEmail(String mail)
				{
					txtEmail.sendKeys(mail);
				}
				
				public void SetTele(String tel)
				{
					txtTelephone.sendKeys(tel);
				}
				public void SetPass(String pass)
				{
					txtPassword.sendKeys(pass);
				}
				public void SetConfirmPass(String ConfirmPass)
				{
					txtConfirmPassword.sendKeys(ConfirmPass);
				}
				public void checkbtn() throws InterruptedException
				{
					//Thread.sleep(2000);
					chkdPolicy.click();
				}
				public void continuous() throws InterruptedException
				{  // Thread.sleep(2000);
					btnContinue.click();
					
				}
				
				
				
				
				
				
	  
}
