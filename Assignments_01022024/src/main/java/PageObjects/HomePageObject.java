package PageObjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
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
	
	@FindBy(xpath="//div[@class='footNav']/p")
	List<WebElement>titles;
	
	public boolean getuserName()
	{
		return userName.isDisplayed();
	}
	
	public List<String> getLinks(String title)
	{
		int titleIndex = getTitleIndex(title);
		List<WebElement> links=driver.findElements(By.xpath("//ul[@class='footNav__list']["+titleIndex+"]/li"));
		
		List<String> linkText = new ArrayList();
		for(WebElement link:links)
		{
			linkText.add(link.getText());
		}
		return linkText;
	}

	
	public int getTitleIndex(String title)
	{
		List<String> titleList = new ArrayList();
		HashMap<String,Integer> hm = new HashMap<String,Integer>();
		for(int i=0;i<titles.size();i++)
		{
			titleList.add(titles.get(i).getText());
			int ind=i+1;
			hm.put(titles.get(i).getText(), ind);
			//System.out.println("title:"+titles.get(i).getText()+", index:"+ind);
		}
		int index=hm.get(title);
		//System.out.println("index:"+index);
		return index;
	}
}
