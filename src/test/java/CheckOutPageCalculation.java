import java.awt.AWTException;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BasePackage.Base;
import BasePackage.MonteScreenRecorderUtil;
import PageObject.AddtoCartPage;
import PageObject.CheckOutPage;
import PageObject.LoginPage;

import java.time.Duration;

public class CheckOutPageCalculation extends Base {

	public WebDriver driver;

	public static Logger log = LogManager.getLogger(CheckOutPageCalculation.class.getName());
	private WebDriverWait wait;
	
	// Placeholder for screen recording start logic
	/*@BeforeTest
	public void ScreenrecordingStart() throws Exception {
		log.info("Screen recording started.");
		MonteScreenRecorderUtil.startRecording("AddtoCartCheck");
		MonteScreenRecorderUtil.startRecording("YourCart");
		}*/
	
	
	@Test(priority = 1)
	public void AddtoCartCheck() throws IOException, InterruptedException, AWTException {
		log.info("=========Test Case: Add to Cart Started=========");
		driver = initializerDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get(prop.getProperty("url"));
		LoginPage lp = new LoginPage(driver);
		AddtoCartPage atc = new AddtoCartPage(driver);
		log.info("Navigated to Home page");
		Thread.sleep(2000);
		lp.enterusername(); // enter username
		Thread.sleep(2000);
		lp.enterpassword(); // enter password
		Thread.sleep(2000);
		lp.clicklogin(); // click login button
		driver.manage().window().maximize();
		Thread.sleep(2000);
		atc.addToCartBackpack(); // add backpack to cart
		Thread.sleep(2000);
		atc.addToCartBikeLight(); // add bike light to cart
		Thread.sleep(2000);
		atc.addToCartBoltTShirt(); // add bolt t-shirt to cart
		Thread.sleep(2000);
		log.info("Items added to cart successfully");
		String totalitem = atc.getTotalItemsInCart(); // get total items in cart
		Assert.assertEquals(totalitem, "3");
		System.out.println("Total items in cart: " + totalitem + " is equal to 3");
		atc.getTotalItemsInCartClick(); // click on cart icon
		log.info("=========Test Case: Add to Cart Completed=========");
	}

	@Test(priority = 2)
	public void YourCart() throws InterruptedException {
		log.info("=========Test Case: Your Cart Verification Started=========");
		AddtoCartPage atc = new AddtoCartPage(driver);

		atc.removelight(); // remove bike light from cart

		String Price = atc.getBackpackPrice(); // get price of backpack
		System.out.println("Price of Backpack is: " + Price); // print price of backpack
		String TshirtPrice = atc.getTshirtPrice(); // get price of t-shirt
		System.out.println("Price of T-shirt is: " + TshirtPrice); // print price of t-shirt
		Assert.assertEquals(Price, "$29.99");
		Assert.assertEquals(TshirtPrice, "$15.99");
		log.info("Prices are verified");
		log.info("=========Test Case: Your Cart Verification Completed=========");
	}

	@Test(priority = 3)
	public void CheckoutCalculation() throws InterruptedException {
		CheckOutPage Checkout = new CheckOutPage(driver);
		log.info("=========Test Case: Checkout Page Calculation Started=========");
		Checkout.clickCheckout(); // click checkout button
		Checkout.firstname(); // enter first name
		Checkout.lastname(); // enter last name
		Checkout.postalcode(); // enter postal code
		Checkout.clickContinue(); // click continue button
		log.info("=========Test Case: Checkout Page Calculation Completed=========");
	}

	@Test(priority = 4)
	public void PriceVerification() throws InterruptedException {
		log.info("=========Test Case: Price Verification Started=========");
		CheckOutPage Checkout = new CheckOutPage(driver);
		AddtoCartPage atc = new AddtoCartPage(driver);

		String price1 = atc.getBackpackPrice().replace("$", "");
		String price2 = atc.getTshirtPrice().replace("$", "");
		String subtotal = Checkout.getSubtotal().replace("Item total: $", "");
		double item1 = Double.parseDouble(price1);
		double item2 = Double.parseDouble(price2);
		double subtotalvalue = Double.parseDouble(subtotal);
		double totalitemvalue = item1 + item2;
		Assert.assertEquals(totalitemvalue, subtotalvalue, "Item total value mismatch");
		log.info("Price verification successful");
		log.info("=========Test Case: Price Verification Completed=========");
	}

	@Test(priority = 5)
	public void TaxVerificatione() throws InterruptedException {
		log.info("=========Test Case: Tax Verification Started=========");
		CheckOutPage checkout = new CheckOutPage(driver);
		String subtotal = checkout.getSubtotal().replace("Item total: $", "");
		double subtotalvalue = Double.parseDouble(subtotal);
		System.out.println("Subtotal value is: " + subtotalvalue);
		double taxamount = Math.round(subtotalvalue * 8.01) / 100.00;
		String taxdisplayed = checkout.getTax().replace("Tax: $", "");
		
		double taxdisplayedvalue = Double.parseDouble(taxdisplayed);
		Assert.assertEquals(taxamount, taxdisplayedvalue, "Tax amount mismatch");
		log.info("Tax verification successful");
		log.info("=========Test Case: Tax Verification Completed=========");
	}

	@AfterTest
	public void teardown() throws Exception {
		log.info("Closing the browser");
	//	MonteScreenRecorderUtil.stopRecording();
		driver.close();
		log.info("Browser closed");
	}

}