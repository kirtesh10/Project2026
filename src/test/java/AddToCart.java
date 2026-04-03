import java.awt.AWTException;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import BasePackage.Base;
import PageObject.AddtoCartPage;
import PageObject.LoginPage;

public class AddToCart extends Base {
	public static Logger log = LogManager.getLogger(AddToCart.class.getName());
	public WebDriver driver;

	@Test
	// git check
	public void AddtoCartCheck() throws IOException, InterruptedException, AWTException {

		driver = initializerDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home page");
		LoginPage lp = new LoginPage(driver);
		AddtoCartPage atc = new AddtoCartPage(driver);
		Thread.sleep(2000);
		lp.enterusername(); // enter username
		Thread.sleep(2000);
		lp.enterpassword();// enter password
		Thread.sleep(2000);
		lp.clicklogin(); // click login button
		Thread.sleep(2000);
		log.info("Login Successful");
		driver.manage().window().maximize();
		atc.addToCartBackpack();// add backpack to cart
		Thread.sleep(2000);
		atc.addToCartBikeLight();// add bike light to cart
		Thread.sleep(2000);
		atc.addToCartBoltTShirt();// add bolt t shirt to cart
		Thread.sleep(2000);
		String totalitem = atc.getTotalItemsInCart();// get total items in cart
		Assert.assertEquals(totalitem, "3");
		System.out.println("Total items in cart: " + totalitem + " is equal to 3");
		atc.getTotalItemsInCartClick();// click on cart icon
	}

	@Test
	public void YourCart() {
		log.info("Verifying items in your cart");
		AddtoCartPage atc = new AddtoCartPage(driver);
		atc.removelight(); // remove bike light from cart
		String Price = atc.getBackpackPrice(); // get price of backpack
		System.out.println("Price of Backpack is: " + Price); // print price of backpack
		String TshirtPrice = atc.getTshirtPrice(); // get price of t shirt
		System.out.println("Price of T shirt is: " + TshirtPrice); // print price of t shirt
		Assert.assertEquals(Price, "$29.99");
		Assert.assertEquals(TshirtPrice, "$15.99");
		log.info("Prices are verified");

	}

	@AfterTest
	public void teardown() {
		log.info("Closing the browser");
		driver.close();
		log.info("Browser closed");
	}

}
