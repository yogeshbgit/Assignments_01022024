package PageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FlipkartPageObject {

	WebDriver driver;
	JavascriptExecutor js;
	WebDriverWait wait;
	
	public FlipkartPageObject(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@placeholder='Search for Products, Brands and More']")
	WebElement searchBox;
	
	@FindBy(xpath="//li[@class='_3D0G9a']/div/a/div[2]")
	List<WebElement>productList;
	
	@FindBy(xpath="//div[text()='4★ & above']")
	WebElement customerRating4_and_Above;
	
	
	@FindBy(xpath="//div[@class='_2gmUFU _3V8rao']")
	List<WebElement> filterList;
	
	@FindBy(xpath="//div[text()='256 GB & Above']")
	WebElement internalStorage256GB_and_Above;
	
	@FindBy(xpath="//div[text()='Apple']")
	WebElement processorBrandApple;
	
	@FindBy(xpath="(//div[@class='_4rR01T'])[1]")
	WebElement firstProductFromList;
	
	@FindBy(xpath="//h1[@class='yhB1nd']/span")
	WebElement getprodcutName;
	
	@FindBy(xpath="//div[@class='_30jeq3 _16Jk6d']")
	WebElement productprice;
	
	@FindBy(xpath="//div[@id='sellerName']/span/span")
	WebElement sellerName;
	
	public void searchProduct(String productName) {
		searchBox.sendKeys(productName);
	}
	
	public void clickOnProdct(String productName) {
		js= (JavascriptExecutor)driver;
		wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfAllElements(productList));
		for(int i=0;i<productList.size();i++) {
			if(productList.get(i).getText().contains("iphone 15")) {
				js.executeScript("arguments[0].click()", productList.get(i));
			}else {
				Assert.assertTrue(false,"Product Not Matched");
			}
		}
	}
	
	public boolean selectCustomerRating() {
		customerRating4_and_Above.click();
		return customerRating4_and_Above.isEnabled();
	}
	
	public boolean selectInernalStorage() {
		for(int i=0;i<filterList.size();i++) {
			if(filterList.get(i).getText().equalsIgnoreCase("Internal Storage")) {
				js.executeScript("arguments[0].click()", filterList.get(i));
				internalStorage256GB_and_Above.click();
			}
		}
		return internalStorage256GB_and_Above.isEnabled();
	}
	
	public boolean selectProcessorBrand() {

		for(int i=0;i<filterList.size();i++) {
			if(filterList.get(i).getText().equalsIgnoreCase("Processor Brand")) {
				js.executeScript("arguments[0].click()", filterList.get(i));
			}
		}
		js.executeScript("arguments[0].click()", processorBrandApple);
		return processorBrandApple.isEnabled();
	}
	
	public void clickOnFirstProduct(){
		js.executeScript("arguments[0].click()", firstProductFromList);
	}
	
	public void getProductName() {
		System.out.println("Product Name:"+getprodcutName.getText());
	}
	
	public void getProductPrice() {
		System.out.println("Product Price:"+productprice.getText());
	}
	
	public void getProductSellerName() {
		System.out.println("Product Seller Name:"+sellerName.getText());
	}
}
