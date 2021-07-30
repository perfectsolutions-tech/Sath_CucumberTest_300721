package PageModel;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.Property;
import Utilities.SeleniumUtilities;

public class IDHubPage {
	WebDriverWait wait;
	WebDriver driver;

	Properties p = Property.getProperty();

	public IDHubPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 6000);
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//*[@id='initial-login-btn']")
	WebElement IntialLgnBtn;
	
	@FindBy(xpath = "//*[@id='org-name-input']")
	WebElement OrgName;
	
	@FindBy(xpath = "//*[@id='username']")
	WebElement UserName;
	
	@FindBy(xpath = "//*[@id='password']")
	WebElement PassWrd;
	
	@FindBy(xpath = "//*[@id='kc-login']")
	WebElement Flogin;
	
	@FindBy(xpath = "//span[text() ='Request Access']")
	WebElement ReqBtn;
	
	@FindBy(xpath = "(//img[@class='entity-logo'])[1]")
	WebElement logo;

	@FindBy(xpath = "(//p[@class='descriptive-content-bold'])[1]")
	WebElement AppName;

	@FindBy(xpath = "(//span[contains(text(),'HR, Feedback, 1-on-1')])[1]")
	WebElement Keywords;

	@FindBy(xpath = "(//div[contains(@class,'bookmark-container')]//mat-icon)[1]")
	WebElement Bookmark;

	@FindBy(xpath = "(//img[@alt='add-icon0'])[1]")
	WebElement AddIcon;

	@FindBy(xpath = "//button[@class='primary-button align-right mat-raised-button mat-button-base']")
	WebElement searchBtn;

	@FindBy(xpath = "//*[@name='searchKeyword']")
	WebElement SrcKeyword;
	
	@FindBy(xpath = "//*[text()='Applications']")
	WebElement applicationTab;

	@FindBy(xpath = "//*[@id=\"login-block\"]/form//button")
	WebElement IntlLgnBtn2;
	
	@FindBy(xpath = "(//*[@alt ='add-icon0'])[1]")
	WebElement PlusIcon;

	public void launchBrowserAndLogin() throws InterruptedException {
		driver.get(p.getProperty("URL"));
		IntialLgnBtn.click();
		OrgName.sendKeys("Testing");
		SeleniumUtilities.implyWait(driver, 5);
		IntlLgnBtn2.click();
		wait.until(ExpectedConditions.visibilityOf(UserName)).sendKeys(p.getProperty("UserName"));
		PassWrd.sendKeys(p.getProperty("Password"));
		Flogin.click();

	}

	public void userClicksRequestAccessAndSearchApplicaiton(String application) throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOf(ReqBtn)).click();
		wait.until(ExpectedConditions.visibilityOf(applicationTab)).click();
		SrcKeyword.sendKeys("7Geese");
		Thread.sleep(5000);
		SrcKeyword.sendKeys(Keys.ENTER);
		searchBtn.click();

	}

	public void userValidationForSearchDetails(String application) throws InterruptedException {
		SeleniumUtilities.implyWait(driver, 6);
		Assert.assertTrue(logo.isDisplayed());
		Assert.assertTrue(AppName.getText().contains(application));
		Assert.assertTrue(Keywords.isDisplayed());
		Assert.assertTrue(Bookmark.isDisplayed());
		Assert.assertTrue(AddIcon.isDisplayed());

	}

	public void UserAddApplicationToCart(String application) {

		PlusIcon.click();
		WebElement element = driver
				.findElement(By.xpath("/html/body/app-root/app-core-layout/div/section[2]/app-cart-detail/div/img"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		element = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//app-cart-detail//div[2][text()=' 7Geese ']")));
		Assert.assertTrue(element.getText().contains(application));
		element = driver.findElement(By.xpath("//app-cart-detail//*[text()='Proceed ']"));
		executor.executeScript("arguments[0].click();", element);

	}

}
