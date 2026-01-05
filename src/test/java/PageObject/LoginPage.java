package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;

	// public LoginPage() {
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // Initialize PageFactory
		// super();

	}

	@FindBy(name = "user-name")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(id = "login-button")
	WebElement loginBtn;

	public void enterusername() {
		username.sendKeys("standard_user");

	}

	public void enterpassword() {
		password.sendKeys("secret_sauce");
	}

	public void clicklogin() {
		loginBtn.click();
	}

}