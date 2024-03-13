package Assignment2;

import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import base.BaseClass;

public class Assignment2 extends BaseClass {

	public WebDriver driver;
	Properties pro;

	@BeforeMethod
	public void setup() throws IOException {
		pro = getProperties();
		driver = initialize(pro.getProperty("makeMyTrip.Url"));
	}

	@Test
	public void validateURL() {
		String expectedURL = pro.getProperty("makeMyTrip.Url");
		String actualURL = driver.getCurrentUrl();
		Assert.assertEquals(expectedURL, actualURL);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}