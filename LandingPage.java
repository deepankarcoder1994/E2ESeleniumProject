package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;

	private By signin = By.cssSelector("a[href*='sign_in']");
	// Featured Courses Text is present or not in Landing Page.
	private By title = By.xpath("//div[@class='text-center']/h2");
	//Checking Navigation bar
	private By Navbar = By.xpath("//div[@role='navigation']");
	
	private By header = By.cssSelector("div[class*=banner] h3");
	
	

	// Creating Constructor
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	// Centralised getLogin() method which can be used in 100 test cases
	public LoginPage getLogin() {

		driver.findElement(signin).click();
		LoginPage lp = new LoginPage(driver);
		return lp;
	}

	public WebElement getTitle() {

		return driver.findElement(title);
	}
	
	public WebElement getNavigationBar() {
		
        System.out.println("Trying to identify navigation bar");
		return driver.findElement(Navbar);	
	}
	
public WebElement getHeader() {
		
        
		return driver.findElement(header);	
	}
}
