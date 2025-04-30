package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AsList_POM  extends BasePage{

	// 1) Constructor
	public AsList_POM (WebDriver driver)
	{
		super(driver);
	}
	
	
	// 2)  
	
	@FindBy(xpath="//textarea [@id='APjFqb']")
	WebElement Search;
	
	
	// 3) 
	public void setSearchBox (String SearchBox) throws InterruptedException
	{
		Search.clear();
		Thread.sleep(2000);
		Search.sendKeys(SearchBox,Keys.ENTER);
		
		
		
		
	}
	
	
	
	
}
