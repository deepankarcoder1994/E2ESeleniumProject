package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {

	public WebDriver driver;

	By email = By.xpath("//input[@type='email']");
	By sendMeInstructions = By.xpath("//input[@name='commit']");

	// Creating Constructor
	public ForgotPassword(WebDriver driver) {
		this.driver = driver;
	}

	// Centralised getEmail() method which can be used in 100 test cases
	public WebElement getEmail() {
		return driver.findElement(email);
	}

	// Centralised getPassword() method which can be used in 100 test cases
	public WebElement sendMeInstructions() {
		return driver.findElement(sendMeInstructions);
	}

	
	
}
