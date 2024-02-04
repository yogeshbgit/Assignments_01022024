package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObject {

	public WebDriver driver;
	
	public HomePageObject(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//p[@class='oxd-userdropdown-name']")
	WebElement userName;
	
	public boolean getuserName()
	{
		return userName.isDisplayed();
	}
}
