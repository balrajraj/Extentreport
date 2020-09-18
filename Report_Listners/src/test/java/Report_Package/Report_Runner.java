package Report_Package;

import java.io.File;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import manager.FileReaderManager;

@CucumberOptions(
		features ="src/test/java/Report_Package/report.feature", 
		glue={"Report_Package"}, 
	    monochrome = true, 
		strict = true, 
		dryRun = false,
		plugin ={ "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}
				
		)

public class Report_Runner extends AbstractTestNGCucumberTests{
	
	 public static String browser;
//	   private TestNGCucumberRunner testNGCucumberRunner;
//
//	    @BeforeClass(alwaysRun = true)
//	    public void setUpClass() throws Exception {
//	        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
//	    }
//
//	    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
//	    public void feature(CucumberFeatureWrapper cucumberFeature) {
//	        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
//	    }
//
//	    /**
//	     * @return returns two dimensional array of {@link CucumberFeatureWrapper} objects.
//	     */
//	    @DataProvider(parallel=true)
//	    public Object[][] features() {
//	        return testNGCucumberRunner.provideFeatures();
//	    }
//
//	    @AfterClass(alwaysRun = true)
//	    public void tearDownClass() throws Exception {
//	        testNGCucumberRunner.finish();
//	    }

	@Parameters("browser")
	@BeforeTest
	public void beforeSuite(String browser) {
        System.out.println("Browser for this test set is " + browser);
        this.browser = browser;
    }
	
	
	
    @AfterClass(alwaysRun = true)
    public void writeExtentReport() throws Exception {
    	
    			   	    	
    	
    	Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
    	    	
    	
    	
        
    }	

}



