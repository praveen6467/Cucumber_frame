package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	
	WebDriver driver;  
	
	WebDriverWait wait;                                       // **  EXPLICITY waits 
    
	// Constructor
	   public BasePage(WebDriver driver)
	     {  
		     this.driver=driver;
		     
		     wait = new WebDriverWait(driver, Duration.ofSeconds(10));           // **  EXPLICITY waits 
		     
		     PageFactory.initElements(driver,this);
	     }

	   
	   //1)-------> This Aproach For  EXPLICITY WAIT  // ----> Wait Command Should be in BASEPAGE ONLY
	   
	   public void waitForElementToBeVisible(WebElement element) {
	        wait.until(ExpectedConditions.visibilityOf(element));
	    }

	    public void waitForElementToBeClickable(WebElement element) {
	        wait.until(ExpectedConditions.elementToBeClickable(element));
	    }

	    public void clickWhenReady(WebElement element) {
	        waitForElementToBeClickable(element);
	        element.click();
	    }
	   
	   
	    
	   
	}
