package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageTitle {

	public WebDriver driver;

	public HomePageTitle(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // Initialize PageFactory
	}

	@FindBy(css = "#header_container > div.primary_header > div.header_label > div")
	WebElement homeTitle;

	@FindBy(css = "#header_container > div.header_secondary_container > span")
	WebElement productsTitle;

	public String getHomeTitle() {
		return homeTitle.getText();
	}

	public String getProductsTitle() {
		return productsTitle.getText();
	}

}
