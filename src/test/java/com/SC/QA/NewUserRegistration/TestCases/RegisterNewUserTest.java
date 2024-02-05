package com.SC.QA.NewUserRegistration.TestCases;

import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.SC.QA.Base.TestBase;
import com.SC.QA.Page.NewUserRegistartion;
import com.SC.QA.Util.TestUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 *
 * @author Kazi Md Shimul Billah
 */

public class RegisterNewUserTest extends TestBase {

	TestUtil testUtil;
	NewUserRegistartion newUserRegistartion;
	String sheetName = "NewUserRegistration";
	public ExtentReports extent;
	public ExtentTest extentTest;

	public RegisterNewUserTest() {
		super();
	}

	@BeforeTest
	public void setExtent() {
		extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/ExtentReport.html", true);
	}

	@AfterTest
	public void endReport() {
		extent.flush();
		extent.close();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {

		initialization();
		testUtil = new TestUtil();
		newUserRegistartion = new NewUserRegistartion();
	}

	@Test(priority = 1, dataProvider = "RegisterNewUserTestData")
	public void NewUserRegistartionTest(String name, String email, String password, String day, String month,
			String year, String firstname, String lastname, String address, String country, String state, String city,
			String zipcode, String mobilenumber, String cardNumber, String cvc, String expiryMonth, String expiryYear)
			throws Throwable {

		extentTest = extent.startTest("RegisterNewUserTest");
		NewUserRegistartion nur = PageFactory.initElements(driver, NewUserRegistartion.class);
		nur.ItemCount(name, email, password, day, month, year, firstname, lastname, address, country, state,
				city, zipcode, mobilenumber, cardNumber, cvc, expiryMonth, expiryYear);
		nur.RegisterANewUser();
		nur.ProductPurchase();
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS " + result.getName()); // to add name in extent report
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); // to add error/exception in
																							// extent report

			String screenshotPath = RegisterNewUserTest.getScreenshot(driver, result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath)); // to add screenshot in extent

		} else if (result.getStatus() == ITestResult.SKIP) {
			extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());

		}

		extent.endTest(extentTest);

//		driver.quit();
//
//		CloseWebDriver();
	}

	@DataProvider
	public Object[][] RegisterNewUserTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

}
