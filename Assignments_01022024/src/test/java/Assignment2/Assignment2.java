package Assignment2;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import Resources.BaseRepository;

public class Assignment2 extends BaseRepository{

	public WebDriver driver;
	Properties pro;
	
	@BeforeTest
	public void setup() throws IOException
	{
		 pro = getProperties();
		 driver = initialize(pro.getProperty("makeMyTripUrl"));
		//driver = makyMytripInitialize();
	}
	
	@Test
	public void validateURL()
	{
		String expectedURL=pro.getProperty("makeMyTripUrl"); 
		String actualURL = driver.getCurrentUrl();
		//System.out.println("expectedURL:"+expectedURL);
		//System.out.println("actualURL:"+actualURL);
		Assert.assertEquals(expectedURL, actualURL);
	}
	
	
	@AfterTest
	public void tearDown()
	{
		//driver.close();
		driver.quit();
	}
	
}
