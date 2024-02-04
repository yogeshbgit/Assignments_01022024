package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPageObject {

	public WebDriver driver;
	
	public loginPageObject(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@placeholder='Username']")
	WebElement userName;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement login;
	
	@FindBy(xpath="//p[contains(.,'Username')]")
	WebElement getuserName;
	
	@FindBy(xpath="//p[contains(.,'Password')]")
	WebElement getpassword;
	
	@FindBy(xpath="//img[@alt='profile picture']")
	WebElement profilePicture;
	
	public boolean getProfilePicture()
	{
		return profilePicture.isDisplayed();
	}
	
	public void enterUserName()
	{
		String sysUserName = getuserName.getText().split(":")[1].trim();
		userName.sendKeys(sysUserName);
	}
	
	public void enterPassword()
	{
		String sysPassword = getpassword.getText().split(":")[1].trim();
		password.sendKeys(sysPassword);
	}

	public void clickOnLogin()
	{
		login.click();
	}

}
