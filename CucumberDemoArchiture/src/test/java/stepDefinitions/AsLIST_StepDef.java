package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import pageObjects.AsList_POM;

public class AsLIST_StepDef {
	
	
	WebDriver driver ;
	AsList_POM   it ;
	
	
	
	
	
	@Given("user serach with below dable")
	public void user_serach_with_below_dable(DataTable dataTable) throws InterruptedException {
		
		it = new  AsList_POM (BaseClass.getDriver());
		
		
		// 1) Approach -1 "asList"
//		List<List<String>>   dt =dataTable.asLists(String.class);
//		it.setSearchBox(dt.get(1).get(1));      // **** Here index Start From '0' ,Zero.
	    
		
		// 2) Approach -2 "asMaps"
		
		 List<Map<String, String>>  maps =dataTable.asMaps(String.class, String.class);
		 it.setSearchBox(maps.get(1).get("keyword1") +" "+ maps.get(0).get("keyword2"));  // Second time get is in 'String' Format
		
		
		// 3) Approach-3 "asMaps" in 'ForEachLoop' 
		
//		List<Map<String, String>>  maps =dataTable.asMaps(String.class, String.class);
//		
//		for( Map<String, String>  fe : maps)
//		{
//			it.setSearchBox(fe.get("keyword1"));
//		}
		
		
		
	}

}










