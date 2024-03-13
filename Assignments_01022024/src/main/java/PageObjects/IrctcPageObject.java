package PageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IrctcPageObject {
	public WebDriver driver;
	WebDriverWait wait;

	public IrctcPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "a[class='fa fa-window-close pull-right loginCloseBtn ng-tns-c19-13']")
	WebElement loginPopup;

	@FindBy(xpath = "(//input[@role='searchbox'])[1]")
	WebElement sourceElement;

	@FindBy(xpath = "(//input[@role='searchbox'])[2]")
	WebElement destinationElement;

	@FindBy(xpath = "//li[@role='option']/span[@class='ng-star-inserted']")
	List<WebElement> Options;

	@FindBy(xpath = "//span[@class='ng-tns-c65-11 ui-dropdown-label ui-inputtext ui-corner-all ng-star-inserted']")
	WebElement classesOptions;

	@FindBy(xpath = "//button[@class='search_btn train_Search']")
	WebElement searchButton;

	@FindBy(xpath = "//div[@class='hidden-xs']/span")
	WebElement noOfTrainsRunning;
	
	@FindBy(xpath = "//div[@class='col-sm-5 col-xs-11 train-heading']/strong")
	List<WebElement> runningTrainList;

	public void enterSource(String source) throws InterruptedException {
		sourceElement.sendKeys(source);
		Thread.sleep(1000);
		for (int i = 0; i < Options.size(); i++) {
			if (Options.get(i).getText().contains(source)) {
				try {
					Options.get(i).click();
					System.out.println("Source selected:" + Options.get(i).getText());
					break;
				} catch (Exception e) {
					System.out.println("Error:" + e.getMessage());
				}
			}
		}
	}

	public void enterDestination(String destination) throws InterruptedException {
		destinationElement.sendKeys(destination);
		Thread.sleep(1000);
		for (int i = 0; i < Options.size(); i++) {
			if (Options.get(i).getText().contains(destination)) {
				try {
					Options.get(i).click();
					System.out.println("Destination selected:" + Options.get(i).getText());
					break;
				} catch (Exception e) {
					System.out.println("Error:" + e.getMessage());
				}
			}
		}
	}

	public void selectClass(String Classes) {
		classesOptions.click();
		for (int i = 0; i < Options.size(); i++) {
			if (Options.get(i).getText().contains(Classes)) {
				try {
					Options.get(i).click();
					System.out.println("Classes selected:" + Options.get(i).getText());
					break;
				} catch (Exception e) {
					System.out.println("Error:" + e.getMessage());
				}
			}
		}
	}

	public void clickOnSearchButton() {
		searchButton.click();
	}

	public int getNoOfTrainsRuuning() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='hidden-xs']/span")));
		String noOfTrains = noOfTrainsRunning.getText().split(" Result")[0];
		int noOfTrain = Integer.parseInt(noOfTrains);
		System.out.println("Number of Trains Running:" + noOfTrain);
		return noOfTrain;
	}

	public List<String> getRunningTrainList() {
		List<String> listOfRunningTrains = new ArrayList();
		for (WebElement trains : runningTrainList) {
			listOfRunningTrains.add(trains.getText());
			System.out.println("List of running trains:" + trains.getText());
		}
		return listOfRunningTrains;
	}
}