package Assignment6;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import PageObjects.SeleniumPageObject;
import Resources.BaseRepository;

public class Assignment6 extends BaseRepository{
public WebDriver driver;
	
	@BeforeTest
	public void setup() throws IOException
	{

		driver = seleniumInitialize();
	}
	
	@Test
	public void getMethodandReturnType()
	{
		Properties pro = new Properties();
		pro=prop;
		String link = pro.getProperty("packageLink");
		SeleniumPageObject spo = new SeleniumPageObject(driver);
		boolean linkClicked = spo.clickOnPackageLink(link);
		Assert.assertTrue(linkClicked,"Package link not matched");
		spo.clickOnInterfaces();
		spo.clickOnWebDriverInterface();
		spo.getAllMethods();
		spo.getAllReturnType();
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}

}
