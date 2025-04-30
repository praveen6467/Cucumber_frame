package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;



public class POM_Practical extends BasePage  {
	
	
	// Constructor 
//	public POM_Practical (WebDriver driver)
//	{
//		super(driver);
//	}
	
	public POM_Practical(WebDriver driver) {     // *****  HERE we can Write Any 'WebDriver' Variable i,e "pdriver"  it not related to Any thing
		super(driver); 
	} 
	// WebElements
	   @FindBy(xpath="//span[normalize-space()='My Account']")  WebElement MyAccountBtn;
	  
	   
	   @FindBy(xpath="//a[normalize-space()='Login']") WebElement Login;
	                                                    
	   
	   @FindBy(xpath="//input[@id='input-email']") WebElement EmailText;
	   
	   @FindBy(xpath="//input[@id='input-password'] ") WebElement PasswaordText;
	   
	   @FindBy(xpath="//input[@value='Login']")  WebElement LoginBtn;
	
	   
	  //  Actions 

	   
	   public void ClickOnMyAccount()
	   {
		   waitForElementToBeClickable(MyAccountBtn);
		   MyAccountBtn.click();
	   }
	   
	   public void ClickOnLogin()
	   {
		   clickWhenReady(Login);
		   
/*		   waitForElementToBeClickable(Login);      // Instead of this We write above
		   Login.click();   */
	   }
	   
	   public void EnterEmail(String emailvalue )
	   {
		   waitForElementToBeVisible(EmailText);
		   EmailText.sendKeys(emailvalue);
	   }
	   
	   public void EnterPassword(String pass)
	   {
		   PasswaordText.sendKeys(pass);
	   }
	   
	   public void ClickInsideLogin()
	   {
		   LoginBtn.click();
	   }
	   
	   
//-------------Frame Performed in POM with driver ----------------------------------
	   
	   
	   @FindBy(xpath="//frame[@src='frame_2.html']") WebElement Frame2;
	   
	   
	   @FindBy(xpath="//input[@name='mytext2']") WebElement text;
	   
	   
	 public void EnterToFrame2()
	 {
		 driver.switchTo().frame(Frame2);
	 }
	
	 public void TextSomeMessage ()
	 {
		 text.sendKeys("Selenuim Java");
	 }
	 
	 
	 public void ComeBackFromFrame()
	 {
		 driver.switchTo().defaultContent();
	 }
	   
}















