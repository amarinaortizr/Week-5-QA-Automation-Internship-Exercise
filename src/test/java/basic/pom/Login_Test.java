package basic.pom;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Login_Test {

	static WebDriver driver;
	LogInPage logInPage;
	
		
	@Before
	public void setUp() {
		logInPage = new LogInPage(driver);
		driver = logInPage.chromeDriverConnection();
		driver.manage().window().maximize();
		logInPage.visit("https://demoqa.com/login");
	}
	
	@Test
	public void test() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		logInPage.logIn();
		logInPage.goToBookStore(js);
		logInPage.addFirstBooktoCollection(js);
		logInPage.goProfileAndVerifyBook();
	}
	
	@After
	public void tearDown() {
		logInPage.deleteBook();
		driver.close();
		driver.quit();
	}


}
