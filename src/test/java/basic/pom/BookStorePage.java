package basic.pom;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookStorePage extends Base {
	
	//xpath locators
	By FirstBookHrefLocator = By.xpath("//a[@href='/books?book=9781449325862']");
	By ProfileFirstBookHrefLocator = By.xpath("//a[@href='/profile?book=9781449325862']");
	By addToCollectionBtnLocator = By.xpath("//button[contains(text(),'Add To Your Collection')]");
	By goProfilePageBtnLocator = By.xpath("//li[span[contains(text(),'Profile')]]");
	
	public BookStorePage(WebDriver driver) {
		super(driver);
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
}
