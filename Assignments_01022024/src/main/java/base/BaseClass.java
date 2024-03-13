package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;
	public Properties prop;

	public Properties getProperties() throws IOException {
		prop = new Properties();
		FileInputStream file = new FileInputStream(
		System.getProperty("user.dir") + "\\src\\test\\java\\Resources\\data.properties");
		prop.load(file);
		return prop;
	}

	public WebDriver initialize(String url) throws IOException {
		prop = getProperties();
		String browser = prop.getProperty("browser");
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(url);
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;
	}
}