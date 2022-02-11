package com.firebase.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.salesforce.utility.GenerateReport;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReusableAllMethod {

	protected static WebDriver driver;
	protected static WebDriverWait wait;

	protected static GenerateReport report = GenerateReport.getInstance();

	public ReusableAllMethod(WebDriver driver1) {
		driver = driver1;
		PageFactory.initElements(driver1, this);
	}

	public static void Launch(String element) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(element);

	}

	public static void Login(String username, String passwordEle) {
		WebElement email = driver.findElement(By.id("email_field"));
		email.sendKeys(username);

		WebElement password = driver.findElement(By.id("password_field"));
		password.sendKeys(passwordEle);
		WebElement button = driver.findElement(By.tagName("button"));
		button.click();

//		
	}

	public static void clickOper(WebElement ele) {
		ele.click();
		System.out.println("pass: tex");
	}

	public static void enterText(WebElement element, String text) {
		waitUntilVisible(element);
		if (element.isDisplayed()) {
			element.clear();
			element.sendKeys(text);
			System.out.println("pass: text entered");
			// report.logTestInfo("username entered");
		} else {
			System.out.println("fail: element not displayed");
		}
	}

	public static void waitUntilVisible(WebElement element) {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void ImplicitWait() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public static void waitUntilAlertIsPresent() {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public void AcceptAlert() {
		waitUntilAlertIsPresent();
		Alert alert = driver.switchTo().alert();
		System.out.println("alert text=" + alert.getText());
		alert.accept();

	}

	public void PopUpLight() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.id("lexNoThanks")).click();
		driver.findElement(By.id("tryLexDialogX")).click();
	}

	public static void close() {
		driver.close();
	}

	public String getTitleOfThePage() {
		return driver.getTitle();
	}

	public static String Asserting(String text) {
		return text;

	}

}
