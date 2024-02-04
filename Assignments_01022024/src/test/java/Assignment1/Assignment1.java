package Assignment1;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import Resources.BaseRepository;

public class Assignment1 extends BaseRepository {
	
	public WebDriver driver;
	
	@BeforeTest
	public void setup() throws IOException
	{

		driver = makyMytripInitialize();
	}

	@Test()
	public void  validateTitle()
	{
		String expectedTitle = "MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday";
		String actualTitle= driver.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
	}
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	
	
	
		
}
