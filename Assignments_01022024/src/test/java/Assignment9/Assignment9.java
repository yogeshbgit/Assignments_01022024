package Assignment9;

import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.*;
import PageObjects.FlipkartPageObject;
import base.BaseClass;

public class Assignment9 extends BaseClass {
	
	WebDriver driver;
	Properties pro;
	FlipkartPageObject flipkartPage;

	@BeforeMethod
	public void setup() throws IOException {
		pro = getProperties();
		driver = initialize(pro.getProperty("flipkart.Url"));
	}
	
	@Test
	public void validateSearchProduct(){
		flipkartPage= new FlipkartPageObject(driver);
		String productName = pro.getProperty("product.Name");
		flipkartPage.searchProduct(productName);
		flipkartPage.clickOnProdct(productName);
		boolean iscustomerRatingSelected = flipkartPage.selectCustomerRating();
		Assert.assertTrue(iscustomerRatingSelected,"Customer Rating Not Selected");
		boolean isInternalStorageSelected = flipkartPage.selectInernalStorage();
		Assert.assertTrue(isInternalStorageSelected,"Internal Storage Not Selected");
		boolean  isProcessorBrandSelected = flipkartPage.selectProcessorBrand();
		Assert.assertTrue(isProcessorBrandSelected,"Processor Brand Not Selected");
		String parentWindowHandle = driver.getWindowHandle();
		flipkartPage.clickOnFirstProduct();
		Set<String> windowHandles = driver.getWindowHandles();
		for(String windowHandle:windowHandles) {
			if(!windowHandle.equals(parentWindowHandle)) {
				driver.switchTo().window(windowHandle);
			}
		}
		flipkartPage.getProductName();
		flipkartPage.getProductPrice();
		flipkartPage.getProductSellerName();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
