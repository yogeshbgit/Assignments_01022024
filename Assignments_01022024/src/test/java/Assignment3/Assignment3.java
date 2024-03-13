package Assignment3;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import PageObjects.HomePageObject;
import PageObjects.LoginPageObject;
import base.BaseClass;

public class Assignment3 extends BaseClass {

	public WebDriver driver;
	LoginPageObject lpo;
	Properties pro;

	@BeforeMethod
	public void setup() throws IOException {
		pro = getProperties();
		driver = initialize(pro.getProperty("openSource.Url"));
	}

	@Test
	public void validateLogin() throws InterruptedException {
		lpo = new LoginPageObject(driver);
		lpo.enterUserName();
		lpo.enterPassword();
		lpo.clickOnLogin();
		HomePageObject homePage = new HomePageObject(driver);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(homePage.username));
		Assert.assertTrue(homePage.getuserName());
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}