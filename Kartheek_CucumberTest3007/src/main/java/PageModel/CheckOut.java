package PageModel;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.SeleniumUtilities;

public class CheckOut {
	WebDriverWait wait;
	WebDriver driver;

	public CheckOut(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 9000);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@class ='entity-title idh-col-8 ng-star-inserted']")
	WebElement appCard;
	@FindBy(xpath = "//*[@placeholder=\"Display Name\"]")
	WebElement displayName;

	@FindBy(xpath = "//*[@placeholder=\"User Login\"]")
	WebElement userLogin;

	@FindBy(xpath = "//mat-drawer-container//div[3]//button[3]")
	WebElement doneBtn;

	@FindBy(xpath = "//*[@class='continue-button primary-button mat-button mat-button-base ng-star-inserted']")
	WebElement continueBtn;

	@FindBy(xpath = "//div[@class='mat-form-field-infix']")
	WebElement JustificationTxt;

	@FindBy(xpath = "//input[contains(@class, 'mat-input-element mat-form-field-autofill-control')]")
	WebElement JustficationInputBox;

	@FindBy(xpath = "//span[text()= 'Submit ']")
	WebElement SubmitBtn;
	
	@FindBy(xpath = "//a[text()='Logout']")
	WebElement LogoutBtn;

	public void checkPageLoaded() {
	   wait.until(ExpectedConditions.visibilityOf(appCard));
	}

	public void clickAppCard() {
		wait.until(ExpectedConditions.visibilityOf(appCard)).click();
	}

	public void Submission() throws InterruptedException {

		SeleniumUtilities.implyWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(doneBtn)).click();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		String footerMsg = executor
				.executeScript("return document.getElementsByClassName('footer-message')[0].innerText").toString();
		Assert.assertTrue(footerMsg.equals("You are all set to submit the request"));
		appCard.click();
		wait.until(ExpectedConditions.elementToBeClickable(doneBtn));
		doneBtn.click();
		wait.until(ExpectedConditions.visibilityOf(continueBtn));
		continueBtn.click();
		JustificationTxt.click();
		JustficationInputBox.sendKeys("Please provide me access to this application");
		SubmitBtn.click();

	}

	public void RequestValidationAndLogout() {
		/*
		 * wait.until(ExpectedConditions.visibilityOf( driver.findElement(By.
		 * xpath("/html//*[contains(text() ,'Request submitted successfully')])"))));
		 * Assert.assertTrue( driver.findElement(By.
		 * xpath("/html//*[text() ='Request submitted successfully']")).isDisplayed());
		 */
		wait.until(ExpectedConditions.visibilityOf(LogoutBtn)).click();

	}
}
