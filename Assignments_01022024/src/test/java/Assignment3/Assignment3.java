package Assignment3;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import PageObjects.HomePageObject;
import PageObjects.loginPageObject;
import Resources.BaseRepository;

public class Assignment3 extends BaseRepository{
	
	public WebDriver driver;
	loginPageObject lpo;
	Properties pro;
	
	@BeforeTest
	public void setup() throws IOException
	{
		 pro = getProperties();
		 driver = initialize(pro.getProperty("openSourceUrl"));
		//driver= openSourceInitialize();
	}
	
	@Test
	public void validateLogin() throws InterruptedException
	{

		lpo = new loginPageObject(driver);
		lpo.enterUserName();
		lpo.enterPassword();
		lpo.clickOnLogin();
		Thread.sleep(2000);
		HomePageObject hpo = new HomePageObject(driver);
		Assert.assertTrue(hpo.getuserName());
	}
	
	@AfterTest
	public void tearDown()
	{
		//driver.close();
		driver.quit();
	}
	

}
