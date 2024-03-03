package PageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class demoqaPageObject {
	
	public WebDriver driver;
	JavascriptExecutor js;
	
	public demoqaPageObject(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='card-body']/h5")
	List<WebElement> cards  ; 
	
	@FindBy(xpath="//span[text()='Login']")
	WebElement login;
	
	@FindBy(id="userName")
	WebElement userName;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="login")
	WebElement loginButton;
	
	@FindBy(xpath="//span[text()='Book Store']")
	WebElement bookStore;
	
	@FindBy(xpath="//a[text()='Speaking JavaScript']")
	WebElement book;
	
	public void clickOnCard(String cardName) throws InterruptedException
	{
		js = (JavascriptExecutor)driver;
		for(int i=0;i<cards.size();i++)
		{
			System.out.println(cards.get(i).getText());
			if(cards.get(i).getText().equals(cardName))
			{
				
				js.executeScript("arguments[0].click();", cards.get(i));
				System.out.println("card clicked");
			}
		}
	}
	
	public void clickOnLogin()
	{
		js.executeScript("arguments[0].click();", login);
		//login.click();
		System.out.println("Login Clicked");
	}
	
	public void enterUserNameAndPassword(String username,String Password)
	{
		userName.sendKeys(username);
		System.out.println("User Name Entered");
		password.sendKeys(Password);
		System.out.println("Password Entered");
	}
	
	public void clickOnLoginButton()
	{
		loginButton.click();
		System.out.println("Login Button Clicked");
	}
	
	public void clickOnBookStore()
	{
		js.executeScript("arguments[0].click();", bookStore);
		//bookStore.click();
	}
	
	public void clickOnBook(String bookName)
	{
	WebElement bookname=	driver.findElement(By.xpath("//a[text()='"+bookName+"']"));
	js.executeScript("arguments[0].click();", bookname);
	}
}

