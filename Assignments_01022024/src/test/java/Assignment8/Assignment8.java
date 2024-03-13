package Assignment8;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import PageObjects.IrctcPageObject;
import base.BaseClass;

public class Assignment8 extends BaseClass {

	public WebDriver driver;
	Properties pro;
	IrctcPageObject irctcPage;

	@BeforeMethod
	public void initialize() throws IOException {
		pro = getProperties();
		driver = initialize(pro.getProperty("irctc.Url"));
	}

	@Test
	public void validateRunningTrains() throws InterruptedException {
		String source = pro.getProperty("source");
		String destination = pro.getProperty("destination");
		irctcPage = new IrctcPageObject(driver);
		irctcPage.enterSource(source);
		irctcPage.enterDestination(destination);
		String classes = pro.getProperty("classes");
		irctcPage.selectClass(classes);
		irctcPage.clickOnSearchButton();
		int noOfTrains = irctcPage.getNoOfTrainsRuuning();
		List<String> listOfRunningTrains = irctcPage.getRunningTrainList();
		Assert.assertEquals(noOfTrains, listOfRunningTrains.size());
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}