package Assignment2;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import Resources.BaseRepository;

public class Assignment2 extends BaseRepository{

	public WebDriver driver;
	
	@BeforeTest
	public void setup() throws IOException
	{
		driver = makyMytripInitialize();
	}
	
	@Test
	public void validateURL()
	{
		String expectedURL=url; 
		String actualURL = driver.getCurrentUrl();
		//System.out.println("expectedURL:"+expectedURL);
		//System.out.println("actualURL:"+actualURL);
		Assert.assertEquals(expectedURL, actualURL);
	}
	
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	
}
