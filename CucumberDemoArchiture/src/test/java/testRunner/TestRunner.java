package testRunner;



import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
	               	features= {".//Features/Z_PRACTICAL.feature"},
					//features= {".//Features/Login.feature"},
				//	 features= {".//Features/asList.feature"},
				//	features= {".//Features/Registration.feature"},
		
					//features= {".//Features/LoginDDTExcel.feature"},
				//	features= {".//Features/Login.feature",".//Features/Registration.feature"},
					//features= {"@target/rerun.txt"},  // ** '@' is vmip, This Method is used only when you want to run Failed 'Scenarois' and 'rerun'.txt file update Automatically.
					glue={"stepDefinitions","hooks"},
					plugin= {
								"pretty", "html:reports/myreport.html",   
								"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
								"rerun:target/rerun.txt",    // This method need to Available all the time while executing the runner file
							
							},
							
					dryRun=false,    // checks mapping between scenario steps and step definition methods
					monochrome=true,    // to avoid junk characters in output
					publish=true  , // to publish report in cucumber server            // THIS IS FOR REPORT PURPOSE, It Show Link In 'REDBOX' so we can Share to TEAM. 
					//tags="@sanity"  // this will execute scenarios tagged with @sanity
					//tags="@regression"
					//tags="@sanity and @regression" //Scenarios tagged with both @sanity and @regression
					//tags="@sanity and not @regression" //Scenarios tagged with @sanity but not tagged with @regression
					tags="@sanity or @regression" //Scenarios tagged with either @sanity or @regression
				//	tags = "@Frame"
		)


public class TestRunner {
	
}
