package Academy.E2Eframeworkproject;

import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.Landingpage;
import pageobjects.Loginigpage;
import resources.base;

public class HomePage extends base {
	public WebDriver driver;
	
	
	public static  Logger log=LogManager.getLogger(base.class.getName());

	
	
	@Test(dataProvider = "getData")

	public void basePageNavigation(String username, String password) throws IOException, InterruptedException {
		driver = initializeDiver();
		driver.get("http://www.qaclickacademy.com/");

		// one is we can use inheritance
		// creating object to that class and invoke methods of it

		Landingpage l = new Landingpage(driver);
		// l.getLogin().click();
		l.getLogin().click();// driver.findElement(By.css()
		Loginigpage lp = new Loginigpage(driver);

		lp.getEmail().sendKeys(username);
		lp.getpassword().sendKeys(password);
		log.info("text");
		Thread.sleep(5000);
		lp.getLogin().click();
		
		
		  
		
		
// System.out.println("text");

	}

//Row stand for how many diffrent data types test should run
//colum stand for how many values per each test
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[1][2];

//0th row
		data[0][0] = "grace@qaclick.com";
		data[0][1] = "kiru";

		return data;
	}
	
	@AfterTest
	  public void teardown() {

	 driver.close();
	
	  }

}
