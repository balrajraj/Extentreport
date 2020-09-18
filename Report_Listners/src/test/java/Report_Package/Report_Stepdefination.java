package Report_Package;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Report_Stepdefination{
	
    
	WebDriver driver;
    
     
	   
    @Given("^user is on google form$")
	public void user_is_on_google_form() throws MalformedURLException{
		
	System.out.println("User is on Main form");	
		 
	if(Report_Runner.browser.equalsIgnoreCase("chrome")){
		   
		   WebDriverManager.chromedriver().setup();
		   driver = new ChromeDriver();
		   driver.get("https://www.google.com/");
	   }else{
		  		   
		   WebDriverManager.edgedriver().setup();
		   driver = new EdgeDriver();
		   driver.get("https://www.google.com/");
	   }
}	

	
	
		
		
//		//Linux code
//		WebDriverManager.chromedriver().setup();
//		
//		DesiredCapabilities cap = new DesiredCapabilities();
//		
//		cap.setBrowserName("chrome");
//		driver = new RemoteWebDriver(new URL("http://52.15.255.62:4444/wd/hub"),cap);
//				
//								
//		driver = new ChromeDriver();
//		
//		driver.get("https://www.google.com/");
	//}
	
	@When("^user types on the form$")
	public void user_types_on_the_form(){
		
		System.out.println("User types on the form");
	}
	
	@Then("^user validates the page title$")
	public void user_validates_the_page_title(){
		String expectedTitle = "Google";
		
		String actualTitle = driver.getTitle();
		
		Assert.assertEquals(actualTitle, expectedTitle);
			
	}
	
	@Then("^user gets the details of the search$")
	public void user_gets_the_details_of_the_search(){
		
		System.out.println("User entry in search text box");
	}
	@Before
	public void beforeScenario(Scenario scenario) {
	    Reporter.assignAuthor("ToolsQA - Lakshay Sharma");
	}
	
	@After(order=1)
	public void afterScenario(Scenario scenario) {
		
		if ((scenario).isFailed()) {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			
			try {
				//This takes a screenshot from the driver at save it to the specified location
				File sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				
				//Building up the destination path for the screenshot to save
				//Also make sure to create a folder 'screenshots' with in the cucumber-report folder
				File destinationPath = new File(System.getProperty("user.dir")+"\\target\\cucumber-reports\\"+screenshotName+".png");
				//Copy taken screenshot from source location to destination location
				Files.copy(sourcePath, destinationPath);   
				Reporter.addScreenCaptureFromPath(destinationPath.toString());

				//This attach the specified screenshot to the test
				
				//Reporter.addScreenCaptureFromPath(screenfile);
				
				
			} catch (IOException e) {
				
			}
			
			} 
		

}
	@After(order=0)
	public void teardown(){
		
		driver.quit();
	}
		
		
	}

	
	


