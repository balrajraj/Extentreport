package Report_Package;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Report_Extent {
	static ExtentReports extent;
	
	
	public void takeScreenShot(String testCasename, WebDriver driver) throws IOException{
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		File source  = ts.getScreenshotAs(OutputType.FILE);
		
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCasename+".png";
		
		FileUtils.copyDirectory(source, new File(destinationFile));
	}

	public static ExtentReports getReportObject(){
		
		String path = System.getProperty("user.dir")+"\\reports\\ExtentReport.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Google Automation");
		reporter.config().setDocumentTitle("Google Test Result");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Balraj U");
		
		return extent;
		
		
		
		}
	
	public String getReportConfigPath(){
		Properties properties = new Properties(); 		
		String reportConfigPath = properties.getProperty("reportConfigPath");
		if(reportConfigPath!= null) return reportConfigPath;
		else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");		
	}
		
		
		


}
