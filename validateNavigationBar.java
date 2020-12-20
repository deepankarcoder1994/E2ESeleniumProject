package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

//Inheriting the class having the utility method
public class validateNavigationBar extends base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get("http://qaclickacademy.com");
	}

	@Test
	public void basePageNavigation() throws IOException, InterruptedException {
		
		// Accessing Landing Page Object Class and calling getTitle() method
		LandingPage l = new LandingPage(driver);
		// compare the text from browser with actual value with the help of Assertions.
		Assert.assertTrue(l.getNavigationBar().isDisplayed());
		log.info("Navigation bar is displayed");
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
