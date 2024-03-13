package PageObjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumPageObject {
	public WebDriver driver;

	public SeleniumPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='summary-table two-column-summary']/div/a")
	List<WebElement> allLinks;

	@FindBy(xpath = "//button[text()='Interfaces']")
	WebElement intefacetab;

	@FindBy(xpath = "//a[text()='WebDriver']")
	WebElement webdriverInterface;

	@FindBy(css = "a[class='member-name-link']")
	List<WebElement> allMethods;

	@FindBy(xpath = "//div[@class='col-first even-row-color method-summary-table method-summary-table-tab2 method-summary-table-tab3'] | //div[@class='col-first odd-row-color method-summary-table method-summary-table-tab2 method-summary-table-tab3']")
	List<WebElement> ReturnTypes;

	public boolean clickOnPackageLink(String link) {
		boolean linkClicked = false;
		for (int i = 0; i < allLinks.size(); i++) {
			if (allLinks.get(i).getText().equals(link)) {
				allLinks.get(i).click();
				linkClicked = true;
				break;
			}
		}
		return linkClicked;
	}

	public void clickOnInterfaces() {
		intefacetab.click();
	}

	public void clickOnWebDriverInterface() {
		webdriverInterface.click();
	}

	public void getAllMethods() {
		for (WebElement method : allMethods) {
			System.out.println("Methods:" + method.getText());
		}
	}

	public void getAllReturnType() {
		for (WebElement type : ReturnTypes) {
			System.out.println("return type:" + type.getText());
		}
	}
}