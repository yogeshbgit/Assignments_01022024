package Assignment4;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import PageObjects.HomePageObject;
import Resources.BaseRepository;

public class Assignment4  extends BaseRepository {
	
public WebDriver driver;
	
	@BeforeTest
	public void setup() throws IOException
	{

		driver = makyMytripInitialize();
	}
	
	@Test
	public void getTitleLinks()
	{
		Properties pro= prop;
		String title=pro.getProperty("title");
		HomePageObject hpo = new HomePageObject(driver);
		List<String> allLinkText= hpo.getLinks(title);
		System.out.println("Total Links Count:"+allLinkText.size());
		for(String link:allLinkText)
		{
			System.out.println("Link Text:"+link);
		}
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}

}
