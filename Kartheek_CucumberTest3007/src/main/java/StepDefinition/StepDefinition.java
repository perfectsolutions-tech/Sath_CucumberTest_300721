package StepDefinition;

import org.openqa.selenium.WebDriver;

import PageModel.CheckOut;
import PageModel.IDHubPage;
import Utilities.SeleniumUtilities;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition {
	WebDriver driver = SeleniumUtilities.getDriver();

	IDHubPage ApplicationPage = new IDHubPage(driver);

	@Given("^Browser is launched and user is logged in and navigated to application page$")
	public void browser_is_launched_and_user_is_logged_in_and_navigated_to_application_page() throws Throwable {
		ApplicationPage.launchBrowserAndLogin();
	}

	@When("^user clciks on Request access and search for:\"([^\"]*)\"$")
	public void user_clciks_on_Request_access_and_search_for(String Application) throws InterruptedException {
		ApplicationPage.userClicksRequestAccessAndSearchApplicaiton(Application);

	}

	@Then("^user validation for Search details of the \"([^\"]*)\"$")
	public void user_validation_for_Search_details_of_the_application(String Application) throws InterruptedException {
		ApplicationPage.userValidationForSearchDetails(Application);
	}

	@Then("^user clicks on plus icon and validate deatails of added cart \"([^\"]*)\"$")
	public void user_clicks_on_plus_icon_and_validate_deatails_of_added_cart_application(String Application) {
		ApplicationPage.UserAddApplicationToCart(Application);
	}

	@Then("^user reaches the check out page and validate the details of the application for check out$")
	public void user_reaches_the_check_out_page_and_validate_the_details_of_the_application_for_check_out()
			throws InterruptedException {
		CheckOut checkOut = new CheckOut(driver);
		checkOut.checkPageLoaded();
		checkOut.clickAppCard();
		checkOut.Submission();
		checkOut.RequestValidationAndLogout();
	}

}