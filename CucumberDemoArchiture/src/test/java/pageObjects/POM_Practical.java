 package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;



public class POM_Practical extends BasePage  {
	
	
public  POM_Practical (WebDriver driver)
{
	super(driver);
}
	
	
@FindBy(xpath="//span[normalize-space()='My Account']") WebElement MyAccount;

@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//li//a[text()='Login']") WebElement LoginRegister  ;
@FindBy(xpath="//input[@id='input-email']") WebElement Email  ;
@FindBy(xpath="//input[@id='input-password']") WebElement   Password  ;
@FindBy(xpath="//input[@value='Login']") WebElement Login  ;
@FindBy(xpath="//h2[normalize-space()='My Account']") WebElement   MyAccountPageDisplay ;
@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']") WebElement  LogOut  ;
@FindBy(xpath="//a[normalize-space()='Continue']") WebElement  ContinueLogOut ;
@FindBy(xpath="//a[normalize-space()='Address Book']") WebElement AddressBook;
@FindBy(xpath="//a[normalize-space()='New Address']") WebElement NewAddress;




// Action Methods of POM

public void ClickMyAccount(){
	MyAccount.click();
	}

public void ClickOnFirstLogin(){
	LoginRegister.click() ;
	}


public void SetEmail(String pEmail)   { Email.sendKeys(pEmail); }
public void SetPassword(String pPassword)  { Password.sendKeys(pPassword);}

public void ClickOnSecondLogin()
{
	waitForElementToBeClickable(Login);
	
	Login.click();
	
	
	}
public void ClickLogOut() 
{ 
	clickWhenReady(LogOut);
	
	LogOut.click();
}

public boolean MyAccountDispaly()
{
	
	try
	{
		return (MyAccountPageDisplay.isDisplayed());
	}
	catch(Exception e)
	{
		return(false);
	}
}


public void ClickOnContinuoeLogOut()
{
	ContinueLogOut.click();
}

public void ClickOnAddressBook()
{ 
	clickWhenReady(AddressBook);
AddressBook.click(); 
}

public void ClickOnNewAddress () 
{ 
	waitForElementToBeClickable (NewAddress);
	NewAddress.click();
	}
	
	
	// Alert
public String getLoginAlertMessage() {
    return getAlertText(); // Reuse from BasePage
}

public void acceptLoginAlert() {
    acceptAlert(); // Reuse from BasePage
}


//  Register form 
@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//li//a[text()='Register']") WebElement  Register  ;
@FindBy(xpath="//input[@id='input-firstname']") WebElement FirstName;
@FindBy(xpath="//input[@id='input-lastname']") WebElement LastName;
@FindBy(xpath="//input[@id='input-email']") WebElement EmailRE;

public void RegisterButton() {Register.click(); }
public void FirstName (String fname) {FirstName.sendKeys(fname);};
public void FirstNameCLEAR () {FirstName.clear();}
public void LastName (String Lname) {LastName.sendKeys(Lname );}


		   
}















