package Resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseRepository {
	public WebDriver driver;
	public Properties prop;
	public String browser;
	public String url;
	
	public WebDriver makyMytripInitialize() throws IOException
	{
		prop=getProperties();
		browser = prop.getProperty("browser");
		url = prop.getProperty("makeMyTripUrl");
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(url);
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		return driver;
		
	}
	
	public WebDriver openSourceInitialize() throws IOException
	{
		prop=getProperties();
		browser = prop.getProperty("browser");
		url = prop.getProperty("openSourceUrl");
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(url);
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		return driver;
		
	}
	
	public WebDriver seleniumInitialize() throws IOException
	{
		prop=getProperties();
		browser = prop.getProperty("browser");
		url = prop.getProperty("seleniumURL");
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(url);
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		return driver;
		
	}
	
	public Properties getProperties() throws IOException
	{
		prop= new Properties();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\data.properties");
		prop.load(file);
		return prop;
	}
	

}
