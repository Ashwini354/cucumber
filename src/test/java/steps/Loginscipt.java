package steps;

import org.testng.Assert;

import com.firebase.pages.LoginPage.LoginPage;
import com.firebase.pages.profilePage.HomePage;
import com.salesforce.utility.Constant;
import com.sf.base.BaseTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Loginscipt  extends BaseTest{
	
	
	@Given("check proper salesforce page")
	public void check_proper_salesforce_page() {
		
		Launch(prop.getProperty("url"));
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		
	}

	@When("user enters {string} into username field")
	public void user_enters_into_username_field(String username) {
	    loginPage.enterInteUsernameFeild(username);
	}

	@When("user enters {string} into password field")
	public void user_enters_into_password_field(String password) {
	   loginPage.enterIntePasswordFeild(password);
	}

	@When("user click login button")
	public void user_click_login_button() {
	  loginPage.clickLoginButton();
	}

	

	
	@Then("wrong password displayed")
	public void wrong_password_displayed() {
		Assert.assertEquals(loginPage.checkuserPasswordWrong(),Constant.PASSWORD_WRONG);
	    
	}
	
	@Then("vrify home page {string}")
	public void vrify_home_page(String string) {
		 System.out.println(homePage.tittle());
		Assert.assertEquals(homePage.getTitleOfThePage(),string);
		
	}

}
