package basic.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
	
	public WebDriver driver;
	public static WebDriverWait objExplicitWait;
	
	public Base(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver chromeDriverConnection() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
	}
	
	public WebElement findElement(By locator) {
		return driver.findElement(locator);
	}
	
	public void type(String inputText, By locator) {
		driver.findElement(locator).sendKeys(inputText);
	}
	
	public String getText(By locator) {
		return driver.findElement(locator).getText();
	}
	
	public void click(By locator) {
		driver.findElement(locator).click();
	}
	
	public void visit(String url) {
		driver.get(url);
	}
	
	public Boolean isDisplayed(By locator) {
		try {
			return driver.findElement(locator).isDisplayed();
		}catch(Exception e) {
			return false;
		}
	}
	
	public void AcceptAlert() {
		WebDriverWait wait = new WebDriverWait(Login_Test.driver, 3000);
	    wait.until(ExpectedConditions.alertIsPresent());
	   	Alert alert = Login_Test.driver.switchTo().alert();
	   	alert.accept();
	 }

	public String GetAlertText() {
    	WebDriverWait wait = new WebDriverWait(Login_Test.driver, 3000);
    	wait.until(ExpectedConditions.alertIsPresent());
    	String alertMessage = Login_Test.driver.switchTo().alert().getText();
    	return alertMessage;
    }
	
	public void WaitForElement(final By pstrLocator) {
    	objExplicitWait = new WebDriverWait(driver, 10);
    	objExplicitWait.until(ExpectedConditions.presenceOfElementLocated(pstrLocator));
    }
    
	
    public void WaitForElementClickable(final By pstrLocator) {
    	objExplicitWait = new WebDriverWait(driver, 10);
    	objExplicitWait.until(ExpectedConditions.presenceOfElementLocated(pstrLocator));
    	objExplicitWait.until(ExpectedConditions.elementToBeClickable(pstrLocator));
    }
    
    public String getTextDisplayed(By pstrLocator) {
		WaitForElement(pstrLocator);
		if(isDisplayed(pstrLocator)) {
			return getText(pstrLocator);
		}else {
			return "";
		}
	}
    
    
}
