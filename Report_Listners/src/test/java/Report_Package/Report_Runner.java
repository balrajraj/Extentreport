package Report_Package;

import java.io.File;
import java.sql.Driver;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import manager.FileReaderManager;

@CucumberOptions(
		features ="src/test/java/Report_Package/report.feature", 
		glue={"Report_Package"}, 
	    monochrome = true, 
		strict = true, 
		dryRun = false,
		plugin ={ "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}
				
		)

public class Report_Runner extends AbstractTestNGCucumberTests  {
	
	
    @AfterClass(alwaysRun = true)
    public void writeExtentReport() throws Exception {
    	
    			   	    	
    	
    	Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
    	
    	
    	
    	
        
    }	

}



