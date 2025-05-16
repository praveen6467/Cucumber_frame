package factory;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseClass {
	
	
	
	 static WebDriver driver;   // Here We Given As 'Static' So it Releated to 'CLASS' level 'Varaibles'
     static Properties p;
     static Logger logger;
	
     // 1)  This METHOD is A RETURNTYPE METHOD ,it's Return the 'WEBDRIVER" THATWHY 'WebDriver' infront of Method.
     public static WebDriver initilizeBrowser() throws IOException   
 	{
 		p = getProperties();        //***** Here 'getProperties ' "Return Method"  Name is ASSIGN to  'p'.
         String executionEnv = p.getProperty("execution_env");
         String browser = p.getProperty("browser").toLowerCase();
         String os = p.getProperty("os").toLowerCase();
 		
 		if(executionEnv.equalsIgnoreCase("remote"))
 		{
 			//**** For "Remote"   Environment i,e 'Grid evn' we Required the  "DesiredCapabilities" CLASS
 			DesiredCapabilities capabilities = new DesiredCapabilities();
 			
 			//os
 			 switch (os) {
              case "windows":
                  capabilities.setPlatform(Platform.WINDOWS);
                  break;
              case "mac":
                  capabilities.setPlatform(Platform.MAC);
                  break;
              case "linux":
                  capabilities.setPlatform(Platform.LINUX);
                  break;
              default:
                  System.out.println("No matching OS");
                  return null;
             }
 			//browser
			 switch (browser) {
             case "chrome":
                 capabilities.setBrowserName("chrome"); // .setBrowserVersion("window11")  
                 break;
             case "edge":
                 capabilities.setBrowserName("MicrosoftEdge");
                 break;
             case "firefox":
                 capabilities.setBrowserName("firefox");
                 break;
             default:
                 System.out.println("No matching browser");
                 return null;
             }
	       
	        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
			
		}
 		else if(executionEnv.equalsIgnoreCase("local"))
		{
			switch(browser.toLowerCase()) 
			{
			case "chrome":
		        driver=new ChromeDriver();
		        break;
		    case "edge":
		    	driver=new EdgeDriver();
		        break;
		    case "firefox":
		    	driver=new FirefoxDriver();
		        break;
		    default:
		        System.out.println("No matching browser");
		        driver=null;
			}
		}
 		 driver.manage().deleteAllCookies(); 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		 
		 return driver;         // Return Type IS WebDriver.
		 
 	}
	
     
    //  ******  After INTILLIZATION OF Driver ,  WE HAVE WRITE This 'METHOD'.
     public static WebDriver getDriver()     // This Method Will Return the Driver
     {
			return driver;
	  }
     
     
     //   It is a return type method THATWHY  "Properties" infront of MEthodName
     public static Properties getProperties() throws IOException     //** This Method will 'Opens' ,'Reads' and 'Loads'   the ConfigureFile.
 	{		 
         FileReader file=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
        	p=new Properties();
 		p.load(file);
 		return p ;      // **** Here  Rember 'Setter' and 'Getter' Method , Return is for 'Getter Method'  FOR "VARIABLE" Which ASSIGN at "ClassLevel" .
 	}  
     
     public static Logger getLogger() 
 	{		 
 		logger=LogManager.getLogger(); //Log4j
 		return logger;
 	}
 	
 	public static String randomeString()
 	{
 		String generatedString=RandomStringUtils.randomAlphabetic(5);
 		return generatedString;
 	}
 	
 	
 	public static String randomeNumber()
 	{
 		String generatedString=RandomStringUtils.randomNumeric(10);
 		return generatedString;
 	}
     
     
 	
		
	public static String randomAlphaNumeric()
	{
	String str=RandomStringUtils.randomAlphabetic(5);
	 String num=RandomStringUtils.randomNumeric(10);
	return str+num;
	}
	

	
	

}
