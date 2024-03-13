 package Assignment1;

import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import base.BaseClass;

public class Assignment1 extends BaseClass {

	public WebDriver driver;
	Properties pro;

	@BeforeMethod
	public void setup() throws IOException {
		pro = getProperties();
		driver = initialize(pro.getProperty("makeMyTrip.Url"));
	}

	@Test()
	public void validateTitle() {
		String expectedTitle = "MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
