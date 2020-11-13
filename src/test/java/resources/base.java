package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class base {
	
	public WebDriver driver;
	public Properties prop;
	

public WebDriver initializeDiver() throws IOException	
{	//chrome


 prop=new Properties();

FileInputStream fis = new FileInputStream("/Users/gracevallu/eclipse-workspace/E2Eframeworkproject/src/test/java/resources/data.properties");


prop.load(fis);
  String browserName= prop.getProperty("browser");
if(browserName.equals("chrome"))
{
	System.setProperty( "webdriver.chrome.driver", "//Users//gracevallu//Downloads//chromedriver");
   
	driver =new ChromeDriver();
	
	//execute chrome driver
	
	} 
else if(browserName=="firefox") {
	
}
  
driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
return driver;


}

public  String getScreenShortPath(String testcaseName,WebDriver driver) throws IOException {
	
	TakesScreenshot ts=(TakesScreenshot) driver;
  File source= ts.getScreenshotAs(OutputType.FILE);
  String destinationFile = System.getProperty("user.home")+"/eclipse-workspace/E2Eframeworkproject/reports/"+testcaseName+".png";
  System.out.println(destinationFile);
FileUtils.copyFile(source, new File(destinationFile));


return destinationFile;

}












}