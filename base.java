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
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

/*
 * Designed one Common Utility to Initialise a Driver.
 */

public class base {

	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {
		// Code to connect the java code to properties file and extract some of the
		// properties.
		// Global env lectures Section 21
		prop = new Properties();
		//System.getProperty("user.dir");
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");

		prop.load(fis);
		//mvn test -Dbrowser=chrome
		
		//String browserName = System.getProperty("browser");
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);
		//Cannot use == operator when you are extracting a value from a properties file else you will get NPE exception.
		//Using equals() method
		if(browserName.equals("chrome")) {
			//execute in chrome Driver
			System.setProperty("webdriver.chrome.driver", "D:\\Personal_docs\\chromedriver.exe");
			//Headless state execution 
			//ChromeOptions options = new ChromeOptions();
			//options.addArguments("headless");
			driver = new ChromeDriver();
			
		}else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\Personal_docs\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		//Implicit wait concept studied in section 10 Synchronization
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//returning the driver Object so that the caller of this method can use the above property which were set
		return driver;
	}

	public String getScreenshotPath(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));

		return destinationFile;
	}

}
