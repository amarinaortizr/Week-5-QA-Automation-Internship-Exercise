package basic.pom;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPage extends Base {
	
	//By id locators
	By userLocator = By.id("userName");
	By passLocator = By.id("password");
	By signInBtnLocator = By.id("login");
	By homePageLocator = By.id("userName-value");
	
	//cssSelector locators
	By goBookStoreBtnLocator = By.cssSelector("#gotoStore");
	By deleteFirstBookBtnLocator = By.cssSelector("#delete-record-undefined");
	By okdeleteFirstBookBtnLocator = By.cssSelector("#closeSmallModal-ok");
	
	//xpath locators
	By FirstBookHrefLocator = By.xpath("//a[@href='/books?book=9781449325862']");
	By ProfileFirstBookHrefLocator = By.xpath("//a[@href='/profile?book=9781449325862']");
	By addToCollectionBtnLocator = By.xpath("//button[contains(text(),'Add To Your Collection')]");
	By goProfilePageBtnLocator = By.xpath("//li[span[contains(text(),'Profile')]]");
	
	
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
	
	//click on button to go to book store
	public void goToBookStore(JavascriptExecutor js){
		WebElement findGoBookStoreBtn = driver.findElement(goBookStoreBtnLocator);
		js.executeScript("arguments[0].scrollIntoView();",findGoBookStoreBtn);
		click(goBookStoreBtnLocator);
	}
	
	//click on the first book and click to add to the collection
	public void addFirstBooktoCollection(JavascriptExecutor js){
		WaitForElementClickable(FirstBookHrefLocator);
		click(FirstBookHrefLocator);
		WebElement findAddToCollectionBtn = driver.findElement(addToCollectionBtnLocator);
		js.executeScript("arguments[0].scrollIntoView();",findAddToCollectionBtn);
		click(addToCollectionBtnLocator);
		assertEquals("Book added to your collection.", GetAlertText()); //check the book added to the collection
		AcceptAlert();
	}
	
	//click on button to go to profile page
	public void goProfileAndVerifyBook(){
		WaitForElementClickable(goProfilePageBtnLocator);
		click(goProfilePageBtnLocator);
		assertEquals("Git Pocket Guide",getTextDisplayed(ProfileFirstBookHrefLocator)); //check the book on the collection
		
	}
	
	//click on button to delete the book added
	public void deleteBook() {
		WaitForElementClickable(deleteFirstBookBtnLocator);
		click(deleteFirstBookBtnLocator);
		WaitForElementClickable(okdeleteFirstBookBtnLocator);
		click(okdeleteFirstBookBtnLocator);
		assertEquals("Book deleted.", GetAlertText()); //check the book is deleted
		AcceptAlert();
	}
	
	 
	
	
}
