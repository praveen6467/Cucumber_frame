package utils;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;



public class ConfigReader {
	
	
	
	
	Properties properties;
	private static final String CONFIG_FILE_PATH=".\\src\\test\\resources\\config.properties";    
	
	 
	// ** This Is Constructor Just it load the ConfigFile
	  public ConfigReader() {
	        properties = new Properties();
	        try (FileInputStream fileInputStream = new FileInputStream(CONFIG_FILE_PATH)) {
	            properties.load(fileInputStream);
	        } catch (IOException e) {
	            e.printStackTrace();
	            throw new RuntimeException("Failed to load config.properties file");
	        }
	    }
	
	  
	  
	  // ** To read Values from Key in ConfigFile we use this Method, But it Return only Values in "String" Formate Only .
	  // -- This method is used when the Values we want in String Formate.
	  public String getProperty(String key)
	  {
		  return properties.getProperty(key);
	  }
	
	  // ** To read Values from Key in ConfigFile we use this Method, But it Return only Values in "String" Formate Only .
	  //-- When we want OtherThan String Formate we go with this Method .(i,e for int,double etc )
	  public int getIntProperty(String key)
	  {
		  return Integer.parseInt(properties.getProperty(key));
	  }

	

}
