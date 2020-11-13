package Academy.E2Eframeworkproject;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.Landingpage;
import resources.base;

public class validateTitle extends base {
	
	
	public WebDriver driver;
	
public static  Logger log=LogManager.getLogger(base.class.getName());

@BeforeTest
	
	public void initialize() throws IOException {
	
	driver = initializeDiver();
	log.info("Driver is initialized");
	
	
	driver.get(prop.getProperty("url"));
	
	log.info("Navigated to Home page");
	
	}


		
	@Test
	public void basePageNavigation() throws IOException {
		driver = initializeDiver();
		driver.get("http://www.qaclickacademy.com/");

		// one is we can use inheritance
		// creating object to that class and invoke methods of it

		Landingpage l = new Landingpage(driver);
		//compare thetext from the browser with actual text... Error
		
		AssertJUnit.assertEquals(l.getTitle().getText(),"FEATURED COURSES");
		
		log.info("Successfully validted text message");
		
		
	
	}



}
