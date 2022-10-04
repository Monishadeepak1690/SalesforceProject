package runner;

 
import Steps.BaseClass;
import io.cucumber.testng.AbstractTestNGCucumberTests;
	import io.cucumber.testng.CucumberOptions;
	import io.cucumber.testng.CucumberOptions.SnippetType;


	@CucumberOptions(features= "src/test/java/features", 
						glue={"Steps"}, 
						monochrome =true,
						publish = true,
						tags="@smoke or @functional")
						
						
	public class RunTest extends BaseClass {
		

	}


	