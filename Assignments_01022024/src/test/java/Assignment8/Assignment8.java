package Assignment8;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import PageObjects.irctcPageObject;
import Resources.BaseRepository;

public class Assignment8 extends BaseRepository{
	
	public WebDriver driver;
	Properties pro;
	irctcPageObject irctcpo;
	
	@BeforeTest()
	public void initialize() throws IOException
	{
		pro = getProperties();
		driver = initialize(pro.getProperty("irctcUrl"));
	}
	
	@Test()
	public void validateRunningTrains() throws InterruptedException
	{
		String source = pro.getProperty("source");
		String destination = pro.getProperty("destination");
		 irctcpo = new irctcPageObject(driver);
		 
		 irctcpo.enterSource(source);
		 irctcpo.enterDestination(destination);
		 String classes = pro.getProperty("classes");
		 irctcpo.selectClass(classes);
		 irctcpo.clickOnSearchButton();
		 Thread.sleep(1000);
		 int noOfTrains=irctcpo.getNoOfTrainRuuning();
		 List<String>listOfRunningTrains=irctcpo.getRunningTrainList();
		 Assert.assertEquals(noOfTrains,  listOfRunningTrains.size());
		 
	}
	
	@AfterTest()
	public void tearDown()
	{
		driver.quit();
	}
}
