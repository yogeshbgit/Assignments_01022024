package Assignment7;

import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import PageObjects.DemoQaPageObject;
import base.BaseClass;

public class Assignment7 extends BaseClass {

	public WebDriver driver;
	Properties pro;
	DemoQaPageObject demoQaPage;
	String cardName;

	@BeforeMethod
	public void setup() throws IOException {
		pro = getProperties();
		driver = initialize(pro.getProperty("demo.qa.Url"));
	}

	@Test
	public void validateBookAdded() throws IOException, InterruptedException {
		cardName = pro.getProperty("card.Name");
		demoQaPage = new DemoQaPageObject(driver);
		demoQaPage.clickOnCard(cardName);
		demoQaPage.clickOnBookStore();
		String bookName = pro.getProperty("book.Name");
		demoQaPage.clickOnBook(bookName);
	}
	
	@Test
	public void validateLogin() throws InterruptedException {
		demoQaPage = new DemoQaPageObject(driver);
		demoQaPage.clickOnCard(cardName);
		demoQaPage.clickOnLogin();
		String userName = pro.getProperty("user.Name");
		String password = pro.getProperty("password");
		demoQaPage.enterUserNameAndPassword(userName, password);
		demoQaPage.clickOnLoginButton();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}