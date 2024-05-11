package TechVerito.TestNGRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions( features="src/test/java/TechVerito/cucumber2", 
       glue="TechVerito.StepDefination2", monochrome=true ,  
            plugin= {"html:target/cucumber.html"})

public class TestNGRunner extends AbstractTestNGCucumberTests{

	
}
