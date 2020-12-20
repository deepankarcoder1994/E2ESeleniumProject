package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;

	By email = By.xpath("//input[@type='email']");
	By password = By.xpath("//input[@type='password']");
	By Login = By.xpath("//input[@value='Log In']");

	// Optimising page object Implementation
	By forgotPassword = By.cssSelector("[href*='password/new']");

	// Creating Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// Centralised getEmail() method which can be used in 100 test cases
	public WebElement getEmail() {
		return driver.findElement(email);
	}

	// Centralised getPassword() method which can be used in 100 test cases
	public WebElement getPassword() {
		return driver.findElement(password);
	}

	// Centralised Login() method which can be used in 100 test cases
	public WebElement getLogin() {
		return driver.findElement(Login);
	}

	// Optimising page object Implementation
	public ForgotPassword forgotPassword() {
		driver.findElement(forgotPassword).click();
		return new ForgotPassword(driver);
	}
}
