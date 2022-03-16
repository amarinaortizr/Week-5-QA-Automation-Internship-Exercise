package basic.pom;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage extends Base {
	
	//By id locators
	By userLocator = By.id("userName");
	By passLocator = By.id("password");
	By signInBtnLocator = By.id("login");
	By homePageLocator = By.id("userName-value");
	
	
	public LogInPage(WebDriver driver) {
		super(driver);
	}
	
	//log in with user and password
	public void logIn(){						
		if(isDisplayed(userLocator)) {
			type("marinaortiz",userLocator);
			type("Marinaortizqa1!",passLocator);
			WaitForElementClickable(signInBtnLocator);
			click(signInBtnLocator);
		} else {
			System.out.println("username textbox was not present");
		}
		assertEquals("marinaortiz",getTextDisplayed(homePageLocator)); //check the user
	}
	
	
	
}
