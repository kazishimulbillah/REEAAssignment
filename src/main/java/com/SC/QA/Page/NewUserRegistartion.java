package com.SC.QA.Page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.SC.Helper.Action.ActionHelper;
import com.SC.Helper.Alert.AlertHelper;
import com.SC.Helper.JavaScript.JavaScriptHelper;
import com.SC.Helper.Select.DropDownHelper;
import com.SC.Helper.Wait.WaitHelper;
import com.SC.QA.Base.TestBase;

public class NewUserRegistartion extends TestBase {

	@FindBy(xpath = "//*[@id=\"nava\"]")
	WebElement PageTitle;

	@FindBy(xpath = "//*[@id=\"itemc\"]")
	List<WebElement> ItemCategory;// *[@id="tbodyid"]/div[1]

	@FindBy(xpath = "//*[@id=\"tbodyid\"]/div")
	List<WebElement> ItemNumber;

	@FindBy(xpath = "//*[@id=\"signin2\"]")
	WebElement SignupMenu;

	@FindBy(xpath = "//*[@id=\"sign-username\"]")
	WebElement Username;

	@FindBy(xpath = "//*[@id=\"sign-password\"]")
	WebElement Password;

	@FindBy(xpath = "//button[text()=\"Sign up\"]")
	WebElement SignupButton;

	@FindBy(xpath = "//*[@id=\"login2\"]")
	WebElement LoginMenu;

	@FindBy(xpath = "//*[@id=\"loginusername\"]")
	WebElement LoginUsername;

	@FindBy(xpath = "//*[@id=\"loginpassword\"]")
	WebElement LoginPassword;

	@FindBy(xpath = "//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")
	WebElement LoginButton;

	@FindBy(xpath = "//a[text()=\"Nexus 6\"]")
	WebElement Nexus6;

	@FindBy(xpath = "//a[text()=\"Add to cart\"]")
	WebElement AddToCart;

	@FindBy(xpath = "//a[text()=\"Cart\"]")
	WebElement CartMenu;

	@FindBy(xpath = "//button[text()=\"Place Order\"]")
	WebElement PlaceOrder;

	@FindBy(xpath = "//*[@id=\"name\"]")
	WebElement Name;

	@FindBy(xpath = "//*[@id=\"country\"]")
	WebElement Country;

	@FindBy(xpath = "//*[@id=\"city\"]")
	WebElement City;

	@FindBy(xpath = "//*[@id=\"card\"]")
	WebElement CreditCard;

	@FindBy(xpath = "//*[@id=\"month\"]")
	WebElement Month;

	@FindBy(xpath = "//*[@id=\"year\"]")
	WebElement Year;

	@FindBy(xpath = "//button[text()=\"Purchase\"]")
	WebElement PurchaseButton;

	JavaScriptHelper javaScript = new JavaScriptHelper(driver);
	DropDownHelper dropDown = new DropDownHelper(driver);
	ActionHelper action = new ActionHelper(driver);
	WaitHelper wait = new WaitHelper(driver);
	AlertHelper alert = new AlertHelper(driver);

	public NewUserRegistartion() {
		PageFactory.initElements(driver, this);
	}

	public void ItemCount(String name, String email, String password, String day, String month, String year,
			String firstname, String lastname, String address, String country, String state, String city,
			String zipcode, String mobilenumber, String cardNumber, String cvc, String expiryMonth, String expiryYear)
			throws InterruptedException {

		Thread.sleep(500);
		Assert.assertEquals(driver.getTitle(), "STORE");

		Thread.sleep(500);
		Assert.assertEquals(PageTitle.getText(), "PRODUCT STORE");

		System.out.println(PageTitle.getText());

		Thread.sleep(1000);
		javaScript.clickElement(ItemCategory.get(0));
		System.out.println(ItemCategory.get(0).getText());

		Thread.sleep(1000);
		int NumberOfPhones = ItemNumber.size();
		System.out.println(NumberOfPhones);

		Thread.sleep(1000);
		Assert.assertEquals(NumberOfPhones, 7);

		Thread.sleep(1000);
		javaScript.clickElement(ItemCategory.get(1));
		System.out.println(ItemCategory.get(1).getText());

		Thread.sleep(1000);
		int NumberOfLaptops = ItemNumber.size();
		System.out.println(NumberOfLaptops);

		Thread.sleep(1000);
		Assert.assertEquals(NumberOfLaptops, 6);

		Thread.sleep(1000);
		javaScript.clickElement(ItemCategory.get(2));
		System.out.println(ItemCategory.get(2).getText());

		Thread.sleep(1000);
		int NumberOfMonitors = ItemNumber.size();
		System.out.println(NumberOfMonitors);

		Thread.sleep(1000);
		Assert.assertEquals(NumberOfMonitors, 2);
	}

	public void RegisterANewUser() throws Exception {

		Thread.sleep(1000);
		javaScript.clickElement(SignupMenu);

		Thread.sleep(1000);
		Username.sendKeys("shimulece07@gmail.com");

		Thread.sleep(1000);
		Password.sendKeys("Test@1234");

		Thread.sleep(1000);
		javaScript.clickElement(SignupButton);

		Thread.sleep(1000);
		alert.acceptAlert();

		Thread.sleep(1000);
		javaScript.clickElement(LoginMenu);

		Thread.sleep(1000);
		LoginUsername.sendKeys("shimulece07@gmail.com");

		Thread.sleep(1000);
		LoginPassword.sendKeys("Test@1234");

		Thread.sleep(1000);
		javaScript.clickElement(LoginButton);

		Thread.sleep(2000);
		Assert.assertEquals(PageTitle.getText(), "PRODUCT STORE");
		System.out.println(PageTitle.getText());

	}

	public void ProductPurchase() throws Exception {

		Thread.sleep(1000);
		javaScript.clickElement(ItemCategory.get(0));
		System.out.println(ItemCategory.get(0).getText());

		Thread.sleep(1000);
		javaScript.clickElement(Nexus6);

		Thread.sleep(1000);
		javaScript.clickElement(AddToCart);

		Thread.sleep(1000);
		alert.acceptAlert();

		Thread.sleep(1000);
		javaScript.clickElement(CartMenu);

		Thread.sleep(2000);
		javaScript.clickElement(PlaceOrder);

		Thread.sleep(2000);
		Name.sendKeys("Kazi Md Shimul Billah");

		Thread.sleep(1000);
		Country.sendKeys("Bangladesh");

		Thread.sleep(1000);
		City.sendKeys("Dhaka");

		Thread.sleep(1000);
		CreditCard.sendKeys("456789543");

		Thread.sleep(1000);
		Month.sendKeys("4");

		Thread.sleep(1000);
		Year.sendKeys("2024");

		Thread.sleep(2000);
		javaScript.clickElement(PurchaseButton);
	}
}
