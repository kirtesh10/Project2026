package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddtoCartPage {

	public WebDriver driver;

	public AddtoCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	} 

	@FindBy(id = "add-to-cart-sauce-labs-backpack")
	WebElement addToCartButtone;

	@FindBy(id = "add-to-cart-sauce-labs-bike-light")

	WebElement addToCartBikeLight;

	@FindBy(xpath = "//button[@name='add-to-cart-sauce-labs-bolt-t-shirt']")
	WebElement addToCartBoltTShirt;

	@FindBy(xpath = "//span[@class='shopping_cart_badge']")
	WebElement totalItemsInCart;

	@FindBy(xpath = "//span[@class='shopping_cart_badge']")
	WebElement totalItemsInCartClick;

	@FindBy(id = "remove-sauce-labs-bike-light")
	WebElement removeBikeLightButton;

	@FindBy(xpath = "//div[text()='29.99']")
	WebElement backpackPrice;

	@FindBy(xpath = "//div[text()='15.99']")
	WebElement tshirtPrice;

	public void addToCartBackpack() {
		addToCartButtone.click();
	}

	public void addToCartBikeLight() {
		addToCartBikeLight.click();
	}

	public void addToCartBoltTShirt() {
		addToCartBoltTShirt.click();
	}

	public String getTotalItemsInCart() {
		return totalItemsInCart.getText();
	}

	public void getTotalItemsInCartClick() {
		totalItemsInCartClick.click();
	}

	public void removelight() {
		removeBikeLightButton.click();
	}

	public String getBackpackPrice() {
		return backpackPrice.getText();
	}

	public String getTshirtPrice() {
		return tshirtPrice.getText();
	}
}