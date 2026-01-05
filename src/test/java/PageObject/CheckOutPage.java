package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {

	public WebDriver driver;

	public CheckOutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // Initialize PageFactory
	}

	@FindBy(id = "checkout")
	WebElement checkoutButton;

	@FindBy(id = "first-name")
	WebElement firstNameField;

	@FindBy(id = "last-name")
	WebElement lastNameField;

	@FindBy(id = "postal-code")
	WebElement postalCodeField;

	@FindBy(id = "continue")
	WebElement continueButton;

	@FindBy(xpath = "//div[@class='summary_subtotal_label']")
	WebElement subtotalLabel;

	@FindBy(xpath = "//div[@class='summary_tax_label']")
	WebElement taxonLabel;

	public void clickCheckout() {
		checkoutButton.click();
	}

	public void firstname() {
		firstNameField.sendKeys("John");
	}

	public void lastname() {
		lastNameField.sendKeys("Doe");
	}

	public void postalcode() {
		postalCodeField.sendKeys("12345");
	}

	public void clickContinue() {
		continueButton.click();
	}

	public String getSubtotal() {
		return subtotalLabel.getText();
	}

	public String getTax() {
		return taxonLabel.getText();
	}

}