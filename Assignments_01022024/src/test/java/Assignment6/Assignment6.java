package Assignment6;

import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import PageObjects.SeleniumPageObject;
import base.BaseClass;

public class Assignment6 extends BaseClass {
	public WebDriver driver;
	Properties pro;

	@BeforeMethod
	public void setup() throws IOException {
		pro = getProperties();
		driver = initialize(pro.getProperty("selenium.Url"));
	}

	@Test
	public void getMethodandReturnType() {
		Properties pro = new Properties();
		pro = prop;
		String link = pro.getProperty("packageLink");
		SeleniumPageObject seleniumPage = new SeleniumPageObject(driver);
		boolean linkClicked = seleniumPage.clickOnPackageLink(link);
		Assert.assertTrue(linkClicked, "Package link not matched");
		seleniumPage.clickOnInterfaces();
		seleniumPage.clickOnWebDriverInterface();
		seleniumPage.getAllMethods();
		seleniumPage.getAllReturnType();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}