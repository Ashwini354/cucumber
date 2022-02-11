package com.sf.base;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.firebase.pages.LoginPage.LoginPage;
import com.firebase.pages.profilePage.HomePage;
import com.salesforce.utility.GenerateReport;
import com.salesforce.utility.PropertiesConfguration;




import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	protected static WebDriver driver;
	protected static WebDriverWait wait;
	protected static Properties prop;
	protected static LoginPage loginPage;
	protected static HomePage homePage;
	

	protected static GenerateReport report = GenerateReport.getInstance();
	static {
		prop = PropertiesConfguration.loadProperties();
	}

	@BeforeTest
	public void setUp() {
		report.StartExtentReport();
	}

	public static void Launch(String element) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(element);

	}

	@BeforeMethod()
	public void setup(Method method) {
		report.StartSingleTestReport(method.getName());
		Launch(prop.getProperty("url"));

		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		

	}

//	

	public static void clickOper(WebElement ele) {
		ele.click();

	}

	@AfterTest
	public void endUp() {
		report.endReport();
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			report.logTestPass();
		} else if (result.getStatus() == ITestResult.FAILURE) {
			report.logTestFail();

			String path = takeScreenShot();
			try {
				report.logger.addScreenCaptureFromPath(path);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		driver.quit();
	}

	public static String takeScreenShot() {
		TakesScreenshot screen = ((TakesScreenshot) driver);
		File src_file = screen.getScreenshotAs(OutputType.FILE);
		String file_path = "/Users/ashwiniramamurthy/eclipse-workspace/SfPomAndCucumber/firebase.jpg";
		File des_file = new File(file_path);
		try {
			FileUtils.copyFile(src_file, des_file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/Users/ashwiniramamurthy/eclipse-workspace/SfPomAndCucumber/firebase.jpg";
	}

}
