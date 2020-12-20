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
public class validateTitle extends base {
	public WebDriver driver;

	LandingPage l;

	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();

		log.info("Driver is Initialized");

		driver.get("http://qaclickacademy.com");

		log.info("Navigated to HomePage");
	}

	@Test
	public void basePageNavigation() throws IOException, InterruptedException {
		// Accessing Landing Page Object Class and calling getTitle() method
		l = new LandingPage(driver);
		// compare the text from browser with actual value with the help of Assertions.
		Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES");
		log.info("Successfully validated Text Message");
	}

	//Multiple Test Cases in One Browser.
	@Test
	public void validateHeader() throws IOException, InterruptedException {
		// compare the text from browser with actual value with the help of Assertions.
		Assert.assertEquals(l.getHeader().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
	}

	@AfterTest
	public void tearDown() {
		driver.close();
		driver=null;
	}

}
