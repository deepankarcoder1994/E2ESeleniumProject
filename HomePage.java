package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

//Inheriting the class having the utility method
public class HomePage extends base {
	private WebDriver driver;
		
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
	}


	@Test(dataProvider = "getData")
	public void basePageNavigation(String username, String password)
			throws IOException, InterruptedException {
		driver.get("http://qaclickacademy.com");
		// Accessing Landing Page Object Class and calling login() method
		LandingPage l = new LandingPage(driver);
		//Optimizing Page Object feature.Here you are having 2 pages but you are Initiating 
		//only once.
		LoginPage lp=l.getLogin();
		lp.getEmail().sendKeys(username);
		lp.getPassword().sendKeys(password);
		//System.out.println(text);
		/*  Thread.sleep(4000);*/
	//	log.info(text);
		lp.getLogin().click();
		
		//Optimising page object Implementation.Extending our test case even further.
		ForgotPassword fp =lp.forgotPassword();
		fp.getEmail().sendKeys("deepankar@gmail.com");
		fp.sendMeInstructions().click();
	}

	// Parameterizing the Tests with Multiple data with TestNg
	@DataProvider
	public Object[][] getData() {
		// Rows stands for how many different data types test should run.
		// Columns stands for how many values per each test
		
		Object[][] data = new Object[2][2];

		// 1st Test Data
		data[0][0] = "nonrestricteduser@qw.com";
		data[0][1] = "123456";
		//data[0][2] = "nonrestricteduser User";

		// 2nd Test Data
		data[1][0] = "restricteduser@qw.com";
		data[1][1] = "456789";
		//data[1][2] = "Restricted User";

		return data;
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
