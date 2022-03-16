package basic.pom;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage extends Base  {

	//cssSelector locators
	By goBookStoreBtnLocator = By.cssSelector("#gotoStore");
	By deleteFirstBookBtnLocator = By.cssSelector("#delete-record-undefined");
	By okdeleteFirstBookBtnLocator = By.cssSelector("#closeSmallModal-ok");
	
	public ProfilePage(WebDriver driver) {
		super(driver);
	}

	//click on button to go to book store
	public void goToBookStore(JavascriptExecutor js){
		WebElement findGoBookStoreBtn = driver.findElement(goBookStoreBtnLocator);
		js.executeScript("arguments[0].scrollIntoView();",findGoBookStoreBtn);
		click(goBookStoreBtnLocator);
	}	
	
	//at the end of the test click on button to delete the book added
		public void deleteBook() {
			WaitForElementClickable(deleteFirstBookBtnLocator);
			click(deleteFirstBookBtnLocator);
			WaitForElementClickable(okdeleteFirstBookBtnLocator);
			click(okdeleteFirstBookBtnLocator);
			assertEquals("Book deleted.", GetAlertText()); //check the book is deleted
			AcceptAlert();
		}
}
