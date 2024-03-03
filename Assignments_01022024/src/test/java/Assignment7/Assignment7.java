package Assignment7;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import PageObjects.demoqaPageObject;
import Resources.BaseRepository;

public class Assignment7 extends BaseRepository {
	
	public WebDriver driver;
	Properties pro;
	demoqaPageObject demopo ;
	
	@BeforeTest
	public void setup() throws IOException
	{
		 pro = getProperties();
		 driver = initialize(pro.getProperty("demoqaUrl"));
		//driver = demoqaInitialize();
	}
	
	
	@Test(priority=1)
	public void validateLogin() throws InterruptedException
	{
		String cardName = pro.getProperty("cardName");
		 demopo =  new demoqaPageObject(driver);
		demopo.clickOnCard(cardName);
		demopo.clickOnLogin();
		String userName= pro.getProperty("userName");
		String password = pro.getProperty("password");
		demopo.enterUserNameAndPassword(userName, password);
		demopo.clickOnLoginButton();
	}
		
	
	
	@Test(priority=2)
	public void  validateBookAdded() throws IOException, InterruptedException
	{
		demopo.clickOnBookStore();
		String bookName = pro.getProperty("bookName");
		demopo.clickOnBook(bookName);
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	
	

}
