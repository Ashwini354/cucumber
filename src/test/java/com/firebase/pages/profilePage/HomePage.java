package com.firebase.pages.profilePage;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.xml.xpath.XPath;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import com.firebase.base.ReusableAllMethod;


public class HomePage extends ReusableAllMethod{
	
	public HomePage(WebDriver driver1) {
		super(driver1);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(linkText = "Contacts")
	WebElement contact;
	@FindBy(linkText = "Home")
	WebElement home;
	@FindBy(xpath = "//a[normalize-space()='Logout']")
	WebElement logout;
	@FindBy(xpath = "//a[@title='Leads Tab']")
	WebElement leads;
	@FindBy(id = "userNavButton")
	WebElement user_menu;
	@FindBy(linkText = "My Profile")
	WebElement my_profile;
	@FindBy(xpath = "//a[text()='My Settings']")
	WebElement my_setting;
	@FindBy(linkText = "Developer Console")
	WebElement developer_console;
	@FindBy(linkText = "Accounts")
	WebElement account;
	@FindBy(linkText = "Opportunities")
	WebElement oppertunity;
	@FindBy(id = "createNewLabel")
	WebElement create_new;
	@FindBy(xpath = "//a[@class='opportunityMru menuButtonMenuLink']")
	WebElement create_new_oper;
	@FindBy(xpath = "//a[@class='contactMru menuButtonMenuLink']")
	WebElement create_new_contact;
	@FindBy(xpath = "//a[text()='Create New View']")
	WebElement create_new_veiw;
	@FindBy(xpath = "//a[@href='/home/showAllTabs.jsp']")
	WebElement plus;
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/div[1]/div[1]/div[1]/h1[1]")
	WebElement calender_name_check;
	@FindBy(xpath = "html[1]/body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/div[1]/div[1]/div[2]/span[2]/a[1]")
	WebElement date_check;
	@FindBy(xpath = "//input[@title='Customize My Tabs']")
	WebElement customize_my_tab;

	@FindBys({ @FindBy(id = "userNav-menuItems") })
	public List<WebElement> Allmenu;

	public void checkUserMenuText() {
		for (WebElement menu : Allmenu) {

			System.out.println("menu -->" + menu.getText());
			String[] str = menu.getText().split("\\n");
			List<String> menuList = Arrays.asList(str);

			if (menuList.contains("My Profile") || menuList.contains("My Settings")
					|| menuList.contains("Developer Console") || menuList.contains("Switch to Lightning Experience")
					|| menuList.contains("Logout")) {
				System.out.println("pass");
			} else {
				System.out.println("fail");
			}
		}
	}

	public void clickLogoutButton() {
		logout.click();
		//waitUntilVisible(logout);

	}

	public void clickOpertunityButton() {
		oppertunity.click();

	}

	public void clickCustomizeMyTabButton() throws InterruptedException {
		Thread.sleep(3000);
		customize_my_tab.click();

	}

	public void clickPlusButton() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", plus);

	}

	public void clickHomeButton() {
		home.click();

	}

	public void clickCreateNewVeiwButton() {
		create_new_veiw.click();

	}

	public void clickContactButton() {
		contact.click();

	}

	public void clickCreateNewContactButton() {
		create_new_contact.click();

	}

	public void clickLeadsButton() {
		leads.click();

	}

	public void clickOpertunitySelectButton() {
		create_new_oper.click();

	}

	public void clickCreateNewButton() {
		create_new.click();

	}

	public void clickDateCheckButton() {

		date_check.click();

	}

	public String checkCalenderNamekButton() {
		return calender_name_check.getText();

	}

	public void clickDeveloperConsoleButton() throws InterruptedException {

		String oldwindow = driver.getWindowHandle();
		developer_console.click();
		Thread.sleep(5000);
		Set<String> window2 = driver.getWindowHandles();
		System.out.println(window2.size());
		for (String Windows : window2) {
			if (!Windows.equals(oldwindow)) {
				driver.switchTo().window(Windows);
				break;
				// System.out.println();
			}
		}
		driver.switchTo().window(oldwindow);
		close();

	}

	public void clickUserMenuButton() {
		user_menu.click();

	}

	public void clickAccountButton() {
		account.click();

	}

	public void clickMyProfile() {
		my_profile.click();

	}

	public void clickMySettingButton() {
		my_setting.click();
	}
	public String tittle() {
		return driver.getTitle();
	}

}
