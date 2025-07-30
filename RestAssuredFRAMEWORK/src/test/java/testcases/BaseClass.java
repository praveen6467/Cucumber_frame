package testcases;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.List;

import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import routes.Routes;
import utils.ConfigReader;

import io.restassured.response.Response;
import java.util.List;

public class BaseClass {

	// To Read configFile we Required on Class i,e 'ConfigReader' in utils package  it will load config file and have some Methods. 
	//--And to Read methods Which Present in configFileReader class we Have to Maintain another Class 
ConfigReader configReader;       // ---> Here we created Object for 'ConfigReader' Class  which will Open and Load config.file



//For logging
RequestLoggingFilter requestLoggingFilter;
ResponseLoggingFilter responseLoggingFilter;
	
	@BeforeClass
	public void setup() throws FileNotFoundException
	{
		RestAssured.baseURI=Routes.BASE_URL;      //***** To Make 'Base_url' consistant we have use one Interface Called 'RestAssured'
		
		 configReader=new ConfigReader(); // // ---> Here we created Object for 'ConfigReader' Class  which will Open and Load config.file
		 
		 
		// Setup filters for logging // **** Below Method Are used to 'LOG the ConsoleOutput' into SeperateFolder called log
		    FileOutputStream fos = new FileOutputStream(".\\logs\\test_logging.log");
		    PrintStream log = new PrintStream(fos, true);
		    
		    requestLoggingFilter = new RequestLoggingFilter(log);
		    responseLoggingFilter = new ResponseLoggingFilter(log);
		    
		    RestAssured.filters(requestLoggingFilter, responseLoggingFilter);

		 
	}
	
	
	
	
	// Helper method to check if a list is sorted in descending order
    
			 boolean isSortedDesceding(List<Integer> list)
			{
				for(int i=0;i<list.size()-1;i++)
				{
					if(list.get(i)<list.get(i+1))
					{
					return false;	
					}
				}
				return true;
			}
			
				// Helper method to check if a list is sorted in asceding order
			    
			 boolean isSortedAsceding(List<Integer> list)
			{
				for(int i=0;i<list.size()-1;i++)
				{
					if(list.get(i)>list.get(i+1))
					{
					return false;	
					}
				}
				return true;
			}

	// 3) This AI Generate Method helper Method
			 
			 
			 
			 public static void verifyIdsAreInAscendingOrder(Response response) {
				    List<Integer> idList = response.jsonPath().getList("id");

				    for (int i = 0; i < idList.size() - 1; i++) {
				        if (idList.get(i) > idList.get(i + 1)) {
				            throw new AssertionError("IDs are not in ascending order at index " + i +
				                                     ": " + idList.get(i) + " > " + idList.get(i + 1));
				        }
				    }

				    System.out.println("IDs are in ascending order.");
				}
		 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 

}
