package Assignment5;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import PageObjects.HomePageObject;
import base.BaseClass;

public class Assignment5 extends BaseClass {

	public WebDriver driver;
	Properties pro;

	@BeforeMethod
	public void setup() throws IOException {
		pro = getProperties();
		driver = initialize(pro.getProperty("makeMyTrip.Url"));
	}

	@Test
	public void getTitleLinks() {
		Properties pro = prop;
		String title = pro.getProperty("title");
		HomePageObject homePage = new HomePageObject(driver);
		List<String> allLinkText = homePage.getLinks(title);
		System.out.println("Total Links Count:" + allLinkText.size());
		for (String link : allLinkText) {
			System.out.println("Link Text:" + link);
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
