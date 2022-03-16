package basic.pom;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Login_Test {

	static WebDriver driver;
	Base base;
	LogInPage logInPage;
	BookStorePage bookStorePage;
	ProfilePage profilePage;
		
	@Before
	public void setUp() {
		base = new Base(driver);
		driver = base.chromeDriverConnection();
		logInPage = new LogInPage(base.driver);
		profilePage = new ProfilePage(base.driver);
		bookStorePage = new BookStorePage(base.driver);
		driver.manage().window().maximize();
		logInPage.visit("https://demoqa.com/login");
	}
	
	@Test
	public void test() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		logInPage.logIn();
		profilePage.goToBookStore(js);
		bookStorePage.addFirstBooktoCollection(js);
		bookStorePage.goProfileAndVerifyBook();
	}
	
	@After
	public void tearDown() {
		profilePage.deleteBook();
		driver.close();
		driver.quit();
	}


}
